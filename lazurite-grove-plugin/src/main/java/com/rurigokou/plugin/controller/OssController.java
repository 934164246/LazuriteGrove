package com.rurigokou.plugin.controller;

import com.aliyun.oss.OSS;
import com.rurigokou.common.response.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gokoururi
 */
@RestController
@RequestMapping("oss")
public class OssController {

    @Autowired
    private OSS oss;

    @GetMapping("policy")
    public ResultVo<Map<String, String>> ossInfo() {
        Map<String, String> map=new HashMap<>();
        map.put("1", "123");
        map.put("2", "234");
        return ResultVo.success(map);
    }
}
