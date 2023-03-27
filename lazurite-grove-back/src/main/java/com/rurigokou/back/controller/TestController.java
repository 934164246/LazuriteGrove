package com.rurigokou.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("getInfo")
    public Map<String, String> getInfo() {
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1", "2");

        objectObjectHashMap.put("23", "123");

        return objectObjectHashMap;
    }
}
