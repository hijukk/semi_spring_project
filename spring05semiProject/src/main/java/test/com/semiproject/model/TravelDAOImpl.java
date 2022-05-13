package test.com.semiproject.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TravelDAOImpl implements TravelDAO {
	private static final Logger logger = LoggerFactory.getLogger(TravelDAOImpl.class);
	@Autowired
	SqlSession sqlSession;

	int blockCount = 10;

	@Override
	public int insert(TravelVO vo) {
		logger.info("insert().." + vo);
		int flag = sqlSession.insert("t_insert", vo);

		return flag;
	}

	@Override
	public int update(TravelVO vo) {
		logger.info("update().." + vo);
		int flag = sqlSession.update("t_update", vo);

		return flag;
	}

	@Override
	public int delete(TravelVO vo) {
		logger.info("delete().." + vo);
		int flag = sqlSession.delete("t_delete", vo);

		return flag;
	}

	@Override
	public TravelVO selectOne(TravelVO vo) {
		logger.info("selectOne().." + vo);
		TravelVO vo2 = sqlSession.selectOne("t_selectOne", vo);

		return vo2;
	}

	@Override
	public List<TravelVO> selectAll(int page) {
		logger.info("selectAll()..");
		logger.info("page: {}", page);
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + blockCount - 1;
		logger.info("startRow: {}", startRow);
		logger.info("endRow: {}", endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<TravelVO> vos = sqlSession.selectList("t_selectAll", map);

		return vos;
	}

	@Override
	public List<TravelVO> searchLIst(String searchWord) {
		logger.info("searchLIst()..");
		logger.info("searchWord: " + searchWord);
		
		List<TravelVO> vos = sqlSession.selectList("t_searchList", "%" + searchWord + "%");

		return vos;
	}

	@Override
	public int myInsert(TravelVO vo) {
		logger.info("myInsert().." + vo);
		// mapper에 아이디 admin으로 강제 설정해놓음
		int flag = sqlSession.insert("t_myInsert", vo);
		return flag;
	}

	@Override
	public List<TravelVO> mySelectAll(String session_id) {
		logger.info("myselectAll()..");
		List<TravelVO> vos = sqlSession.selectList("t_mySelectAll", session_id);
		return vos;
	}

	@Override
	public int myDelete(TravelVO vo) {
		logger.info("myDelete().." + vo);
		int flag = sqlSession.delete("t_myDelete", vo);

		return flag;
	}

	@Override
	public List<TravelVO> mySelectAll_admin() {
		logger.info("myselectAll_admin()..");
		List<TravelVO> vos = sqlSession.selectList("t_mySelectAll_admin");

		return vos;
	}

	@Override
	public int getPage_count() {
		logger.info("getPage_count()..");

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blockCount", blockCount);

		int page_count = sqlSession.selectOne("t_getPagecount", map);

		return page_count;
	}

}
