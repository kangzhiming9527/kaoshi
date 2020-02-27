package com.bj.web;

import com.bj.bean.Questions;
import com.bj.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService service;

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                             @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        start = start < 0 ? 0 : start;

        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Questions> page = service.list(pageable);
        ModelAndView mav = new ModelAndView("questions/list");
        mav.addObject("page", page);
        return mav;
    }
}
