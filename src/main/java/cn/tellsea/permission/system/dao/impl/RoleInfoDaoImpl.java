package cn.tellsea.permission.system.dao.impl;

import cn.tellsea.permission.system.dao.RoleInfoDao;
import cn.tellsea.permission.system.entity.RoleInfo;
import cn.tellsea.permission.system.vo.RoleInfoVo;
import cn.tellsea.walnut.base.dao.impl.BaseDaoImpl;
import cn.tellsea.walnut.util.SqlUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Repository
public class RoleInfoDaoImpl extends BaseDaoImpl<RoleInfo> implements RoleInfoDao {

    @Override
    public List<String> listRoleInfoByUserId(Integer userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select b.`name` from map_user_role a ");
        sql.append(" left join role_info b on a.role_id = b.id ");
        sql.append(" where a.user_id = ? ");
        return jdbcTemplate.queryForList(sql.toString(), new Object[]{userId}, String.class);
    }

    @Override
    public int countRoleInfo(RoleInfoVo roleInfoVo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(*) from role_info as a ");
        sql.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(roleInfoVo.getName())) {
            sql.append(" and a.name like ").append(SqlUtils.like(roleInfoVo.getName()));
        }
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    @Override
    public List<RoleInfoVo> listRoleInfo(RoleInfoVo roleInfoVo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select a.id, a.`name`, a.description, ");
        sql.append(" group_concat(c.id) resource_ids, group_concat(c.`name`) resource_name ");
        sql.append(" from role_info as a ");
        sql.append(" left join map_role_resource b on a.id = b.role_id ");
        sql.append(" left join resource_info c on b.resource_id = c.id ");
        sql.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(roleInfoVo.getName())) {
            sql.append(" and a.name like ").append(SqlUtils.like(roleInfoVo.getName()));
        }
        sql.append(" group by a.id ");
        sql.append(" limit ?, ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{roleInfoVo.getOffset(), roleInfoVo.getLimit()}, new BeanPropertyRowMapper<>(RoleInfoVo.class));
    }

    @Override
    public RoleInfoVo getRoleInfoById(RoleInfoVo roleInfoVo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select a.id, a.`name`, a.description, ");
        sql.append(" group_concat(c.id) resource_ids, group_concat(c.`name`) resource_name ");
        sql.append(" from role_info as a ");
        sql.append(" left join map_role_resource b on a.id = b.role_id ");
        sql.append(" left join resource_info c on b.resource_id = c.id ");
        sql.append(" where a.id = ? ");
        List<RoleInfoVo> list = jdbcTemplate.query(sql.toString(), new Object[]{roleInfoVo.getId()}, new BeanPropertyRowMapper<>(RoleInfoVo.class));
        return (CollectionUtils.isEmpty(list)) ? null : list.get(0);
    }
}
