package com.polar.admin.portal.controller;

import com.polar.admin.portal.dao.UserDao;
import com.polar.admin.portal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fuyuanpu on 2017/1/15.
 */
@RestController
public class IndexController {
    @Autowired
    UserDao userDao;

    @RequestMapping("index")
    public List<User> index() {
        return userDao.findAll();
    }
}
