package cn.tellsea.permission.log.vo;

import cn.tellsea.permission.log.entity.SystemLog;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统日志表 Vo类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class SystemLogVo extends SystemLog {

    private String userName;

    private String ids;

    private String searchTime;
}
