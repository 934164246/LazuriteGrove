package com.rurigokou.common.pagination;

/**
 * 分页类
 *
 * @author gokoururi
 */
public interface Pageable {

    /**
     * 获取当前页
     *
     * @return 当前页
     */
    Long getCurrent();

    /**
     * 获取每页大小
     *
     * @return 每页大小
     */
    Long getSize();
}
