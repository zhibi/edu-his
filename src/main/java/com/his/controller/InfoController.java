package com.his.controller;

import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.service.InfoService;
import com.his.service.MessageService;
import com.his.vo.Info;
import com.his.vo.Message;
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

@RequestMapping("info")
@Controller
public class InfoController extends BaseController {

    @Autowired
    private InfoService infoService;
    @Autowired
    private MessageService messageService;

    /**
     * 列表
     *
     * @param info
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Info info, Page page, Model model) {
        Example example = Example.getInstance()
                .addParam("u.name", info.getUsername(), ExampleType.Operation.LIKE)
                .addOrder("addtime", ExampleType.OrderType.DESC);
        if (!sessionUser().getType().equals("admin") && !sessionUser().getType().equals("doctor")) {
            example.addParam("userid", sessionUser().getId());
        }
        PageInfo<Info> pageInfo = infoService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "info/list";
    }

    @GetMapping("add")
    public String add(Model model) {
        return "info/add";
    }

    @PostMapping("add")
    public String add(Info info) {
        info.setAddtime(new Date());
        info.setUserid(sessionUser().getId());
        infoService.insertSelective(info);

        //报警
        if (info.getHeart() < 50) saveLog("心率太低报警");
        if (info.getHeart() > 80) saveLog("心率太高报警");
        if (info.getBlood1() < 50) saveLog("低血压太低报警");
        if (info.getBlood1() > 100) saveLog("低血压太高报警");
        if (info.getBlood2() < 50) saveLog("高血压太低报警");
        if (info.getBlood2() > 100) saveLog("高血压太高报警");
        if (info.getPulse() < 50) saveLog("脉搏太低报警");
        if (info.getPulse() > 80) saveLog("脉搏太高报警");

        return redirect("list");
    }


    /**
     * 保存消息
     */
    private void saveLog(String content) {
        Message message = new Message();
        message.setContent(content);
        message.setAddtime(new Date());
        message.setUserid(sessionUser().getId());
        message.setSendid(1);
        message.setSend("系统消息");
        message.setStatus(0);
        messageService.insertSelective(message);
    }

}
