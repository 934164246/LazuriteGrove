package com.rurigokou.common.dto;

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

    /**
     * 数据
     */
    private List<Object> list = new ArrayList<>();

    /**
     * 当前页
     */
    private Long current = 1L;

    /**
     * 每页大小
     */
    private Long size = 10L;

    /**
     * 总页数
     */
    private Long pages = 0L;

    /**
     * 总数量
     */
    private Long total = 0L;

    /**
     * IPage -> RuriPage
     *
     * @param page page
     * @return ruriPage
     */
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
