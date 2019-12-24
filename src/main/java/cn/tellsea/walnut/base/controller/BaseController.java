package cn.tellsea.walnut.base.controller;

import cn.tellsea.walnut.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基类控制器
 *
 * @param <S> 不能为空
 * @author Tellsea
 * @date 2019/7/13
 */
public class BaseController<S extends BaseService> {

    @Autowired
    protected S baseService;

}
