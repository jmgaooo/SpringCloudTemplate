package fun.dyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringCloudApplication//项目未引入spring-cloud-starter-eureka依赖@EnableDiscoveryClient不会生效
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}