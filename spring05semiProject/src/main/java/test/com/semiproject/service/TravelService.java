package test.com.semiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.semiproject.model.TravelDAO;
import test.com.semiproject.model.TravelVO;

@Service
public class TravelService {
	@Autowired
	private TravelDAO dao;

	public int insert(TravelVO vo) {
		return dao.insert(vo);
	}

	public int update(TravelVO vo) {
		return dao.update(vo);
	}

	public int delete(TravelVO vo) {
		return dao.delete(vo);
	}

	public int myDelete(TravelVO vo) {
		return dao.myDelete(vo);
	}

	public TravelVO selectOne(TravelVO vo) {
		return dao.selectOne(vo);
	}

	public List<TravelVO> selectAll(int page) {
		return dao.selectAll(page);
	}

	public List<TravelVO> searchLIst(String searchWord) {
		return dao.searchLIst(searchWord);
	}

	public int myInsert(TravelVO vo) {
		return dao.myInsert(vo);
	}

	public List<TravelVO> mySelectAll(String session_id) {
		return dao.mySelectAll(session_id);
	}

	public List<TravelVO> mySelectAll_admin() {
		return dao.mySelectAll_admin();
	}

	public int getPage_count() {
		return dao.getPage_count();
	}

}
