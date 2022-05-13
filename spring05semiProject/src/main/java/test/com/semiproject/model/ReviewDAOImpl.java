package test.com.semiproject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	private static final Logger logger = LoggerFactory.getLogger(ReviewDAOImpl.class);

	@Autowired
	SqlSession sqlSession;

	int blockCount = 10;

	@Override
	public int rInsert(ReviewVO vo) {
		logger.info("rInsert().." + vo);

		int flag = sqlSession.insert("r_insert", vo);

		return flag;
	}

	@Override
	public int rUpdate(ReviewVO vo) {
		logger.info("rUpdate().." + vo);

		int flag = sqlSession.update("r_update", vo);

		return flag;
	}

	@Override
	public int rDelete(ReviewVO vo) {
		logger.info("rDelete().." + vo);
		int flag = sqlSession.delete("r_delete", vo);

		return flag;
	}

	@Override
	public ReviewVO rSelectOne(ReviewVO vo) {
		logger.info("rSelectOne().." + vo);
		ReviewVO vo2 = sqlSession.selectOne("r_selectOne", vo);

		return vo2;
	}

	@Override
	public List<ReviewVO> rSearchList(String searchKey, String searchWord) {
		logger.info("rSearchList()..");
		logger.info("searchKey: " + searchKey);
		logger.info("searchWord: " + searchWord);
		List<ReviewVO> vos = new ArrayList<ReviewVO>();

		if (searchKey.equals("rtitle")) {
			vos = sqlSession.selectList("r_searchList_rtitle", "%" + searchWord + "%");
		} else if (searchKey.equals("rcontent")) {
			vos = sqlSession.selectList("r_searchList_rcontent", "%" + searchWord + "%");
		}
		if (searchKey.equals("rwriter")) {
			vos = sqlSession.selectList("r_searchList_rwriter", "%" + searchWord + "%");
		}

		return vos;
	}

	@Override
	public List<ReviewVO> rSelectAll(int page) {
		logger.info("rSelectAll()..");
		logger.info("page: {}", page);
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + blockCount - 1;
		logger.info("startRow: {}", startRow);
		logger.info("endRow: {}", endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<ReviewVO> vos = sqlSession.selectList("r_selectAll", map);
		return vos;
	}

	@Override
	public int getRpage_count() {
		logger.info("getRpage_count()..");

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blockCount", blockCount);

		int page_count = sqlSession.selectOne("r_getPagecount", map);

		return page_count;
	}

}
