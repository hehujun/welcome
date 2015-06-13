package org.hhj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hhj.entity.User;
import org.hhj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Map save(User user) {
		logger.info("save()");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.transmanagerTest(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			map.put("flag",false);
		}
		map.put("flag",true);
		return map;
	}
}
