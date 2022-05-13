package test.com.semiproject;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.semiproject.model.LoginVO;
import test.com.semiproject.model.ShoppingVO;
import test.com.semiproject.service.LoginService;
import test.com.semiproject.service.ShoppingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShoppingController {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);

	@Autowired
	ShoppingService service;

	@Autowired
	LoginService lService;

	@Autowired
	ServletContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/json_login.do", method = RequestMethod.GET)
	@ResponseBody
	public LoginVO json_login(LoginVO vo) {
		logger.info("Welcome json_login!");
		logger.info("vo: {}", vo);

		LoginVO vo2 = new LoginVO();
		vo2 = lService.login(vo) != null ? lService.login(vo) : vo2;
		logger.info("vo2: {}", vo2);

		return vo2;
	}

	@RequestMapping(value = "/json_sessionId.do", method = RequestMethod.GET)
	@ResponseBody
	public String json_sessionId(HttpServletRequest request) {
		logger.info("Welcome json_sessionId!");
		String context_id = (String) context.getAttribute("context_id");
		logger.info("context_id: {}", context_id);

		return context_id;
	}

	@RequestMapping(value = "/shlogin.do", method = RequestMethod.GET)
	public String shlogin(LoginVO vo, HttpServletRequest request) {
		logger.info("Welcome shlogin!");
		logger.info("vo.getId(): {}", vo.getId());

		// webserver가 아닌 더 깊게 저장되는 형식
		// 로그인 체크 후 setAttribute >> loginInterceptor
		// server가 꺼질때까지 유지
		context.setAttribute("context_id", vo.getId());
		return "redirect:index.do";
	}

	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ShoppingVO> json_selectAll() {
		logger.info("Welcome json_selectAll!");

		List<ShoppingVO> vos = service.selectAll();

//		String str_data = "";
//
//		for (ShoppingVO shoppingVO : vos) {
//			System.out.println(shoppingVO.getProduct());
//			str_data += shoppingVO.getRnum() + " ";
//			str_data += shoppingVO.getProduct() + " ";
//			str_data += shoppingVO.getPrice() + " ";
//			str_data += shoppingVO.getRelease_date() + " ";
//			str_data += shoppingVO.getFile_name() + " ";
//			str_data += shoppingVO.getQuantity() + " ";
//		}

		return vos;
	}

	@RequestMapping(value = "/json_productCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ShoppingVO> json_productCheck(String product) {
		logger.info("Welcome json_productCheck!");
		logger.info("product: {}", product);

		List<ShoppingVO> vos = service.json_productCheck(product);
		logger.info("vos.size(): {}", vos.size());

		return vos;
	}


}
