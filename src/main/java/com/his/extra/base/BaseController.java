package com.his.extra.base;

import com.his.vo.User;
import org.springframework.web.multipart.MultipartFile;
import zhibi.commons.exception.MessageException;
import zhibi.frame.context.Constant;
import zhibi.frame.springmvc.base.AbstractController;
import zhibi.utils.io.FileUtils;

public abstract class BaseController extends AbstractController {



    /**
     * 登录的用户
     *
     * @return
     */
    protected User sessionUser() {
        return (User) session.getAttribute(Constant.SESSION.ADMIN);
    }

    protected void checkAdmin() {
        if (!sessionUser().getType().equals("admin")) throw new MessageException("普通用户没有权限");
    }


    protected String forward(String view, String tipMsg) {
        request.setAttribute("tipMsg", tipMsg);
        return view;
    }


    protected String saveFile(MultipartFile file) {
        return FileUtils.saveFile(file, "E:\\Projects\\School\\his\\src\\main\\resources\\public\\", "IMG");
    }
}
