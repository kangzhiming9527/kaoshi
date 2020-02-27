package com.bj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestController：
 * 2020/2/23 17:43
 * by kzm
 */

@Controller
public class TestController {
    @RequestMapping("/view")
    public String view() {
        return "index";
    }

    @RequestMapping("/viewBak")
    public String viewBak() {
        return "indexBak";
    }
}
