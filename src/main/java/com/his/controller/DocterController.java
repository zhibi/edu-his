package com.his.controller;

import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.service.DoctorService;
import com.his.service.OrdersService;
import com.his.vo.Doctor;
import com.his.vo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;

import java.util.Date;

@RequestMapping("doctor")
@Controller

public class DocterController extends BaseController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private OrdersService ordersService;

    /**
     * 列表
     *
     * @param doctor
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Doctor doctor, Page page, Model model) {
        Example example = Example.getInstance()
                .addParam("name", doctor.getName(), ExampleType.Operation.LIKE)
                .addParam("dep", doctor.getDep(), ExampleType.Operation.LIKE)
                .addOrder("id", ExampleType.OrderType.DESC);
        PageInfo<Doctor> pageInfo = doctorService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "doctor/list";
    }

    //预约
    @RequestMapping("order/{id}")
    public String order(@PathVariable Integer id, Model model) {
        Doctor doctor = doctorService.selectByPrimaryKey(id);
        model.addAttribute(doctor);
        return "doctor/order";
    }

    @RequestMapping("order")
    public String order(Orders orders) {
        session.setAttribute("tipMsg", "预约成功");
        orders.setAddtime(new Date());
        orders.setUserid(sessionUser().getId());
        ordersService.insertSelective(orders);
        return redirect("/index");
    }
}
