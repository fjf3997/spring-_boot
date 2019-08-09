package com.fjf.controller;

import com.fjf.dao.UserDao;
import com.fjf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/query")
    @ResponseBody
    public List<User> query(){
        return userDao.queryUserList();
    }

}
