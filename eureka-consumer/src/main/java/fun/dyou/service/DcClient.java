package fun.dyou.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping(value = "/dc")
    String consumer(@RequestHeader("token") String tokenVal);//tokenVal:动态header->token的值

}