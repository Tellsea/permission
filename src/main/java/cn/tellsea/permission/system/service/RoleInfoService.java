package cn.tellsea.permission.system.service;

import cn.tellsea.permission.system.entity.RoleInfo;
import cn.tellsea.permission.system.vo.RoleInfoVo;
import cn.tellsea.walnut.base.service.BaseService;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.plugins.element.ElementTable;

import java.util.List;

/**
 * 角色表 Service接口
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface RoleInfoService extends BaseService<RoleInfo> {

    /**
     * 更具用户id，查询所有角色
     *
     * @param userId
     * @return
     */
    List<String> listRoleInfoByUserId(Integer userId);

    /**
     * 表格数据
     *
     * @param roleInfoVo
     * @return
     */
    ElementTable listRoleInfo(RoleInfoVo roleInfoVo);

    /**
     * 新增
     *
     * @param roleInfoVo
     * @return
     */
    ResponseResult saveRoleInfo(RoleInfoVo roleInfoVo);

    /**
     * 更新
     *
     * @param roleInfoVo
     * @return
     */
    ResponseResult updateRoleInfo(RoleInfoVo roleInfoVo);

    /**
     * 根据id查询
     *
     * @param roleInfoVo
     * @return
     */
    ResponseResult getRoleInfoById(RoleInfoVo roleInfoVo);

    /**
     * 删除
     *
     * @param roleInfoVo
     * @return
     */
    ResponseResult deleteRoleInfo(RoleInfoVo roleInfoVo);
}
