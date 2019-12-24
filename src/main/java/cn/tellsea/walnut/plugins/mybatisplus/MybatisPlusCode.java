package cn.tellsea.walnut.plugins.mybatisplus;

import cn.tellsea.walnut.plugins.mybatisplus.config.MybatisPlusCodeConfig;

import javax.swing.*;

/**
 * 代码生成器
 *
 * @author Tellsea
 * @date 2019/7/22
 * 数据库时区问题解决方案
 * SHOW VARIABLES LIKE '%time_zone%'
 * SET GLOBAL time_zone='+8:00'
 */
public class MybatisPlusCode {

    public static void main(String[] args) {
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "当前操作: 生成代码，请确保生成的文件不存在，否则会覆盖！", "请选择", JOptionPane.YES_NO_OPTION);
        if (0 == showConfirmDialog) {
            String[] nameList = new String[]{
                    "user_info",
                    "map_user_role",
                    "role_info",
                    "map_role_resource",
                    "resource_info",
            };
            for (int i = 0; i < nameList.length; i++) {
                // projectName: 项目名，moduleName：模块名，author：作者
                MybatisPlusCodeConfig.codeGenerator("permission", "system", "Tellsea", nameList[i]);
            }
            nameList = null;
            nameList = new String[]{
                    "system_log",
                    "login_log"
            };
            for (int i = 0; i < nameList.length; i++) {
                // projectName: 项目名，moduleName：模块名，author：作者
                MybatisPlusCodeConfig.codeGenerator("permission", "log", "Tellsea", nameList[i]);
            }
        }
    }
}
