package test.com.semiproject.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ARSDAOImpl implements ARSDAO {
	private static final Logger logger = LoggerFactory.getLogger(ARSDAOImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public JoinVO ars_phonecheck(JoinVO vo) {
		logger.info("ars_phonecheck");
		JoinVO vo2 = sqlSession.selectOne("ars_phonecheck", vo);
		
		return vo2;
	}


	@Override
	public List<ARSVO> ars_phoneplan() {
		logger.info("ars_phoneplan");
		
		List<ARSVO> vos = sqlSession.selectList("ars_phoneplan");
		return vos;
	}


	@Override
	public List<ARSVO> ars_optservice() {
		logger.info("ars_optservice");
		List<ARSVO> vos = sqlSession.selectList("ars_optservice");
		
		return vos;
	}

}
