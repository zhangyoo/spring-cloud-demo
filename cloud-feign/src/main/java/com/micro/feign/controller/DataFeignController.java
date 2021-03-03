package com.micro.feign.controller;

import com.micro.feign.client.DataClient;
import com.micro.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dataFeign")
public class DataFeignController {

    @Autowired
    private DataClient dataClient;

    @ResponseBody
    @RequestMapping("/getUser")
    public List<User> getUser(){
        List<User> getUserList = dataClient.index();
        return getUserList;
    }
}
