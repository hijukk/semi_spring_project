package test.com.semiproject.model;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoginDAOImpl implements LoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	@Autowired
	SqlSession sqlSession;

	@Override
	public LoginVO login(LoginVO vo) {
		logger.info("login()..{}", vo);
		LoginVO vo2 = sqlSession.selectOne("login", vo);

		return vo2;
	}

}
