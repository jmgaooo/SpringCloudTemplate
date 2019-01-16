### 目录介绍
* api-gateway:服务网关
* config-resources:远程配置资源目录
* config-server-git:分布式配置中心
* eureka-client:eureka提供者服务
* eureka-consumer:eureka消费者服务
* eureka-server:eureka服务注册中心
* hystrix-dashboard：监控Hystrix指标数据的可视化面板
* turbine:聚合高可用多实例服务的Hystrix各项指标数据,由hystrix-dashboard监控

项目启动顺序：eureka-server>config-server-git>eureka-client>eureka-consumer>api-gateway|(turbine>hystrix-dashboard)
### spring cloud学习总结
1. spring cloud的负载均衡机制适用于注册中心的服务间的调用,nginx和zuul适用于对外客户端服务的负载均衡

2. application.yml可覆盖bootstrap.yml内除远程配置外的属性，覆盖远程配置需要设置`spring.cloud.config.allowOverride=true`

3. Spring Cloud Config加密解密时注意：JCE版本（Unlimited Strength Java Cryptography Extension）要和运行环境jdk版本匹配

4. 个人理解：所有注册到eureka注册中心的都是服务，服务端(服务提供者)、客户端(服务消费者)这些是根据项目设计决定的

5. zuul网关的高可用：目前没找到zuul相关的类似nginx+Keepalived这样的故障转移方案，不过可用nginx作为替代方案->使用nginx搭建一个对外开放的客户端服务集群使用Keepalived做故障转移，搭建一个zuul集群来负载均衡路由内部服务，使用nginx的负载均衡机制反向代理zuul集群

6. eureka-server注册中心高可用就是部署一个复制集群，互相注册，互相复制

7. 集群环境服务注册时不建议只注册给其中一个然后利用集群的复制特性复制给其它注册中心，原因是如果只注册给一台，当这台注册中心挂了，再启动服务就无法注册到集群环境了，必须得先把挂了的注册中心启动

8. 经过测试注册中心2台集群跟3台集群并没感觉有不同，不懂为什么网上说3台集群是最高可用性集群