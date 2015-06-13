package org.hhj.dao;

import org.hhj.entity.User;

import java.util.List;

/**
 * <b>function:</b>
 *
 * @author hehujun
 * @project welcome
 * @package org.hhj.dao
 * @fileName com.xcj.*
 * @createDate 2015/5/27 9:54
 * @email hehujun@126.com
 */
public interface UserDao {

    public List<User> getUsers() throws Exception;
    public void transmanagerTest(User user) throws Exception;
}
