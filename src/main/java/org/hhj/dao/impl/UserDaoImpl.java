package org.hhj.dao.impl;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.hhj.dao.UserDao;
import org.hhj.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

    /**
     * 事务测试
     * @return
     * @throws Exception
     */
    public void transmanagerTest(final User user) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                String sql = "INSERT INTO USER (name, PASSWORD) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getName());
                statement.setString(2, user.getPassword());
                return statement;
            }
        }, keyHolder);
        System.out.println(user);
        user.setId(keyHolder.getKey().longValue());
       // int i = 1/0;
        user.setName("aaaa");
        System.out.println(user);
        this.sessionFactory.getCurrentSession().update(user);
    }
}
