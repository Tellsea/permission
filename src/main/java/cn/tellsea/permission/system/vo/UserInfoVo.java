package cn.tellsea.permission.system.vo;

import cn.tellsea.permission.system.entity.UserInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户表 Vo类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class UserInfoVo extends UserInfo {

    private String roleIds;

    private String roleName;
}
