package cn.tellsea.permission.system.service;

import cn.tellsea.permission.system.entity.UserInfo;
import cn.tellsea.permission.system.vo.UserInfoVo;
import cn.tellsea.walnut.base.service.BaseService;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.plugins.element.ElementTable;

/**
 * 用户表 Service接口
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
     * 表格数据
     *
     * @param userInfoVo
     * @return
     */
    ElementTable listUserInfo(UserInfoVo userInfoVo);

    /**
     * 新增
     *
     * @param userInfoVo
     * @return
     */
    ResponseResult saveUserInfo(UserInfoVo userInfoVo);

    /**
     * 更新
     *
     * @param userInfoVo
     * @return
     */
    ResponseResult updateUserInfo(UserInfoVo userInfoVo);

    /**
     * 根据id查询
     *
     * @param userInfoVo
     * @return
     */
    ResponseResult getUserInfoById(UserInfoVo userInfoVo);

    /**
     * 根据id删除
     *
     * @param userInfoVo
     * @return
     */
    ResponseResult deleteUserInfo(UserInfoVo userInfoVo);

}
