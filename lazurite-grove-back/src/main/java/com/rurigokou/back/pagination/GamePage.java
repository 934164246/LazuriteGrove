package com.rurigokou.back.pagination;

import com.rurigokou.common.pagination.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class GamePage implements Pageable {

    private String id;

    private String name;

    private Integer typeId;

    private List<Integer> tagIds;

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
