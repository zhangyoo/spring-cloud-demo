package com.micro.provider.controller;

import com.github.pagehelper.PageInfo;
import com.micro.provider.dto.RequestParamDto;
import com.micro.provider.entity.User;
import com.micro.provider.service.UserService;
import com.micro.provider.vo.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户首页
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public List<User> index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum , @RequestParam(value = "keyword", defaultValue = "") String keyword){
        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.setKeyword(keyword);
        requestParamDto.setPageNum(pageNum);
        System.out.println("cloud-provider2");
        PageInfo<User> getUserList = userService.getUserList(requestParamDto);
//        if(true){
//            //测试hystrix时打开
//            throw new RuntimeException("FAILED");
//        }
        return getUserList.getList();
    }


}
