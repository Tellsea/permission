package cn.tellsea.permission.system.dao;

import cn.tellsea.permission.system.entity.ResourceInfo;
import cn.tellsea.walnut.base.dao.BaseDao;

import java.util.List;

/**
 * 资源表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface ResourceInfoDao extends BaseDao<ResourceInfo> {

    /**
     * 根据用户id，查询所有权限
     *
     * @param userId
     * @return
     */
    List<String> listResourceInfoByUserId(Integer userId);

    /**
     * 根据多个角色id查询
     *
     * @param roleIds
     * @return
     */
    List<ResourceInfo> listResourceInfoByMenu(String roleIds);

}
