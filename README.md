### 目录介绍
* config-resources:远程配置资源目录
* config-server-git:分布式配置中心
* eureka-client:eureka提供者服务
* eureka-consumer:eureka消费者服务
* eureka-server:eureka服务注册中心
* hystrix-dashboard：监控Hystrix指标数据的可视化面板
* turbine:聚合高可用多实例服务的Hystrix各项指标数据,由hystrix-dashboard监控

项目启动顺序：eureka-server>config-server-git>eureka-client>eureka-consumer>turbine>hystrix-dashboard
### spring cloud学习总结
1. ribbon是eureka客户端负载均衡，在服务消费端使用,nginx是软件负载均衡，常用于前端服务器访问负载均衡

2. application.yml可覆盖bootstrap.yml内除远程配置外的属性，覆盖远程配置需要设置`spring.cloud.config.allowOverride=true`

3. Spring Cloud Config加密解密时注意：JCE版本（Unlimited Strength Java Cryptography Extension）要和运行环境jdk版本匹配

4. 个人理解：所有注册到eureka注册中心的都是服务，服务端(服务提供者)、客户端(服务消费者)这些是根据项目设计决定的

5. 如果注册中心有多台`spring.application.name`相同的服务，在消费时就会触发负载均衡机制(需配置负载均衡访问方式)