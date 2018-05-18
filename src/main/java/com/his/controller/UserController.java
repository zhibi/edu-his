package com.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.mapper.UserMapper;
import com.his.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;
import zhibi.utils.request.ParamUtils;

import java.text.ParseException;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {


    @Autowired
    private UserMapper userMapper;

    /**
     * 居民列表
     *
     * @param user
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(User user, @RequestParam(defaultValue = "1") Integer pageNum, Model model) {
        Example example = Example.getInstance();
        example.addParam("type", "admin", ExampleType.Operation.NOTEQ)
                .addParam("name", user.getName(), ExampleType.Operation.LIKE);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByExample(example), 5);
        model.addAttribute(pageInfo);
        model.addAttribute("url", request.getRequestURI() + "?" + ParamUtils.params2String(request));
        return "user/list";
    }


    /**
     * 用户详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        User user = userMapper.selectByPrimaryKey(id);
        model.addAttribute(user);
        return "user/detail";
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("update")
    public String update(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) user.setPassword(null);
        userMapper.updateByPrimaryKeySelective(user);
        return refresh();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
        return refresh();
    }

    @GetMapping("add")
    public String add() {
        return "user/add";
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("add")
    public String add(User user) throws ParseException {
        user.setStatus(1);
        userMapper.insert(user);
        return "redirect:list";
    }

}
