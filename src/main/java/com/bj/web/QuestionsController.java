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

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/questions")
public class QuestionsController extends BaseController{

    @Autowired
    private QuestionsService service;

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(HttpServletResponse response,
                             Questions model,
                             @RequestParam(value = "page", defaultValue = "1", required = false) Integer pageNum,
                             @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit) {
        try {
            int start = (pageNum - 1) * limit;

            Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "id");
            Pageable pageable = PageRequest.of(start, limit, sort);
            Page<Questions> page = service.list(model,pageable);
            sendJsonData(response, "0", "", page.getTotalElements(), page.getContent());
        } catch (Exception e) {
            sendJsonData(response, "-1", "", 0, null);
        } finally {
        }

        return null;
    }
    /**
     * 保存操作
     *
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public String save(HttpServletResponse response, Questions model) {
        try {
            Questions save = service.save(model);
            if (save != null) {
                sendJsonResult(response, "0", save.getId());
            } else {
                sendJsonResult(response, "-1", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类别删除操作
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(HttpServletResponse response, Integer id) {
        try {
            service.deleteById(id);
            sendJsonResult(response, "0", id);
        } catch (Exception e) {
            sendJsonResult(response, "-1", null);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取单个对象
     *
     * @param response
     * @param id
     * @return
     */
    @RequestMapping("/getOne")
    public String getOne(HttpServletResponse response, Integer id) {
        try {
            Questions model = service.getOne(id);
            sendJsonResult(response, "0", model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
