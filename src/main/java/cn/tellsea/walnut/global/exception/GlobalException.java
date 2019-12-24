package cn.tellsea.walnut.global.exception;

import cn.tellsea.walnut.base.enums.BaseEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {

    private BaseEnums baseEnums;
}
