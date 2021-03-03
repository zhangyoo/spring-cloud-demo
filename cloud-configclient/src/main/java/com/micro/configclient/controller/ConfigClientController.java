package com.micro.configclient.controller;

import com.micro.configclient.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/configClient")
public class ConfigClientController {


    @Value("${cloud.config.version}")
    private String version;

    /**
     * 用户首页
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public List<User> index(){
        System.out.println(version);
        List<User> getUserList = new ArrayList<>();
        User getUser = new User();
        getUser.setUserName(version);
        getUser.setMail("111@dsas.com");
        getUserList.add(getUser);
        return getUserList;
    }

}
