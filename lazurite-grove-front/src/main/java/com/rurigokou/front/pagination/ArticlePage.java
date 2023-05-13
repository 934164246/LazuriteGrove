package com.rurigokou.front.pagination;

import com.rurigokou.common.pagination.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class ArticlePage implements Pageable {

    @NotNull
    private String sort;

    @Min(1)
    private Long current;

    @Min(20)
    private Long size;

    @Override
    public Long getCurrent() {
        return current;
    }

    @Override
    public Long getSize() {
        return size;
    }
}
