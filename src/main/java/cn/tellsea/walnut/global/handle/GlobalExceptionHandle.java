package cn.tellsea.walnut.global.handle;

import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.global.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Slf4j
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception e, Model model) {
        model.addAttribute("code", e.getClass());
        model.addAttribute("info", e.getMessage());
        log.error("【错误原因】{}", e.getClass());
        log.error("【错误描述】{}", e.getMessage());
        e.printStackTrace();
        return ResponseResult.build(StatusEnums.SERVER_ERROR);
    }

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ResponseResult globalExceptionHandle(GlobalException e, Model model) {
        model.addAttribute("code", e.getBaseEnums().getCode());
        model.addAttribute("info", e.getBaseEnums().getInfo());
        log.error("【错误原因】{}", e.getClass());
        log.error("【错误描述】{}", e.getMessage());
        e.printStackTrace();
        return ResponseResult.build(StatusEnums.SERVER_ERROR);
    }
}
