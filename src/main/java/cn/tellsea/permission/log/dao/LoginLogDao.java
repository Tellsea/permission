package cn.tellsea.permission.log.dao;

import cn.tellsea.permission.log.entity.LoginLog;
import cn.tellsea.permission.log.vo.LoginLogVo;
import cn.tellsea.walnut.base.dao.BaseDao;

import java.util.List;

/**
 * Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface LoginLogDao extends BaseDao<LoginLog> {

    /**
     * 表格计数
     *
     * @param loginLogVo
     * @return
     */
    int countLoginLog(LoginLogVo loginLogVo);

    /**
     * 表格数据
     *
     * @param loginLogVo
     * @return
     */
    List<LoginLogVo> listLoginLog(LoginLogVo loginLogVo);
}
