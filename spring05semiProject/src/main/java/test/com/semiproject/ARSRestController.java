package test.com.semiproject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.semiproject.model.ARSVO;
import test.com.semiproject.model.JoinVO;
import test.com.semiproject.service.ARSService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ARSRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ARSRestController.class);
	
	@Autowired
	ARSService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/ars_phonecheck.do", method = RequestMethod.POST)
	@ResponseBody
	public JoinVO ars_phonecheck(JoinVO vo) {
		logger.info("Welcome ars_phonecheck!");
		
		JoinVO vo2 = service.ars_phonecheck(vo);
		logger.info("vo2: {}",vo2);
		
		return vo2;
	}
	
	@RequestMapping(value = "/ars_phoneplan.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ARSVO> ars_phoneplan() {
		logger.info("Welcome ars_phoneplan!");
		
		List<ARSVO> vos = service.ars_phoneplan();
		logger.info("vos.size(): {}",vos.size());
		
		return vos;
	}
	
	
	@RequestMapping(value = "/ars_optservice.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ARSVO> ars_optservice() {
		logger.info("Welcome ars_optservice!");
		
		List<ARSVO> vos = service.ars_optservice();
		logger.info("vos.size(): {}",vos.size());
		
		return vos;
	}
	
	
}
