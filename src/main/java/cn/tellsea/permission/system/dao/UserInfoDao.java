package cn.tellsea.permission.system.dao;

import cn.tellsea.permission.system.entity.UserInfo;
import cn.tellsea.permission.system.vo.UserInfoVo;
import cn.tellsea.walnut.base.dao.BaseDao;

import java.util.List;

/**
 * 用户表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface UserInfoDao extends BaseDao<UserInfo> {

    /**
     * 表格计数
     *
     * @param userInfoVo
     * @return
     */
    int countUserInfo(UserInfoVo userInfoVo);

    /**
     * 表格数据
     *
     * @param userInfoVo
     * @return
     */
    List<UserInfoVo> listUserInfo(UserInfoVo userInfoVo);

    /**
     * 根据id查询
     *
     * @param userInfoVo
     * @return
     */
    UserInfoVo getUserInfoById(UserInfoVo userInfoVo);

}
