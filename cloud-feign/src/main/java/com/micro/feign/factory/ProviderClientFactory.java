package com.micro.feign.factory;

import com.micro.feign.client.DataClient;
import com.micro.feign.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderClientFactory implements FallbackFactory<DataClient> {

    @Override
    public DataClient create(Throwable cause) {
        return new DataClient() {
            @Override
            public List<User> index() {
                List<User> getUserList = new ArrayList<>();
                User getUser = new User();
                getUser.setUserName("Feign调用失败");
                getUser.setMail("111@dsas.com");
                getUserList.add(getUser);
                return getUserList;
            }
        };
    }
}
