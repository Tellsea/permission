package cn.tellsea.walnut.plugins.element;

import cn.tellsea.walnut.global.enums.StatusEnums;
import lombok.Getter;
import lombok.Setter;

/**
 * element table
 *
 * @author: Tellsea
 * @date : 2019/12/16
 */
@Getter
@Setter
public class ElementTable {

    private int code;

    private String message;

    private int count;

    private Object data;

    public static ElementTable build(int count, Object data) {
        ElementTable table = new ElementTable();
        table.setCode(StatusEnums.SELECT_SUCCESS.getCode());
        table.setMessage(StatusEnums.SELECT_SUCCESS.getInfo());
        table.setCount(count);
        table.setData(data);
        return table;
    }
}
