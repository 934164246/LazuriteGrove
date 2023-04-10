package com.rurigokou.back.feign;

import com.rurigokou.common.response.ResultResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author gokoururi
 */
@FeignClient("lazurite-grove-plugin")
public interface TestFeign {

    @GetMapping("/plugin/oss/policy")
    ResultResponse<Map<String, String>> getPlugin();
}
