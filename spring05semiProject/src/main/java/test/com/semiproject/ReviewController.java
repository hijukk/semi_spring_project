package test.com.semiproject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

import test.com.semiproject.model.ReviewVO;
import test.com.semiproject.service.ReviewService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	ReviewService service;

	@Autowired
	ServletContext servletContext;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rInsert.do", method = RequestMethod.GET)
	public String rInsert() {
		logger.info("Welcome rInsert!");

		return "review/rInsert";
	}

	@RequestMapping(value = "/rInsertOK.do", method = RequestMethod.POST)
	public String rInsertOK(ReviewVO vo, HttpServletRequest request) {
		logger.info("Welcome rInsertOK!");
		logger.info("vo: {}", vo);

		String save_file_name = vo.getMultipartFile().getOriginalFilename();
		logger.info("save_file_name: {}", save_file_name);

		vo.setRsave_file_name(save_file_name.length() != 0 ? save_file_name : "파씨오네.jpg");

		if (save_file_name.length() > 0) {

			String realPath = servletContext.getRealPath("resources/ruploadimg");
			logger.info("realPath", realPath);

			try {
				File f = new File(realPath, vo.getRsave_file_name());
				vo.getMultipartFile().transferTo(f);

				BufferedImage original_buffer_img = ImageIO.read(f);
				BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

				File thumb_file = new File(realPath + "/thumb_" + vo.getRsave_file_name());
				ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		int result = service.rInsert(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:rSelectAll.do";
		else
			return "redirect:rInsert.do";
	}

	@RequestMapping(value = "/rSelectAll.do", method = RequestMethod.GET)
	public String rSelectAll(Model model, String page) {
		logger.info("Welcome rSelectAll!");
		page = page != null ? page : "1";

		List<ReviewVO> vos = service.rSelectAll(Integer.parseInt(page));
		logger.info("vos.size(): {}", vos.size());

		model.addAttribute("vos", vos);

		///////////// PAGE_COUNT//////////////
		int page_count = service.getRpage_count();
		logger.info("page_count: {}", page_count);

		model.addAttribute("page_count", page_count);

		return "review/rSelectAll";
	}

	@RequestMapping(value = "/rSelectOne.do", method = RequestMethod.GET)
	public String rSelectOne(ReviewVO vo, Model model) {
		logger.info("Welcome rSelectOne!");
		logger.info("vo: {}", vo);

		ReviewVO vo2 = service.rSelectOne(vo);
		logger.info("vo2: {}", vo2);

		model.addAttribute("vo2", vo2);

		return "review/rSelectOne";
	}

	@RequestMapping(value = "/rSearchList.do", method = RequestMethod.GET)
	public String rSearchList(String searchKey, String searchWord, Model model) {
		logger.info("Welcome rSearchList!");
		logger.info("searchKey: {}", searchKey);
		logger.info("searchWord: {}", searchWord);

		List<ReviewVO> vos = service.rSearchList(searchKey, searchWord);
		logger.info("vos.size(): {}", vos.size());

		model.addAttribute("vos", vos);

		return "review/rSelectAll";
	}

	@RequestMapping(value = "/rDelete.do", method = RequestMethod.GET)
	public String rDelete(ReviewVO vo) {
		logger.info("Welcome rDelete!");
		logger.info("vo: {}", vo);

		return "review/rDelete";
	}

	@RequestMapping(value = "/rDeleteOK.do", method = RequestMethod.GET)
	public String rDeleteOK(ReviewVO vo) {
		logger.info("Welcome rDeleteOK!");
		logger.info("vo: {}", vo);

		int result = service.rDelete(vo);
		logger.info("result: {}", result);

		if (result == 1)
			return "redirect:rSelectAll.do";
		else
			return "redirect:rDelete.do?rnum=" + vo.getRnum();
	}

	@RequestMapping(value = "/rUpdate.do", method = RequestMethod.GET)
	public String rUpdate(ReviewVO vo, Model model) {
		logger.info("Welcome rUpdate!");
		logger.info("vo: {}", vo);

		ReviewVO vo2 = service.rSelectOne(vo);
		logger.info("vo2: {}", vo2);

		model.addAttribute("vo2", vo2);

		return "review/rUpdate";
	}

	@RequestMapping(value = "/rUpdateOK.do", method = RequestMethod.POST)
	public String rUpdateOK(ReviewVO vo) {
		logger.info("Welcome rUpdateOK!");
		logger.info("vo: {}", vo);

		String save_file_name = vo.getMultipartFile().getOriginalFilename();
		logger.info("save_file_name", save_file_name);

		vo.setRsave_file_name(save_file_name.length() != 0 ? save_file_name : "미라이.jpg");

		if (save_file_name.length() > 0) {
			String realPath = servletContext.getRealPath("reasources/ruploadimg");
			logger.info("realPath: {}", realPath);

			try {
				File f = new File(realPath, save_file_name);
				vo.getMultipartFile().transferTo(f);

				BufferedImage original_buffer_img = ImageIO.read(f);
				BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

				File thumb_file = new File(realPath + "/thumb_" + vo.getRsave_file_name());

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		int result = service.rUpdate(vo);

		if (result == 1)
			return "redirect:rSelectAll.do";
		else
			return "redirect:rUpdate.do?rnum=" + vo.getRnum();
	}

}
