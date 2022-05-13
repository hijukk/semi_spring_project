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
public class JoinDAOImpl implements JoinDAO {
	private static final Logger logger = LoggerFactory.getLogger(JoinDAOImpl.class);

	@Autowired
	SqlSession sqlSession;

	int blockCount = 10;

	@Override
	public int jInsert(JoinVO vo) {
		logger.info("jInsert().." + vo);
		int flag = sqlSession.insert("jInsert", vo);

		return flag;
	}

	@Override
	public int jUpdate(JoinVO vo) {
		logger.info("jUpdate().." + vo);
		int flag = sqlSession.update("jUpdate", vo);

		return flag;
	}

	@Override
	public int jDelete(JoinVO vo) {
		logger.info("jDelete().." + vo);
		int flag = sqlSession.update("jDelete", vo);

		return flag;
	}

	@Override
	public JoinVO jSelectOne(JoinVO vo) {
		logger.info("jSelectOne().." + vo);
		JoinVO vo2 = sqlSession.selectOne("jSelectOne", vo);
		return vo2;
	}

	@Override
	public List<JoinVO> jSelectAll(int page) {
		logger.info("jSelectAll()..");
		logger.info("page: {}", page);
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + blockCount - 1;
		logger.info("startRow: {}", startRow);
		logger.info("endRow: {}", endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<JoinVO> vos = sqlSession.selectList("jSelectAll", map);

		return vos;
	}

	@Override
	public List<JoinVO> jSearchList(String searchKey, String searchWord) {
		logger.info("jSearchList()..");
		logger.info("searchKey: " + searchKey);
		logger.info("searchWord: " + searchWord);
		List<JoinVO> vos = new ArrayList<JoinVO>();

		if (searchKey.equals("id")) {

			vos = sqlSession.selectList("jSearchList_id", "%" + searchWord + "%");
		} else if (searchKey.equals("gender")) {

			vos = sqlSession.selectList("jSearchList_id", "%" + searchWord + "%");
		}

		return vos;
	}

	@Override
	public JoinVO idCheck(JoinVO vo) {
		logger.info("idCheck()...");
		JoinVO vo2 = sqlSession.selectOne("idCheck", vo);

		return vo2;
	}

	@Override
	public int getJpage_count() {
		logger.info("getPage_count()..");

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blockCount", blockCount);

		int page_count = sqlSession.selectOne("j_getPagecount", map);

		return page_count;
	}

}
