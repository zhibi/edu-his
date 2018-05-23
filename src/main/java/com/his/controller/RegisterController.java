package com.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.mapper.DoctorMapper;
import com.his.mapper.RegisterMapper;
import com.his.vo.Doctor;
import com.his.vo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;
import zhibi.utils.request.ParamUtils;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("register")
public class RegisterController extends BaseController {


    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 列表
     *
     * @param register
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Register register, @RequestParam(defaultValue = "1") Integer pageNum, Model model) {
        Example example = Example.getInstance();
        example.addParam("name", register.getName(), ExampleType.Operation.LIKE);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Register> pageInfo = new PageInfo<>(registerMapper.selectByExample(example), 5);
        model.addAttribute(pageInfo);
        model.addAttribute("url", request.getRequestURI() + "?" + ParamUtils.params2String(request));
        return "register/list";
    }


    /**
     * 详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Register register = registerMapper.selectByPrimaryKey(id);
        model.addAttribute(register);
        List<Doctor> doctorList = doctorMapper.selectAll();
        model.addAttribute("doctorList", doctorList);
        return "register/detail";
    }

    /**
     * 修改用户信息
     *
     * @param register
     * @return
     */
    @RequestMapping("update")
    public String update(Register register) {
        Doctor doctor = doctorMapper.selectByPrimaryKey(register.getDocid());
        register.setDocname(doctor.getName());
        registerMapper.updateByPrimaryKeySelective(register);
        return refresh();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        registerMapper.deleteByPrimaryKey(id);
        return refresh();
    }

    @GetMapping("add")
    public String add(Model model) {
        List<Doctor> doctorList = doctorMapper.selectAll();
        model.addAttribute("doctorList", doctorList);
        return "register/add";
    }

    /**
     * 添加
     *
     * @param register
     * @return
     */
    @PostMapping("add")
    public String add(Register register) {
        Doctor doctor = doctorMapper.selectByPrimaryKey(register.getDocid());
        register.setDocname(doctor.getName());
        register.setAddtime(new Date());
        registerMapper.insert(register);
        return "redirect:list";
    }
}
