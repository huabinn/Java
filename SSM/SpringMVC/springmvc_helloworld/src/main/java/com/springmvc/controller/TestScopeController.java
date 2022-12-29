package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author bin
 * @date 2022-12-20-12:40
 */
@Controller
public class TestScopeController {

    /**
     * 向 域对象 共享数据
     *  1.通过 ModelAndView 向请求域共享数据（推荐使用本方法）
     *      控制器方法一定要将 ModelAndView 作为方法的返回值
     *  2. 使用 Model 向请求域共享数据
     *  3. 使用 ModelMap 向请求域共享数据
     *  4. 使用 Map 向请求域共享数据
     *
     *  Model | ModelMap | Map在底层中都是使用了
     *  org.springframework.validation.support.BindingAwareModelMap 类进行创建的
     */
    @RequestMapping("/test/modelandview")
    public ModelAndView testModelAndView() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("testRequestScope", "hello, ModelAndView");

        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        System.out.println(model.getClass().getName());

        model.addAttribute("testRequestScope", "hello, Model");

        return "success";
    }

    @RequestMapping("/test/modelmap")
    public String testModelMap(ModelMap modelMap) {
        System.out.println(modelMap.getClass().getName());

        modelMap.addAttribute("testRequestScope", "hello, ModelMap");

        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());

        map.put("testRequestScope", "hello, Map");

        return "success";
    }

    // 往 session 中共享数据
    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {

        session.setAttribute("testSessionScope", "hello, session");

        return "success";
    }

    // 往 application 中共享数据
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {

        ServletContext servletContext = session.getServletContext();

        servletContext.setAttribute("testApplicationScope", "hello, application");

        return "success";
    }
}
