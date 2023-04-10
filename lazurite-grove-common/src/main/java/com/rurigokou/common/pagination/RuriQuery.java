package com.rurigokou.common.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;

/**
 *  分页封装
 *
 * @author gokoururi
 */
public class RuriQuery<T> {

    /**
     * 默认当前页
     */
    public final static Long CURRENT=1L;

    /**
     * 默认每页大小
     */
    public final static Long SIZE=10L;

    public static <T> IPage<T> getPage(Pageable pageable) {
        long current= Objects.isNull(pageable.getCurrent()) ? CURRENT : pageable.getCurrent();
        long size =Objects.isNull(pageable.getSize()) ? SIZE : pageable.getSize();

        return new Page<>(current, size);
    }
}
