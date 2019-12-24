package cn.tellsea.permission.log.service.impl;

import cn.tellsea.permission.log.dao.LoginLogDao;
import cn.tellsea.permission.log.entity.LoginLog;
import cn.tellsea.permission.log.service.LoginLogService;
import cn.tellsea.permission.log.vo.LoginLogVo;
import cn.tellsea.walnut.base.service.impl.BaseServiceImpl;
import cn.tellsea.walnut.plugins.element.ElementTable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service接口实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, LoginLogDao> implements LoginLogService {

    @Override
    public ElementTable listLoginLog(LoginLogVo loginLogVo) {
        int count = baseDao.countLoginLog(loginLogVo);
        List<LoginLogVo> list = null;
        if (count > 0) {
            list = baseDao.listLoginLog(loginLogVo);
        }
        return ElementTable.build(count, list);
    }
}