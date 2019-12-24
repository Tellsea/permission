package cn.tellsea.walnut.tkmybatis;

import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * 批量操作接口
 *
 * @param <T> 不能为空
 * @author Tellsea
 * @date 2019/7/13
 */
@RegisterMapper
public interface BatchMapper<T> extends UpdateBatchByPrimaryKeySelectiveMapper<T> {
}
