package com.micro.feign.client;

import com.micro.feign.entity.User;
import com.micro.feign.factory.ProviderClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//要调用的服务名称
@FeignClient(value = "CLOUD-PROVIDER" , fallbackFactory = ProviderClientFactory.class)
public interface DataClient {

    //和调用服务controller的一致
    @RequestMapping("/cloud-provider/user/index")
    public List<User> index();

}
