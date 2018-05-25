package com.his.controller;

import com.github.pagehelper.PageInfo;
import com.his.extra.base.BaseController;
import com.his.service.InfoService;
import com.his.service.MessageService;
import com.his.service.UserService;
import com.his.vo.Info;
import com.his.vo.Message;
import com.his.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private UserService userService;

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

    @GetMapping("add/{id}")
    public String add(Model model, @PathVariable Integer userid) {

        model.addAttribute("userid", userid);
        return "info/add";
    }

    @PostMapping("add")
    public String add(Info info) {
        info.setAddtime(new Date());
        //info.setUserid(sessionUser().getId());
        infoService.insertSelective(info);

        //报警
        if (info.getHeart() < 90) saveLog("血氧太低报警", info.getUserid());
        if (info.getHeart() > 100) saveLog("血氧太高报警", info.getUserid());
        if (info.getBlood1() < 60) saveLog("低血压太低报警", info.getUserid());
        if (info.getBlood1() > 90) saveLog("低血压太高报警", info.getUserid());
        if (info.getBlood2() < 90) saveLog("高血压太低报警", info.getUserid());
        if (info.getBlood2() > 140) saveLog("高血压太高报警", info.getUserid());
        if (info.getPulse() < 60) saveLog("脉搏太低报警", info.getUserid());
        if (info.getPulse() > 100) saveLog("脉搏太高报警", info.getUserid());

        return redirect("list");
    }


    /**
     * 保存消息
     */
    private void saveLog(String content, Integer userid) {
        User user = userService.selectByPrimaryKey(userid);
        Message message = new Message();
        message.setContent(content);
        message.setAddtime(new Date());
        message.setUserid(userid);
        message.setSendid(1);
        message.setSend("[" + user.getName() + "]" + "系统消息");
        message.setStatus(0);
        messageService.insertSelective(message);
    }

}
