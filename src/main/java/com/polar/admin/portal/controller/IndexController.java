package com.polar.admin.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fuyuanpu on 2017/1/15.
 */
@Controller
public class IndexController {
//    @Autowired
//    UserDao userDao;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("content");
    }
}
