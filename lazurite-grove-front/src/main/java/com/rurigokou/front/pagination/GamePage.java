package com.rurigokou.front.pagination;

import com.rurigokou.common.pagination.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class GamePage implements Pageable {

    private String gameName;

    private String typeKeyword;

    private String sortParam;

    private Long current;

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
