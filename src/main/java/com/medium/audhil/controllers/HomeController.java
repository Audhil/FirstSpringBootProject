package com.medium.audhil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("home")
    public String home() {
        System.out.println("hi");
        return "home.jsp";
    }

    //  configured page location in application.props
    @RequestMapping("nexthome")
    public String nextHome() {
        return "next_home"; //  name of jsp file
    }

//    @RequestMapping("newhome")
//    public String newHome(HttpServletRequest req) {
//        System.out.println("hi : " + req.getParameter("name"));
//        HttpSession session = req.getSession();
//        String param = req.getParameter("name");
//        session.setAttribute("name", param);
//        return "new_home";
//    }

//    another way of passing params, for .jsp files only
    @RequestMapping("newhome")
    public String newHome(HttpServletRequest req) {
        System.out.println("hi : " + req.getParameter("name"));
        String param = req.getParameter("name");
        req.setAttribute("name", param);
        return "new_home";
    }
}
