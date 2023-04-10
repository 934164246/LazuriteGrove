package com.rurigokou.back.pagination;

import com.rurigokou.common.pagination.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class GameTypePage implements Pageable {

    private String id;

    private String name;

    private Long current;

    private Long size;

    @Override
    public Long getCurrent() {
        return this.current;
    }

    @Override
    public Long getSize() {
        return this.size;
    }
}
