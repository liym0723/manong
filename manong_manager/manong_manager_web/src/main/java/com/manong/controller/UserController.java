package com.manong.controller;

import com.manong.pojo.User;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    // RequestMapping 映射请求
    @RequestMapping("/user/{userid}")
    @ResponseBody // 解析成HASH
    public User getUserById(@PathVariable Integer userid){
        User user = userService.getUserById(userid);
        System.out.println(user);
        return user;
    }

}
