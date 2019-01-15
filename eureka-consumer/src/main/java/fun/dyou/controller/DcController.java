package fun.dyou.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fun.dyou.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DcClient dcClient;
    @GetMapping("/consumer")
    //开启服务容错保护：服务降级、依赖隔离、断路器
    @HystrixCommand(fallbackMethod = "fallback")//注意：fallbackMethod指定的函数参数要与声明的函数参数保持一致
    public String dc() {
        return dcClient.consumer();
    }

    public String fallback(){
        return "fallback";
    }
}