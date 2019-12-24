package cn.tellsea.permission.system.service.impl;

import cn.tellsea.permission.system.dao.RoleInfoDao;
import cn.tellsea.permission.system.entity.MapRoleResource;
import cn.tellsea.permission.system.entity.RoleInfo;
import cn.tellsea.permission.system.mapper.MapRoleResourceMapper;
import cn.tellsea.permission.system.service.RoleInfoService;
import cn.tellsea.permission.system.vo.RoleInfoVo;
import cn.tellsea.walnut.base.service.impl.BaseServiceImpl;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.plugins.element.ElementTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Service
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfo, RoleInfoDao> implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;
    @Autowired
    private MapRoleResourceMapper mapRoleResourceMapper;

    @Override
    public List<String> listRoleInfoByUserId(Integer userId) {
        return baseDao.listRoleInfoByUserId(userId);
    }

    @Override
    public ElementTable listRoleInfo(RoleInfoVo roleInfoVo) {
        int count = roleInfoDao.countRoleInfo(roleInfoVo);
        List<RoleInfoVo> list = null;
        if (count > 0) {
            list = roleInfoDao.listRoleInfo(roleInfoVo);
        }
        return ElementTable.build(count, list);
    }

    @Override
    public ResponseResult saveRoleInfo(RoleInfoVo roleInfoVo) {
        baseMapper.insertSelective(roleInfoVo);
        String[] split = roleInfoVo.getResourceIds().split(",");
        List<MapRoleResource> list = new ArrayList<>();
        MapRoleResource mapRoleResource;
        for (int i = 0; i < split.length; i++) {
            mapRoleResource = new MapRoleResource();
            mapRoleResource.setRoleId(roleInfoVo.getId());
            mapRoleResource.setResourceId(Integer.valueOf(split[i]));
            list.add(mapRoleResource);
        }
        mapRoleResourceMapper.insertList(list);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    @Override
    public ResponseResult updateRoleInfo(RoleInfoVo roleInfoVo) {
        baseMapper.updateByPrimaryKeySelective(roleInfoVo);
        Example example = new Example(MapRoleResource.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleInfoVo.getId());
        mapRoleResourceMapper.deleteByExample(example);
        String[] split = roleInfoVo.getResourceIds().split(",");
        List<MapRoleResource> list = new ArrayList<>();
        MapRoleResource mapRoleResource;
        for (int i = 0; i < split.length; i++) {
            mapRoleResource = new MapRoleResource();
            mapRoleResource.setRoleId(roleInfoVo.getId());
            mapRoleResource.setResourceId(Integer.valueOf(split[i]));
            list.add(mapRoleResource);
        }
        mapRoleResourceMapper.insertList(list);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    @Override
    public ResponseResult getRoleInfoById(RoleInfoVo roleInfoVo) {
        return ResponseResult.build(StatusEnums.SELECT_SUCCESS, roleInfoDao.getRoleInfoById(roleInfoVo));
    }

    @Override
    public ResponseResult deleteRoleInfo(RoleInfoVo roleInfoVo) {
        baseMapper.deleteByPrimaryKey(roleInfoVo);
        Example example = new Example(MapRoleResource.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleInfoVo.getId());
        mapRoleResourceMapper.deleteByExample(example);
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }
}
