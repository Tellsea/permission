package cn.tellsea.permission.log.service;

import cn.tellsea.permission.log.entity.LoginLog;
import cn.tellsea.permission.log.vo.LoginLogVo;
import cn.tellsea.walnut.base.service.BaseService;
import cn.tellsea.walnut.plugins.element.ElementTable;

/**
 * Service接口
 *
 * @author Tellsea
 * @date 2019-12-15
 */
public interface LoginLogService extends BaseService<LoginLog> {

    /**
     * 数据表格
     *
     * @param loginLogVo
     * @return
     */
    ElementTable listLoginLog(LoginLogVo loginLogVo);
}