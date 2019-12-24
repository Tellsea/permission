package ${package.ServiceImpl};

import ${cfg.Dao}.${entity}Dao;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * ${table.comment!} Service接口实现类
 *
 * @author ${author}
 * @date ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${entity}, ${entity}Dao> implements ${table.serviceName} {

}