package test.com.semiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.semiproject.model.JoinDAO;
import test.com.semiproject.model.JoinVO;

@Service
public class JoinService {
	@Autowired
	JoinDAO dao;

	public int jInsert(JoinVO vo) {

		return dao.jInsert(vo);
	}

	public int jUpdate(JoinVO vo) {
		return dao.jUpdate(vo);
	}

	public int jDelete(JoinVO vo) {
		return dao.jDelete(vo);
	}

	public JoinVO jSelectOne(JoinVO vo) {
		return dao.jSelectOne(vo);
	}

	public List<JoinVO> jSelectAll(int page) {
		return dao.jSelectAll(page);

	}

	public List<JoinVO> jSearchList(String searchKey, String searchWord) {
		return dao.jSearchList(searchKey, searchWord);
	}
	
	public JoinVO idCheck(JoinVO vo) {
		return dao.idCheck(vo);
	}

	public int getJpage_count() {
		return dao.getJpage_count();
	}
}
