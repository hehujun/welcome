package org.hhj.dao.impl;

import org.hhj.Entity.User;
import org.hhj.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hhj on 15-6-2.
 */
@Component(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers() throws Exception {
        return this.jdbcTemplate.queryForList("SELECT id, name, password FROM user", User.class);
    }
}
