package cn.tellsea.walnut.global.enums;

import cn.tellsea.walnut.base.enums.BaseEnums;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * 异常枚举类
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@AllArgsConstructor
public enum StatusEnums implements BaseEnums {

    /**
     * 业务枚举
     */
    OK(200, "OK"),
    SAVE_SUCCESS(200, "新增成功"),
    DELETE_SUCCESS(200, "删除成功"),
    UPDATE_SUCCESS(200, "更新成功"),
    SELECT_SUCCESS(200, "查询成功"),
    SAVE_ERROR(500, "新增失败，请检查网络是否稳定？"),
    DELETE_ERROR(500, "删除失败，请检查网络是否稳定？"),
    UPDATE_ERROR(500, "更新失败，请检查网络是否稳定？"),
    SELECT_ERROR(500, "查询失败，请检查网络是否稳定？"),
    /**
     * 系统枚举
     */
    LOGIN_SUCCESS(200, "登录成功"),
    NOT_LOGIN(500, "未登录"),
    UNAUTHORIZED(403, "未授权"),
    TOKEN_NOT_FOUND(500, "回话已过期，请重新登录"),
    NOT_FOUND(404, "请求资源不存在"),
    USER_ALREADY_EXISTS(500, "用户已存在"),
    USER_NOT_FOUND(500, "用户不存在"),
    PARAM_NOT_NULL(500, "参数不能为空"),
    CAPTCHA_ERROR(500, "验证码错误"),
    PASSWORD_ERROR(500, "密码错误"),
    LOCKED_ACCOUNT_ERROR(500, "该账户已经被锁定，请联系管理员"),
    SERVER_ERROR(500, "服务器累了，休息一会吧!"),
    ;

    @Setter
    private int code;

    @Setter
    private String info;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
