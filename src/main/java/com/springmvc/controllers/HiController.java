package com.springmvc.controllers;

import com.springmvc.SpringApplicationContext;
import com.springmvc.dao.ApplicationDao;
import com.springmvc.models.ApplicationType;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@Controller
@RequestMapping(value = "/hi/")
public class HiController {
    @Autowired
    private ApplicationDao appDao;

    @ResponseBody
    @RequestMapping(value = "handleRequest", produces = {"text/plain;charset=UTF-8"})
    public void handleRequest(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        //ApplicationDao appDao = (ApplicationDao)SpringApplicationContext.getBean("applicationDao");
        List<ApplicationType> applicationType_list= appDao.readTable();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSONArray.fromObject(applicationType_list).toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
