package com.his.controller;

import com.his.extra.base.BaseController;
import com.his.extra.context.Constant;
import com.his.service.UserService;
import com.his.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private UserService userService;


    @GetMapping("login")
    public String login() {
        return "login";
    }


    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index(Model model) {

        model.addAttribute("tipMsg", session.getAttribute("tipMsg"));
        session.removeAttribute("tipMsg");
        if (sessionUser().getType().equals("admin")) {
            return "index-admin";
        }
        return "index";
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, String code) {
        if (!code.equalsIgnoreCase((String) session.getAttribute("verifyCode"))) {
            request.setAttribute("msg", "验证码错误");
            return "login";
        }
        User user = userService.login(username, password);
        if (null == user) {
            request.setAttribute("msg", "用户名或者密码错误");
            return "login";
        }
        session.setAttribute("sessionAdmin", user);
        return "redirect:index";
    }


    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(Constant.SESSION.ADMIN);
        return redirect("index");
    }


}
