package com.rurigokou.common.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gokoururi
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class RuriPage {

    private List<Object> list = new ArrayList<>();

    private Long current = 1L;

    private Long size = 10L;

    private Long pages = 0L;

    private Long total = 0L;

    public static RuriPage tranToPageVo(IPage<?> page) {
        RuriPage vo = new RuriPage();

        vo.list.addAll(page.getRecords());
        vo.setCurrent(page.getCurrent());
        vo.setSize(page.getSize());
        vo.setPages(page.getPages());
        vo.setTotal(page.getTotal());

        return vo;
    }
}
