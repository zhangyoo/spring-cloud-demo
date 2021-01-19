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
        PageInfo<User> getUserList = userService.getUserList(requestParamDto);
        return getUserList.getList();
    }

    /**
     * 添加用户
     * @return
     */
    @ResponseBody
    @RequestMapping("/add.json")
    public ResponseEntity<BaseEntity> add(@RequestBody User user){
        Map<String,String> getInsertResult = userService.addUser(user);
        return ResponseEntity.ok(new BaseEntity<>(Integer.parseInt(getInsertResult.get("code")) ,getInsertResult.get("msg")));
    }

    /**
     * 编辑用户
     * @return
     */
    @RequestMapping("/edit.json")
    public ResponseEntity<BaseEntity> edit(@RequestBody User user){
        Map<String,String> getUpdateResult = userService.updateByPrimaryKeySelective(user);
        return ResponseEntity.ok(new BaseEntity<>(Integer.parseInt(getUpdateResult.get("code")) ,getUpdateResult.get("msg")));
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete.json")
    public ResponseEntity<BaseEntity> delete(@RequestParam String id){
        long objId = Long.parseLong(id);
        Map<String,String> getDeleteResult = userService.deleteByPrimaryKey(objId);
        return ResponseEntity.ok(new BaseEntity<>(Integer.parseInt(getDeleteResult.get("code")) ,getDeleteResult.get("msg")));
    }

}
