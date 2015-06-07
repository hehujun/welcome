package org.hhj.dao.impl;

import org.hhj.dao.UserDao;
import org.hhj.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hhj on 15-6-2.
 */
@Component(value = "userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers() throws Exception {
//        return this.jdbcTemplate.query("SELECT id, name, password FROM user", new RowMapper<User>(){
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User user = new User();
//                user.setId(rs.getLong("id"));
//                user.setName(rs.getString("name"));
//                user.setPassword(rs.getString("password"));
//                return user;
//            }
//        });

        return this.getCurrentSession().createSQLQuery("SELECT * from user").addEntity(User.class).list();
    }
}
