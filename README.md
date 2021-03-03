# spring-cloud-demo

**spring cloud 常用模块实例：** 
 
eureka-服务注册与发现；  
feign-声明式的web service客户端，Feign可以与Eureka和Ribbon组合使用以支持负载均衡；  
zuul-路由网关；  
ribbon-负载均衡；  
hystrix-熔断器，Feign可以与Hystrix组合，具有熔断的能力；  
config-配置中心；  


**module说明：**  

cloud-configclient：spring-cloud-eureka-client 、spring-cloud-config-client；  
cloud-configserver：spring-cloud-eureka-client 、spring-cloud-config-server；  
cloud-consumer：spring-cloud-eureka-client 、spring-cloud-ribbon；  
cloud-feign：spring-cloud-eureka-client 、spring-cloud-feign 、spring-cloud-hystrix；  
cloud-provider：spring-cloud-eureka-client；  
cloud-provider2：spring-cloud-eureka-client；  
cloud-server：spring-cloud-eureka-server；  
cloud-zuul：spring-cloud-eureka-client 、spring-cloud-eureka-zuul；