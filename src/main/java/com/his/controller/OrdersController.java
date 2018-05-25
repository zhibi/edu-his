package com.his.controller;

import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.service.OrdersService;
import com.his.vo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;

@RequestMapping("orders")
@Controller
public class OrdersController extends BaseController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 列表
     *
     * @param orders
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Orders orders, Page page, Model model) {
        Example example = Example.getInstance()
                .addOrder("addtime", ExampleType.OrderType.DESC);
        PageInfo<Orders> pageInfo = ordersService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "orders/list";
    }


    @PostMapping("update")
    public String update(Orders orders) {
        ordersService.updateByPrimaryKeySelective(orders);
        return redirect("list");
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        ordersService.deleteByPrimaryKey(id);
        return refresh();
    }
}
