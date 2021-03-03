package com.micro.consumer.controller;

import com.micro.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/apiUser")
public class APIUserController {

    private static final String REST_URL_PREFIX = "http://CLOUD-PROVIDER/cloud-provider";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 用户列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public List<User> index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum){
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/index?pageNum=" + pageNum, List.class);
    }

}
