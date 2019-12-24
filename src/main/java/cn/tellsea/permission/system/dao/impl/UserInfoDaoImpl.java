package cn.tellsea.permission.system.dao.impl;

import cn.tellsea.permission.system.dao.UserInfoDao;
import cn.tellsea.permission.system.entity.UserInfo;
import cn.tellsea.permission.system.vo.UserInfoVo;
import cn.tellsea.walnut.base.dao.impl.BaseDaoImpl;
import cn.tellsea.walnut.util.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

    @Override
    public int countUserInfo(UserInfoVo userInfoVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) from user_info as a ");
        sql.append(" where a.id <> 1 and a.status <> 3 ");
        if (StringUtils.isNotEmpty(userInfoVo.getUserName())) {
            sql.append(" and a.user_name like ").append(SqlUtils.like(userInfoVo.getUserName()));
        }
        if (StringUtils.isNotEmpty(userInfoVo.getNickName())) {
            sql.append(" and a.nick_name like ").append(SqlUtils.like(userInfoVo.getNickName()));
        }
        if (StringUtils.isNotEmpty(userInfoVo.getPhone())) {
            sql.append(" and a.phone like ").append(SqlUtils.like(userInfoVo.getPhone()));
        }
        if (SqlUtils.isNotEmpty(userInfoVo.getStatus())) {
            sql.append(" and a.status = ").append(userInfoVo.getStatus());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    @Override
    public List<UserInfoVo> listUserInfo(UserInfoVo userInfoVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.id, a.user_name, a.nick_name, a.avatar, a.phone, a.sex, ");
        sql.append(" a.description, a.create_user, a.create_time, a.login_times, a.last_login_time, a.`status`, ");
        sql.append(" b.user_name create_user_name, group_concat(d.id) role_ids, group_concat(d.`name`) role_name ");
        sql.append(" from user_info as a ");
        sql.append(" left join user_info b on a.create_user = b.id ");
        sql.append(" left join map_user_role c on a.id = c.user_id ");
        sql.append(" left join role_info d on c.role_id = d.id ");
        sql.append(" where a.id <> 1 and a.status <> 3 ");
        if (StringUtils.isNotEmpty(userInfoVo.getUserName())) {
            sql.append(" and a.user_name like ").append(SqlUtils.like(userInfoVo.getUserName()));
        }
        if (StringUtils.isNotEmpty(userInfoVo.getNickName())) {
            sql.append(" and a.nick_name like ").append(SqlUtils.like(userInfoVo.getNickName()));
        }
        if (StringUtils.isNotEmpty(userInfoVo.getPhone())) {
            sql.append(" and a.phone like ").append(SqlUtils.like(userInfoVo.getPhone()));
        }
        if (SqlUtils.isNotEmpty(userInfoVo.getStatus())) {
            sql.append(" and a.status = ").append(userInfoVo.getStatus());
        }
        sql.append(" group by a.id ");
        sql.append(" order by a.create_time desc ");
        sql.append(" limit ?, ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{userInfoVo.getOffset(), userInfoVo.getLimit()}, new BeanPropertyRowMapper<>(UserInfoVo.class));
    }

    @Override
    public UserInfoVo getUserInfoById(UserInfoVo userInfoVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.id, a.user_name, a.nick_name, a.avatar, a.phone, a.sex, ");
        sql.append(" a.description, a.create_user, a.create_time, a.login_times, a.last_login_time, a.`status`, ");
        sql.append(" b.user_name create_user_name, group_concat(d.id) role_ids, group_concat(d.`name`) role_name ");
        sql.append(" from user_info as a ");
        sql.append(" left join user_info b on a.create_user = b.id ");
        sql.append(" left join map_user_role c on a.id = c.user_id ");
        sql.append(" left join role_info d on c.role_id = d.id ");
        sql.append(" where a.id = ? ");
        List<UserInfoVo> list = jdbcTemplate.query(sql.toString(), new Object[]{userInfoVo.getId()}, new BeanPropertyRowMapper<>(UserInfoVo.class));
        return (CollectionUtils.isEmpty(list)) ? null : list.get(0);
    }
}
