package cn.tellsea.permission.system.dao;

import cn.tellsea.permission.system.entity.RoleInfo;
import cn.tellsea.permission.system.vo.RoleInfoVo;
import cn.tellsea.walnut.base.dao.BaseDao;

import java.util.List;

/**
 * 角色表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface RoleInfoDao extends BaseDao<RoleInfo> {

    /**
     * 更具用户id，查询所有角色
     *
     * @param userId
     * @return
     */
    List<String> listRoleInfoByUserId(Integer userId);

    /**
     * 表格计数
     *
     * @param roleInfoVo
     * @return
     */
    int countRoleInfo(RoleInfoVo roleInfoVo);

    /**
     * 表格数据
     *
     * @param roleInfoVo
     * @return
     */
    List<RoleInfoVo> listRoleInfo(RoleInfoVo roleInfoVo);

    /**
     * 根据id查询
     *
     * @param roleInfoVo
     * @return
     */
    RoleInfoVo getRoleInfoById(RoleInfoVo roleInfoVo);
}
