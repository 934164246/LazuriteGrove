package com.rurigokou.back.game.pagination;

import com.rurigokou.common.pagination.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class GameTagPage implements Pageable {

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
