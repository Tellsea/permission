package cn.tellsea.permission.log.dao.impl;

import cn.tellsea.permission.log.dao.LoginLogDao;
import cn.tellsea.permission.log.entity.LoginLog;
import cn.tellsea.permission.log.vo.LoginLogVo;
import cn.tellsea.walnut.base.dao.impl.BaseDaoImpl;
import cn.tellsea.walnut.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Repository
public class LoginLogDaoImpl extends BaseDaoImpl<LoginLog> implements LoginLogDao {

    @Override
    public int countLoginLog(LoginLogVo loginLogVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) from login_log as a ");
        sql.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(loginLogVo.getSearchTime())) {
            String[] split = loginLogVo.getSearchTime().split(",");
            sql.append(" and a.create_time between '").append(DateUtils.completTimeBefor(split[0])).append("' and '").append(DateUtils.completTimeAfter(split[1])).append("' ");
        }
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    @Override
    public List<LoginLogVo> listLoginLog(LoginLogVo loginLogVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.id, a.user_id, a.ip, a.location, a.create_time, a.device, a.`code`, a.message, b.user_name ");
        sql.append(" from login_log as a ");
        sql.append(" left join user_info b on a.user_id = b.id ");
        sql.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(loginLogVo.getSearchTime())) {
            String[] split = loginLogVo.getSearchTime().split(",");
            sql.append(" and a.create_time between '").append(DateUtils.completTimeBefor(split[0])).append("' and '").append(DateUtils.completTimeAfter(split[1])).append("' ");
        }
        sql.append(" order by a.create_time desc ");
        sql.append(" limit ?, ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{loginLogVo.getOffset(), loginLogVo.getLimit()}, new BeanPropertyRowMapper<>(LoginLogVo.class));
    }
}
