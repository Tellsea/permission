package cn.tellsea.permission.log.vo;

import cn.tellsea.permission.log.entity.LoginLog;
import lombok.Getter;
import lombok.Setter;

/**
 * Vo类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class LoginLogVo extends LoginLog {

    private String userName;

    private String ids;

    private String searchTime;
}
