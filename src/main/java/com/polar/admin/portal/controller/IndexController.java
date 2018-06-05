package com.polar.admin.portal.controller;

import com.polar.admin.portal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fuyuanpu on 2017/1/15.
 */
@Controller
public class IndexController {
    @Autowired
    UserDao userDao;

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
