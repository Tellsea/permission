package cn.tellsea.permission.system.service.impl;

import cn.tellsea.permission.system.dao.ResourceInfoDao;
import cn.tellsea.permission.system.entity.MapRoleResource;
import cn.tellsea.permission.system.entity.MapUserRole;
import cn.tellsea.permission.system.entity.ResourceInfo;
import cn.tellsea.permission.system.mapper.MapRoleResourceMapper;
import cn.tellsea.permission.system.mapper.MapUserRoleMapper;
import cn.tellsea.permission.system.service.ResourceInfoService;
import cn.tellsea.permission.system.vo.ResourceInfoVo;
import cn.tellsea.walnut.base.service.impl.BaseServiceImpl;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Service
public class ResourceInfoServiceImpl extends BaseServiceImpl<ResourceInfo, ResourceInfoDao> implements ResourceInfoService {

    @Autowired
    private MapRoleResourceMapper mapRoleResourceMapper;
    @Autowired
    private ResourceInfoDao resourceInfoDao;
    @Autowired
    private MapUserRoleMapper mapUserRoleMapper;

    @Override
    public List<String> listResourceInfoByUserId(Integer userId) {
        return baseDao.listResourceInfoByUserId(userId);
    }

    @Override
    public ResponseResult listResourceInfoByTree() {
        List<ResourceInfo> rootList = baseMapper.selectAll();
        return ResponseResult.build(StatusEnums.SELECT_SUCCESS, createTree(0, rootList));
    }

    @Override
    public List<ResourceInfoVo> listResourceInfoByMenu(Integer userId) {
        // 根据用户id查询角色ids
        Example example = new Example(MapUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        List<MapUserRole> mapUserRoles = mapUserRoleMapper.selectByExample(example);
        List<Integer> roleIds = new ArrayList<>();
        for (MapUserRole mapUserRole : mapUserRoles) {
            roleIds.add(mapUserRole.getRoleId());
        }
        List<ResourceInfo> rootList = resourceInfoDao.listResourceInfoByMenu(StringUtils.join(roleIds, ","));
        return createTree(0, rootList);
    }

    private List<ResourceInfoVo> createTree(Integer pid, List<ResourceInfo> rootList) {
        List<ResourceInfoVo> treeList = new ArrayList<>();
        ResourceInfoVo resourceInfoVo;
        for (ResourceInfo info : rootList) {
            if (pid.equals(info.getPid())) {
                resourceInfoVo = new ResourceInfoVo();
                BeanUtils.copyProperties(info, resourceInfoVo);
                resourceInfoVo.setChildren(createTree(info.getId(), rootList));
                treeList.add(resourceInfoVo);
            }
        }
        return treeList;
    }

    @Override
    public ResponseResult saveResourceInfo(ResourceInfo resourceInfo) {
        baseMapper.insertSelective(resourceInfo);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    @Override
    public ResponseResult updateResourceInfo(ResourceInfo resourceInfo) {
        baseMapper.updateByPrimaryKeySelective(resourceInfo);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    @Override
    public ResponseResult getResourceInfoById(ResourceInfo resourceInfo) {
        return ResponseResult.build(StatusEnums.SELECT_SUCCESS, baseMapper.selectByPrimaryKey(resourceInfo.getId()));
    }

    @Override
    public ResponseResult deleteResourceInfo(ResourceInfo resourceInfo) {
        baseMapper.deleteByPrimaryKey(resourceInfo.getId());
        Example deleteExample = new Example(MapRoleResource.class);
        Example.Criteria criteriaDelete = deleteExample.createCriteria();
        criteriaDelete.andEqualTo("resourceId", resourceInfo.getId());
        mapRoleResourceMapper.deleteByExample(deleteExample);
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }
}
