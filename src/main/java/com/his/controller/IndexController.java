package com.his.controller;

import com.his.extra.base.BaseController;
import com.his.extra.context.Constant;
import com.his.mapper.PersonalMapper;
import com.his.service.DoctorService;
import com.his.service.InfoService;
import com.his.service.MessageService;
import com.his.service.UserService;
import com.his.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zhibi.commons.exception.MessageException;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;

import java.util.List;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PersonalMapper personalMapper;


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
        if (sessionUser().getType().equals("user")) {
            Example example = Example.getInstance().addParam("userid", sessionUser().getId()).addOrder("addtime", ExampleType.OrderType.DESC);
            List<Info> infoList = infoService.selectByExample(example);
            model.addAttribute("infoList", infoList);

            Personal personal = personalMapper.selectByPrimaryKey(sessionUser().getId());
            if(personal == null) personal = new Personal();
            model.addAttribute("personal",personal);
        }

        Message message = new Message();
        message.setStatus(0);
        message.setUserid(sessionUser().getId());
        int count = messageService.selectCount(message);
        session.setAttribute("read", count);

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
        if (user.getStatus() == 0) {
            request.setAttribute("msg", "用户不可用");
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

    @RequestMapping("modify")
    public String modify() {
        return "modify";
    }

    /**
     * 修改密码
     *
     * @param pass
     * @param newpass
     * @param confimpass
     * @return
     */
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public String modify(String pass, String newpass, String confimpass) {
        if (!newpass.equals(confimpass)) {
            throw new MessageException("两次密码不一样");
        }
        if (!sessionUser().getPassword().equalsIgnoreCase(pass)) {
            throw new MessageException("原密码错误");
        }
        User user = userService.selectByPrimaryKey(sessionUser().getId());
        user.setPassword(newpass);
        userService.updateByPrimaryKey(user);
        return redirect("logout");
    }

    /**
     * 个人信息
     *
     * @param model
     * @return
     */
    @RequestMapping("info")
    public String info(Model model) {
        Doctor doctor = doctorService.selectByPrimaryKey(sessionUser().getId());
        if (null == doctor) doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "info";
    }

    @RequestMapping("update")
    public String update(Doctor doctor) {
        if (doctorService.selectByPrimaryKey(doctor.getId()) == null)
            doctorService.insertSelective(doctor);
        else
            doctorService.updateByPrimaryKeySelective(doctor);
        return refresh();
    }
}
