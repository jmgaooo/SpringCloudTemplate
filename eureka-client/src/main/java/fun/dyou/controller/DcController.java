package fun.dyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope//访问refresh接口刷新配置时被@RefreshScope标记的类将得到特殊处理(刷新关联的配置之类)
@RestController
public class DcController {
    @Value("${password}")
    String password;
    @Value("${myName}")
    String myName;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        System.out.println(password);
        System.out.println(myName);
        Thread.sleep(5000L);//用于Hystrix服务降级测试
        return services;
    }

}