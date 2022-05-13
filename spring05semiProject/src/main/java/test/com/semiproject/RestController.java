package test.com.semiproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.semiproject.model.JoinVO;
import test.com.semiproject.service.JoinService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	@Autowired
	JoinService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/json_idCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public JoinVO idCheck(JoinVO vo) {
		logger.info("Welcome json_idCheck!");

		JoinVO vo2 = new JoinVO();
		vo2 = service.idCheck(vo) != null ? service.idCheck(vo) : vo2 ;

		return vo2;
	}
	

}
