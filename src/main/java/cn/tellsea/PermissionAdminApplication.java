package cn.tellsea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 前后端分离权限管理系统（web端）
 *
 * @author Tellsea
 * @date 2019/12/15
 */
@SpringBootApplication
@MapperScan("cn.tellsea.permission.*.mapper")
public class PermissionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionAdminApplication.class, args);
    }

}
