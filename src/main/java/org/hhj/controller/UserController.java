package org.hhj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>function:</b>
 *
 * @author hehujun
 * @project welcome
 * @package org.hhj.controller
 * @fileName com.xcj.*
 * @createDate 2015/5/27 9:54
 * @email hehujun@126.com
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String login() {
		return "success";
	}

	@RequestMapping("/loginftl")
	public String loginftl() {
		return "successftl";
	}
}
