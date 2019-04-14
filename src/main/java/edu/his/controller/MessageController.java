package edu.his.controller;

import com.github.pagehelper.PageInfo;
import edu.his.extra.base.BaseController;
import edu.his.service.MessageService;
import edu.his.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;

import java.util.Date;

@RequestMapping("message")
@Controller
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    /**
     * 列表
     *
     * @param message
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Message message, Page page, Model model) {
        Example example = Example.getInstance()
                .addOrder("status")
                .addOrder("addtime", ExampleType.OrderType.DESC);
        if (!sessionUser().getType().equals("admin")) {
            example.addParam("userid", sessionUser().getId());
        }
        PageInfo<Message> pageInfo = messageService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "message/list";
    }


    @PostMapping("add")
    public String add(Message message) {
        message.setAddtime(new Date());
        message.setStatus(0);
        message.setSendid(sessionUser().getId());
        message.setSend(sessionUser().getName());
        messageService.insertSelective(message);
        return redirect("list");
    }

    /**
     * 标为已读
     *
     * @param id
     * @return
     */
    @RequestMapping("read/{id}")
    public String read(@PathVariable Integer id) {
        Message message = messageService.selectByPrimaryKey(id);
        message.setStatus(1);
        messageService.updateByPrimaryKeySelective(message);

        message = new Message();
        message.setStatus(0);
        message.setUserid(sessionUser().getId());
        int count = messageService.selectCount(message);
        session.setAttribute("read", count);
        return refresh();
    }

    /**
     * 删除消息
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        messageService.deleteByPrimaryKey(id);
        return refresh();
    }


}
