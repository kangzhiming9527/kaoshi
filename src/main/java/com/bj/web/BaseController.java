package com.bj.web;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class BaseController {
    /**
     * 返回Ajax请求数据
     * @param response
     * @param code
     * @param msg
     * @param count
     * @param list
     */
    protected void sendJsonData(HttpServletResponse response, String code, String msg, long count, List list) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        json.put("count", count);
        json.put("data", list);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println(json.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 对Ajax提交数据返回结果
     * @param response
     * @param code
     * @param obj
     */
    protected void sendJsonResult(HttpServletResponse response, String code, Object obj) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("data", obj);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println(json.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
