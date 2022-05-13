package test.com.semiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.semiproject.model.ReviewDAO;
import test.com.semiproject.model.ReviewVO;

@Service
public class ReviewService {
	@Autowired
	ReviewDAO dao;

	public int rInsert(ReviewVO vo) {
		return dao.rInsert(vo);
	}

	public int rUpdate(ReviewVO vo) {
		return dao.rUpdate(vo);
	}

	public int rDelete(ReviewVO vo) {
		return dao.rDelete(vo);
	}

	public ReviewVO rSelectOne(ReviewVO vo) {
		return dao.rSelectOne(vo);
	}

	public List<ReviewVO> rSelectAll(int page) {

		return dao.rSelectAll(page);
	}

	public List<ReviewVO> rSearchList(String searchKey, String searchWord) {

		return dao.rSearchList(searchKey, searchWord);
	}

	public int getRpage_count() {
		return dao.getRpage_count();
	}

}
