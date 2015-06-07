package org.hhj.dao.impl;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.hhj.dao.UserDao;
import org.hhj.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hhj on 15-6-2.
 */
@Component(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private SessionFactory sessionFactory;

    @Resource
    private SqlSession sqlSession;

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
        return this.sqlSession.selectList("org.hhj.entity.UserMapper.selectAll", User.class);
//        return this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * from user").addEntity(User.class).list();
    }
}
