package org.hhj.controller;

import org.hhj.Entity.User;
import org.hhj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "success";
	}

	@RequestMapping("/loginftl")
	public String loginftl() {
		return "successftl";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		logger.info("list()");
		try {
			List<User> users = userService.getUsers();
			for(User user:users) {
				System.out.println(user.getName());
			}
			modelMap.addAttribute("users", users);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "list";
	}
}
