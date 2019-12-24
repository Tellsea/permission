package cn.tellsea.walnut.dto;

import cn.tellsea.permission.system.vo.UserInfoVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * session 保存的用户角色权限信息
 *
 * @author: Tellsea
 * @date: 2019/09/11
 */
@Getter
@Setter
public class UserInfoSession extends UserInfoVo {

    /**
     * 角色列表
     */
    List<String> roleInfoList;

    /**
     * 权限列表
     */
    List<String> resourceInfoList;
}
