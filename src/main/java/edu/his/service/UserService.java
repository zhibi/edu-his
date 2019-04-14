package edu.his.service;

import edu.his.vo.User;
import zhibi.frame.service.BaseService;


public interface UserService extends BaseService<User> {

    User login(String username, String password);
}
