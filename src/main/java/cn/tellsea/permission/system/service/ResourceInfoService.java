package cn.tellsea.permission.system.service;

import cn.tellsea.permission.system.entity.ResourceInfo;
import cn.tellsea.permission.system.vo.ResourceInfoVo;
import cn.tellsea.walnut.base.service.BaseService;
import cn.tellsea.walnut.dto.ResponseResult;

import java.util.List;

/**
 * 资源表 Service接口
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface ResourceInfoService extends BaseService<ResourceInfo> {

    /**
     * 根据用户id，查询所有权限
     *
     * @param userId
     * @return
     */
    List<String> listResourceInfoByUserId(Integer userId);

    /**
     * 查询资源树
     *
     * @return
     */
    ResponseResult listResourceInfoByTree();

    /**
     * 新增
     *
     * @param resourceInfo
     * @return
     */
    ResponseResult saveResourceInfo(ResourceInfo resourceInfo);

    /**
     * 更新
     *
     * @param resourceInfo
     * @return
     */
    ResponseResult updateResourceInfo(ResourceInfo resourceInfo);

    /**
     * 根据id查询
     *
     * @param resourceInfo
     * @return
     */
    ResponseResult getResourceInfoById(ResourceInfo resourceInfo);

    /**
     * 删除
     *
     * @param resourceInfo
     * @return
     */
    ResponseResult deleteResourceInfo(ResourceInfo resourceInfo);

    /**
     * 创建侧边栏
     *
     * @param userId
     * @return
     */
    List<ResourceInfoVo> listResourceInfoByMenu(Integer userId);
}
