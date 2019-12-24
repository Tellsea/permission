package cn.tellsea.permission.log.service;

import cn.tellsea.permission.log.entity.SystemLog;
import cn.tellsea.permission.log.vo.SystemLogVo;
import cn.tellsea.walnut.base.service.BaseService;
import cn.tellsea.walnut.plugins.element.ElementTable;

/**
 * 系统日志表 Service接口
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface SystemLogService extends BaseService<SystemLog> {

    /**
     * 表格数据
     *
     * @param systemLogVo
     * @return
     */
    ElementTable listSystemLog(SystemLogVo systemLogVo);
}