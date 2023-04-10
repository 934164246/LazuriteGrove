package com.rurigokou.back.pagination;

import com.rurigokou.common.pagination.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class UserPage implements Pageable {

    private String name;

    private String roleKeyword;

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
