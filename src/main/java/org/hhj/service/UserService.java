package org.hhj.service;

import org.hhj.entity.User;

import java.util.List;

/**
 * <b>function:</b>
 *
 * @author hehujun
 * @project welcome
 * @package org.hhj.service
 * @fileName com.xcj.*
 * @createDate 2015/5/27 9:54
 * @email hehujun@126.com
 */
public interface UserService {

    public List<User> getUsers() throws Exception;
}
