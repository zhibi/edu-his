package com.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.mapper.RecordMapper;
import com.his.mapper.UserMapper;
import com.his.vo.Record;
import com.his.vo.User;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;

import java.util.Date;
import java.util.List;

@RequestMapping("record")
@Controller
public class RecordController extends BaseController {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 列表
     *
     * @param record
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Record record, Page page, Model model) {
        Example example = Example.getInstance()
                .addParam("docid", sessionUser().getId(), ExampleType.Operation.LIKE)
                .addOrder("addtime", ExampleType.OrderType.DESC);
        PageHelper.startPage(page.getPageNum(), page.getPageSize());

        PageInfo<Record> pageInfo = new PageInfo<>(recordMapper.selectByExample(example), 5);
        for (Record re : pageInfo.getList()) {
            LocalDate start = new LocalDate(re.getAddtime());
            LocalDate end = LocalDate.now();
            int day = 30 - Days.daysBetween(start, end).getDays();
            re.setData(day);
            recordMapper.updateByPrimaryKeySelective(re);
        }
        setModelAttribute(model, pageInfo);
        return "record/list";
    }

    @GetMapping("add")
    public String add(Model model) {
        User user = new User();
        user.setType("user");
        List<User> userList = userMapper.select(user);
        model.addAttribute("userList", userList);
        return "record/add";
    }

    @PostMapping("add")
    public String add(Record record) {

        User user = userMapper.selectByPrimaryKey(record.getUserid());
        record.setData(30);
        record.setDocid(sessionUser().getId());
        record.setAddtime(new Date());
        record.setUser(user.getName());
        recordMapper.insertSelective(record);
        return redirect("list");
    }


}
