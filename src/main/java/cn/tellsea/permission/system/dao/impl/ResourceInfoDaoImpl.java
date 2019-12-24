package cn.tellsea.permission.system.dao.impl;

import cn.tellsea.permission.system.dao.ResourceInfoDao;
import cn.tellsea.permission.system.entity.ResourceInfo;
import cn.tellsea.walnut.base.dao.impl.BaseDaoImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Repository
public class ResourceInfoDaoImpl extends BaseDaoImpl<ResourceInfo> implements ResourceInfoDao {

    @Override
    public List<String> listResourceInfoByUserId(Integer userId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select distinct d.perms from map_user_role a ");
        sql.append(" left join role_info b on a.role_id = b.id ");
        sql.append(" left join map_role_resource c on b.id = c.role_id ");
        sql.append(" left join resource_info d on c.resource_id = d.id ");
        sql.append(" where a.user_id = ? ");
        return jdbcTemplate.queryForList(sql.toString(), new Object[]{userId}, String.class);
    }

    @Override
    public List<ResourceInfo> listResourceInfoByMenu(String roleIds) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select distinct c.id, c.`name`, c.pid, c.url, c.perms, c.type, c.icon, c.sort, c.is_leaf ");
        sql.append(" from role_info a ");
        sql.append(" left join map_role_resource b on a.id = b.role_id ");
        sql.append(" left join resource_info c on b.resource_id = c.id ");
        sql.append(" where c.type = 1 and a.id in (?) ");
        return jdbcTemplate.query(sql.toString(), new Object[]{roleIds}, new BeanPropertyRowMapper<>(ResourceInfo.class));
    }
}
