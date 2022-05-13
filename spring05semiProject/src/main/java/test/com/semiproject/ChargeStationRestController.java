package test.com.semiproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.semiproject.model.JoinVO;
import test.com.semiproject.model.LoginVO;
import test.com.semiproject.service.ARSService;
import test.com.semiproject.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ChargeStationRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChargeStationRestController.class);
	
	@Autowired
	LoginService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/json_cslogin.do", method = RequestMethod.GET)
	@ResponseBody
	public LoginVO json_login(LoginVO vo) {
		logger.info("Welcome json_cslogin!");
		logger.info("vo: {}", vo);

		LoginVO vo2 = new LoginVO();
		vo2 = service.login(vo) != null ? service.login(vo) : vo2;
		logger.info("vo2: {}", vo2);

		return vo2;
	}
	
	
	
}
