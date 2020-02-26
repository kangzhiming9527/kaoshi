package com.bj.web;

import com.bj.bean.Knowledge;
import com.bj.service.KnowledgeService;
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
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService service;



    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                             @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        String result = "[]";
        return result;
    }

    /**
     * 类别新增视图
     *
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("knowledge/add");
        return mav;
    }

    /**
     * 类别新增操作
     *
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public String save(Knowledge model) {
        service.save(model);
        return "redirect:list";
    }

//    /**
//     * 类别删除操作
//     * @param id
//     * @return
//     */
//    @RequestMapping("/del")
//    public String categorydelete(Integer id) {
//        personDao.deleteById(id);
//        return "redirect:person/list";
//    }

    /**
     * 类别编辑视图
     *
     * @param id
     * @return
     */
    @RequestMapping("/edit")
    public ModelAndView categoryedit(Integer id) {
        Knowledge model = service.getOne(id);

        ModelAndView mav = new ModelAndView("knowledge/edit");
        mav.addObject("knowledge", model);
        return mav;
    }
}
