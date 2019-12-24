package cn.tellsea.walnut.dto;

import cn.tellsea.walnut.base.enums.BaseEnums;
import lombok.Data;

import java.io.Serializable;

/**
 * 全局返回结果集
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Data
public class ResponseResult implements Cloneable, Serializable {

    private int code;
    private String message;
    private Object data;

    public static ResponseResult build(BaseEnums enums) {
        ResponseResult result = new ResponseResult();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = null;
        return result;
    }

    public static ResponseResult build(BaseEnums enums, Object data) {
        ResponseResult result = new ResponseResult();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = data;
        return result;
    }
}
