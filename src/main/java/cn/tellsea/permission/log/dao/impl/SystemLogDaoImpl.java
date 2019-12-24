package cn.tellsea.permission.log.dao.impl;

import cn.tellsea.permission.log.dao.SystemLogDao;
import cn.tellsea.permission.log.entity.SystemLog;
import cn.tellsea.permission.log.vo.SystemLogVo;
import cn.tellsea.walnut.base.dao.impl.BaseDaoImpl;
import cn.tellsea.walnut.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统日志表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Repository
public class SystemLogDaoImpl extends BaseDaoImpl<SystemLog> implements SystemLogDao {

    @Override
    public int countSystemLog(SystemLogVo systemLogVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) from system_log as a ");
        sql.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(systemLogVo.getSearchTime())) {
            String[] split = systemLogVo.getSearchTime().split(",");
            sql.append(" and a.create_time between '").append(DateUtils.completTimeBefor(split[0])).append("' and '").append(DateUtils.completTimeAfter(split[1])).append("' ");
        }
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    @Override
    public List<SystemLogVo> listSystemLog(SystemLogVo systemLogVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.id, a.user_id, a.operation, a.time, a.method, a.params, a.ip, ");
        sql.append(" a.create_time, a.location, b.user_name ");
        sql.append(" from system_log as a ");
        sql.append(" left join user_info b on a.user_id = b.id ");
        sql.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(systemLogVo.getSearchTime())) {
            String[] split = systemLogVo.getSearchTime().split(",");
            sql.append(" and a.create_time between '").append(DateUtils.completTimeBefor(split[0])).append("' and '").append(DateUtils.completTimeAfter(split[1])).append("' ");
        }
        sql.append(" order by a.create_time desc ");
        sql.append(" limit ?, ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{systemLogVo.getOffset(), systemLogVo.getLimit()}, new BeanPropertyRowMapper<>(SystemLogVo.class));
    }
}
