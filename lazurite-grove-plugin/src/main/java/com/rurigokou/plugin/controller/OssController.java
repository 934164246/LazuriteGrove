package com.rurigokou.plugin.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.rurigokou.common.response.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gokoururi
 */
@RestController
@RequestMapping("plugin/oss")
public class OssController {

    private OSS oss;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessKey;

    @Value("${spring.cloud.alicloud.secret-key}")
    private String secretKey;

    @Value("${spring.cloud.alicloud.oss.bucket}")
    private String bucket;

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endPoint;

    @Value("${spring.cloud.alicloud.oss.dir}")
    private String folderPrefix;

    @Autowired
    public void setOss(OSS oss) {
        this.oss = oss;
    }

    @GetMapping("policy")
    public ResultResponse<Map<String, String>> ossInfo() {
        String host = "https://" + bucket + "." + endPoint;
        String folder = folderPrefix + "/" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "/";
        String postPolicy;
        String encodePolicy = "";
        String postSignature = "";
        long expiredEndTime = 0L;

        try {
            long expireTime = 30L;
            expiredEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expiredEndTime);

            PolicyConditions policyConditions = new PolicyConditions();
            policyConditions.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConditions.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, folder);

            postPolicy = oss.generatePostPolicy(expiration, policyConditions);

            byte[] policyBytes = postPolicy.getBytes(StandardCharsets.UTF_8);

            encodePolicy = BinaryUtil.toBase64String(policyBytes);
            postSignature = oss.calculatePostSignature(postPolicy);
        } catch (Exception ignored) {
        }

        Map<String, String> map = new LinkedHashMap<>();
        map.put("accessid", accessKey);
        map.put("policy", encodePolicy);
        map.put("signature", postSignature);
        map.put("dir", folder);
        map.put("host", host);
        map.put("expire", String.valueOf(expiredEndTime / 1000));


        return ResultResponse.success(map);
    }
}
