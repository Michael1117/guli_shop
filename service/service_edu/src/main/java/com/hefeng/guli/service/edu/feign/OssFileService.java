package com.hefeng.guli.service.edu.feign;


import com.hefeng.guli.common.base.result.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("service-oss")
public interface OssFileService {

    @GetMapping("/admin/oss/file/test")
    R test();
}
