package test.com.semiproject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.semiproject.model.TravelVO;
import test.com.semiproject.service.TravelService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TravelController {
	@Autowired
	private TravelService service;
	@Autowired
	ServletContext servletContext;

	private static final Logger logger = LoggerFactory.getLogger(TravelController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/index.do" }, method = RequestMethod.GET)
	public String index() {
		logger.info("Welcome index!");
		return "index";
	}

	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model, String page) {
		logger.info("Welcome selectAll!");
		logger.info("page: {}", page);
		page = page != null ? page : "1";

		List<TravelVO> vos = service.selectAll(Integer.parseInt(page));
		logger.info("vos.size(): {}", vos.size());
//		for (TravelVO travelVO : vos) {
//			logger.info("travelVO: {}", travelVO);
//			
//		}
		model.addAttribute("vos", vos);

		/////////////PAGE_COUNT//////////////
		int page_count = service.getPage_count();
		logger.info("page_count: {}",page_count);
		
		model.addAttribute("page_count", page_count);
		
		
		return "travel/selectAll";
	}

	@RequestMapping(value = "/mySelectAll.do", method = RequestMethod.GET)
	public String mySelectAll(Model model, HttpServletRequest request) {
		logger.info("Welcome mySelectAll!");

		String session_id = (String) request.getSession().getAttribute("session_id");
		logger.info("session_id", session_id);
		List<TravelVO> vos = new ArrayList<TravelVO>();

		if (session_id.equals("admin")) {
			vos = service.mySelectAll_admin();

		} else {
			vos = service.mySelectAll(session_id);

		}
		model.addAttribute("vos", vos);

		return "travel/mySelectAll";
	}

	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne(TravelVO vo, Model model) {
		logger.info("Welcome selectOne!");
		logger.info("vo: {}", vo);

		TravelVO vo2 = service.selectOne(vo);
		logger.info("vo2: {}", vo2);
		model.addAttribute("vo2", vo2);
		return "travel/selectOne";
	}

	@RequestMapping(value = "/mySelectOne.do", method = RequestMethod.GET)
	public String mySelectOne(TravelVO vo, Model model) {
		logger.info("Welcome mySelectOne!");
		logger.info("vo: {}", vo);

		TravelVO vo2 = service.selectOne(vo);
		vo2.setId(vo.getId());

		logger.info("vo2: {}", vo2);
		model.addAttribute("vo2", vo2);
		return "travel/mySelectOne";
	}

	@RequestMapping(value = "/searchList.do", method = RequestMethod.GET)
	public String searchList(String searchWord, Model model) {
		logger.info("Welcome searchList!");
		logger.info("searchWord: {}", searchWord);

		List<TravelVO> vos = service.searchLIst(searchWord);
		model.addAttribute("vos", vos);
		return "travel/selectAll";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		logger.info("Welcome insert!");

		return "travel/insert";
	}

	// 한글깨짐
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(TravelVO vo) {
		logger.info("Welcome insertOK!");
		logger.info("vo: {}", vo);

		String save_file_name = vo.getMultipartFile().getOriginalFilename();
		logger.info("save_file_name: {}", save_file_name);

		vo.setSave_file_name(save_file_name.length() == 0 ? "제주도.jpg" : save_file_name);

		if (save_file_name.length() > 0) {
			String realPath = servletContext.getRealPath("resources/uploadimg");
			logger.info("realPath: {}", realPath);

			String saveFilePath = realPath + "\\" + vo.getSave_file_name();
			logger.info("saveFilePath: {}", saveFilePath);

			try {
				File f = new File(realPath, vo.getSave_file_name());
				vo.getMultipartFile().transferTo(f);

				BufferedImage original_buffer_img = ImageIO.read(f);
				BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

				File thumb_file = new File(realPath + "/thumb_" + vo.getSave_file_name());
				ImageIO.write(thumb_buffer_img, "jpg", thumb_file);

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		int result = service.insert(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:selectAll.do";
		else
			return "redirect:insert.do";

	}

	@RequestMapping(value = "/myInsertOK.do", method = RequestMethod.GET)
	public String myInsertOK(TravelVO vo, HttpServletRequest request) {
		logger.info("Welcome myInsertOK!");
		logger.info("vo: {}", vo);

		String session_id = (String) request.getSession().getAttribute("session_id");
		vo.setId(session_id);

		int result = service.myInsert(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:mySelectAll.do";
		else
			return "redirect:insert.do";

	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(TravelVO vo, Model model) {
		logger.info("Welcome update!");
		logger.info("vo: {}", vo);

		TravelVO vo2 = service.selectOne(vo);
		logger.info("vo2: {}", vo2);
		model.addAttribute("vo2", vo2);

		return "travel/update";
	}

	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	public String updateOK(TravelVO vo) {
		logger.info("Welcome updateOK!");
		logger.info("vo: {}", vo);

		String save_file_name = vo.getMultipartFile().getOriginalFilename();
		logger.info("save_file_name: {}", save_file_name);

		vo.setSave_file_name(save_file_name.length() == 0 ? "대관령.jpg" : save_file_name);

		if (save_file_name.length() > 0) {
			String realPath = servletContext.getRealPath("resources/uploadimg");
			logger.info("realPath: {}", realPath);

			String saveFilePath = realPath + "\\" + vo.getSave_file_name();
			logger.info("saveFilePath: {}", saveFilePath);

			try {
				File f = new File(realPath, vo.getSave_file_name());
				vo.getMultipartFile().transferTo(f);

				BufferedImage original_buffer_img = ImageIO.read(f);
				BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

				File thumb_file = new File(realPath + "/thumb_" + vo.getSave_file_name());
				ImageIO.write(thumb_buffer_img, "jpg", thumb_file);

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		int result = service.update(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:selectAll.do";
		else
			return "redirect:update.do?attraction=" + vo.getAttraction();

	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete() {
		logger.info("Welcome delete!");

		return "travel/delete";
	}

	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	public String deleteOK(TravelVO vo) {
		logger.info("Welcome deleteOK!");
		logger.info("vo: {}", vo);

		int result = service.delete(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:selectAll.do";
		else
			return "redirect:delete.do?attraction=" + vo.getAttraction();

	}

	@RequestMapping(value = "/myDelete.do", method = RequestMethod.GET)
	public String myDelete(TravelVO vo, Model model) {
		logger.info("Welcome myDelete!");
		logger.info("vo: {}", vo);

		TravelVO vo2 = service.selectOne(vo);
		vo2.setId(vo.getId());

		logger.info("vo2: {}", vo2);
		model.addAttribute("vo2", vo2);

		return "travel/myDelete";
	}

	@RequestMapping(value = "/myDeleteOK.do", method = RequestMethod.GET)
	public String myDeleteOK(TravelVO vo) {
		logger.info("Welcome myDeleteOK!");
		logger.info("vo: {}", vo);

		int result = service.myDelete(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:mySelectAll.do";
		else
			return "redirect:myDelete.do?attraction=" + vo.getAttraction();

	}

}
