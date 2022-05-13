package test.com.semiproject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.semiproject.model.JoinVO;
import test.com.semiproject.service.JoinService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JoinController {

	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	JoinService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jInsert.do", method = RequestMethod.GET)
	public String jInsert() {
		logger.info("Welcome jInsert!");

		return "join/jInsert";
	}

	@RequestMapping(value = "/jInsertOK.do", method = RequestMethod.POST)
	public String jInsertOK(JoinVO vo) {
		logger.info("Welcome jInsertOK!");

		int result = service.jInsert(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:index.do";
		else
			return "redirect:jInsert.do";
	}

	@RequestMapping(value = "/jSelectAll.do", method = RequestMethod.GET)
	public String jSelectAll(Model model, HttpServletRequest request, String page) {
		logger.info("Welcome jSelectAll!");
		String session_id = (String) request.getSession().getAttribute("session_id");

		// admin일때는 모든 회원정보
		if (session_id.equals("admin")) {
			logger.info("page: {}", page);
			page = page != null ? page : "1";

			List<JoinVO> vos = service.jSelectAll(Integer.parseInt(page));
			logger.info("vos: {}", vos);

			model.addAttribute("vos", vos);

			/////////////PAGE_COUNT//////////////
			int page_count = service.getJpage_count();
			logger.info("page_count: {}", page_count);

			model.addAttribute("page_count", page_count);

			return "join/jSelectAll";

		} else {
			// admin이 아닐때는 자기자신 selectOne
			JoinVO vo = new JoinVO();
			vo.setId(session_id);

			JoinVO vo2 = service.jSelectOne(vo);
			logger.info("vo2: {}", vo2);

			model.addAttribute("vo2", vo2);

			return "join/jSelectOne";

		}
	}

	@RequestMapping(value = "/jSearchList.do", method = RequestMethod.GET)
	public String jSearchList(String searchKey, String searchWord, Model model) {
		logger.info("Welcome jSearchList!");
		logger.info("searchKey: {}", searchKey);
		logger.info("searchWord: {}", searchWord);

		List<JoinVO> vos = service.jSearchList(searchKey, searchWord);
		logger.info("vos: {}", vos);

		model.addAttribute("vos", vos);

		return "join/jSelectAll";
	}

	@RequestMapping(value = "/jSelectOne.do", method = RequestMethod.GET)
	public String jSelectOne(JoinVO vo, Model model) {
		logger.info("Welcome jSelectOne!");

		JoinVO vo2 = service.jSelectOne(vo);
		logger.info("vo2: {}", vo2);

		model.addAttribute("vo2", vo2);

		return "join/jSelectOne";
	}

	@RequestMapping(value = "/jUpdate.do", method = RequestMethod.GET)
	public String jUpdate(JoinVO vo, Model model) {
		logger.info("Welcome jUpdate!");

		JoinVO vo2 = service.jSelectOne(vo);
		logger.info("vo2: {}", vo2);

		model.addAttribute("vo2", vo2);

		return "join/jUpdate";
	}

	@RequestMapping(value = "/jUpdateOK.do", method = RequestMethod.POST)
	public String jUpdateOK(JoinVO vo, HttpServletRequest request) {
		logger.info("Welcome jUpdateOK!");
		String session_id = (String) request.getSession().getAttribute("session_id");

		int result = service.jUpdate(vo);
		logger.info("result: {}", result);

		if (result == 1) {
			if (session_id.equals("admin"))
				return "redirect:jSelectAll.do";
			else
				return "redirect:jSelectOne.do?id=" + vo.getId();
		} else {
			return "redirect:jUpdateOK.do?id=" + vo.getId();
		}

	}

	@RequestMapping(value = "/jDelete.do", method = RequestMethod.GET)
	public String jDelete(JoinVO vo, Model model) {
		logger.info("Welcome jDelete!");

		return "join/jDelete";
	}

	@RequestMapping(value = "/jDeleteOK.do", method = RequestMethod.GET)
	public String jDeleteOK(JoinVO vo, HttpServletRequest request) {
		logger.info("Welcome jDeleteOK!");
		String session_id = (String) request.getSession().getAttribute("session_id");

		int result = service.jDelete(vo);
		logger.info("result: {}", result);

		if (result == 1) {
			if (session_id.equals("admin"))
				return "redirect:jSelectAll.do";
			else
				request.getSession().removeAttribute("session_id");
				return "redirect:index.do";
		} else {
			return "redirect:jDeleteOK.do?id=" + vo.getId();
		}

	}

}
