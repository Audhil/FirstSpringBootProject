package com.medium.audhil.controllers;

import com.medium.audhil.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String newHome(HttpServletRequest req) {
        System.out.println("hi : " + req.getParameter("name"));
        HttpSession session = req.getSession();
        String param = req.getParameter("name");
        session.setAttribute("name", param);
        return "new_home";
    }

    //    another way of passing params, for .jsp files only
    @RequestMapping("newhome2")
    public String newHome(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("hi : " + req.getParameter("name"));
        String param = req.getParameter("name");
        req.setAttribute("name", param);
        return "new_home";
    }

    //  other ways of passing params, and using ModelAndView class
    @RequestMapping("newhome3")
    public String newHome(String name, HttpSession session) {
        session.setAttribute("name", name);
        return "new_home";
    }

    //  use of @RequestParam
    @RequestMapping("newhome4")
    public String newHome4(@RequestParam("name") String myName, HttpSession session) {
        session.setAttribute("name", myName);
        return "new_home";
    }

    //  skipping session, start using ModelAndView
    @RequestMapping("newhome5")
    public ModelAndView newHome(@RequestParam("name") String myName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", myName);
        mv.setViewName("new_home");
        return mv;
    }

    @RequestMapping("alien")
    public ModelAndView alienFlow(Alien alien) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj", alien);
        mv.setViewName("alien");
        return mv;
    }
}
