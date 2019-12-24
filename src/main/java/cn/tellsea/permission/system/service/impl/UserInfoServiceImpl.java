package cn.tellsea.permission.system.service.impl;

import cn.tellsea.permission.system.dao.UserInfoDao;
import cn.tellsea.permission.system.entity.MapUserRole;
import cn.tellsea.permission.system.entity.UserInfo;
import cn.tellsea.permission.system.mapper.MapUserRoleMapper;
import cn.tellsea.permission.system.service.UserInfoService;
import cn.tellsea.permission.system.vo.UserInfoVo;
import cn.tellsea.walnut.base.service.impl.BaseServiceImpl;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.plugins.element.ElementTable;
import cn.tellsea.walnut.shiro.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, UserInfoDao> implements UserInfoService {

    @Autowired
    private MapUserRoleMapper mapUserRoleMapper;
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public ElementTable listUserInfo(UserInfoVo userInfoVo) {
        int count = userInfoDao.countUserInfo(userInfoVo);
        List<UserInfoVo> list = null;
        if (count > 0) {
            list = userInfoDao.listUserInfo(userInfoVo);
        }
        return ElementTable.build(count, list);
    }

    @Override
    public ResponseResult saveUserInfo(UserInfoVo userInfoVo) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", userInfoVo.getUserName());
        UserInfo userInfoExist = baseMapper.selectOneByExample(example);
        if (null != userInfoExist) {
            return ResponseResult.build(StatusEnums.USER_ALREADY_EXISTS);
        }
//        UserInfoSession ui = (UserInfoSession) ShiroUtils.getCurrentUser();
        userInfoVo.setSalt(ShiroUtils.getRandomSalt());
        userInfoVo.setPassword(ShiroUtils.createPassword(userInfoVo.getPassword(), userInfoVo.getSalt()));
        userInfoVo.setCreateUser(1);
        userInfoVo.setCreateTime(new Date());
        baseMapper.insertSelective(userInfoVo);
        List<MapUserRole> list = new ArrayList<>();
        String[] split = userInfoVo.getRoleIds().split(",");
        MapUserRole mapUserRole;
        for (int i = 0; i < split.length; i++) {
            mapUserRole = new MapUserRole();
            mapUserRole.setUserId(userInfoVo.getId());
            mapUserRole.setRoleId(Integer.valueOf(split[i]));
            list.add(mapUserRole);
        }
        mapUserRoleMapper.insertList(list);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    @Override
    public ResponseResult updateUserInfo(UserInfoVo userInfoVo) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", userInfoVo.getUserName());
        UserInfo userInfoExist = baseMapper.selectOneByExample(example);
        if (null != userInfoExist && !userInfoExist.getId().equals(userInfoVo.getId())) {
            return ResponseResult.build(StatusEnums.USER_ALREADY_EXISTS);
        }
        baseMapper.updateByPrimaryKeySelective(userInfoVo);
        Example deleteExample = new Example(MapUserRole.class);
        Example.Criteria criteriaDelete = deleteExample.createCriteria();
        criteriaDelete.andEqualTo("userId", userInfoVo.getId());
        mapUserRoleMapper.deleteByExample(deleteExample);
        List<MapUserRole> list = new ArrayList<>();
        String[] split = userInfoVo.getRoleIds().split(",");
        MapUserRole mapUserRole;
        for (int i = 0; i < split.length; i++) {
            mapUserRole = new MapUserRole();
            mapUserRole.setUserId(userInfoVo.getId());
            mapUserRole.setRoleId(Integer.valueOf(split[i]));
            list.add(mapUserRole);
        }
        mapUserRoleMapper.insertList(list);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    @Override
    public ResponseResult getUserInfoById(UserInfoVo userInfoVo) {
        return ResponseResult.build(StatusEnums.SELECT_SUCCESS, userInfoDao.getUserInfoById(userInfoVo));
    }

    @Override
    public ResponseResult deleteUserInfo(UserInfoVo userInfoVo) {
        baseMapper.updateByPrimaryKeySelective(userInfoVo);
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }
}
