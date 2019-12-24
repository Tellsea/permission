package cn.tellsea.permission.log.service.impl;

import cn.tellsea.permission.log.dao.SystemLogDao;
import cn.tellsea.permission.log.entity.SystemLog;
import cn.tellsea.permission.log.service.SystemLogService;
import cn.tellsea.permission.log.vo.SystemLogVo;
import cn.tellsea.walnut.base.service.impl.BaseServiceImpl;
import cn.tellsea.walnut.plugins.element.ElementTable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统日志表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Service
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog, SystemLogDao> implements SystemLogService {

    @Override
    public ElementTable listSystemLog(SystemLogVo systemLogVo) {
        int count = baseDao.countSystemLog(systemLogVo);
        List<SystemLogVo> list = null;
        if (count > 0) {
            list = baseDao.listSystemLog(systemLogVo);
        }
        return ElementTable.build(count, list);
    }
}