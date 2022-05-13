package test.com.semiproject;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.semiproject.model.LoginVO;
import test.com.semiproject.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String login(LoginVO vo, HttpServletRequest request) {
		logger.info("Welcome login!");

		LoginVO vo2 = service.login(vo);
		logger.info("id: {}", vo2.getId());
		if (vo2 != null) {
			request.getSession().setAttribute("session_id", vo2.getId());
			request.getSession().setMaxInactiveInterval(300);

		}
		return "redirect:index.do";
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		logger.info("Welcome logout!");
		
		request.getSession().removeAttribute("session_id");
		
		return "redirect:index.do";
	}

}
