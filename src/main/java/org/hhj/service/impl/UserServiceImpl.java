package org.hhj.service.impl;

import org.hhj.Entity.User;
import org.hhj.dao.UserDao;
import org.hhj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hhj on 15-6-2.
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    public List<User> getUsers() throws Exception {
        return  userDao.getUsers();
    }
}
