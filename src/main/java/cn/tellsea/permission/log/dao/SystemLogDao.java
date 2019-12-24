package cn.tellsea.permission.log.dao;

import cn.tellsea.permission.log.entity.SystemLog;
import cn.tellsea.permission.log.vo.SystemLogVo;
import cn.tellsea.walnut.base.dao.BaseDao;

import java.util.List;

/**
 * 系统日志表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface SystemLogDao extends BaseDao<SystemLog> {

    /**
     * 表格计数
     *
     * @param systemLogVo
     * @return
     */
    int countSystemLog(SystemLogVo systemLogVo);

    /**
     * 表格数据
     *
     * @param systemLogVo
     * @return
     */
    List<SystemLogVo> listSystemLog(SystemLogVo systemLogVo);
}
