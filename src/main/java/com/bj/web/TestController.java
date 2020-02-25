package com.bj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TestController：
 * 2020/2/23 17:43
 * by kzm
 */

@Controller
public class TestController {
        @RequestMapping("/view")
    public ModelAndView categorylist() {
//        List<Category> list = categoryDao.findAll();

        ModelAndView mav = new ModelAndView("test");
//        mav.addObject("list", list);
        return mav;
    }
}
