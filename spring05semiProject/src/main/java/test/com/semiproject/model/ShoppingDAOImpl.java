package test.com.semiproject.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingDAOImpl implements ShoppingDAO {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingDAOImpl.class);
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ShoppingVO> selectAll() {
		logger.info("selectAll()...");
		
		List<ShoppingVO> vos = sqlSession.selectList("shop_selectAll");
		return vos;
	}

	@Override
	public List<ShoppingVO> json_productCheck(String product) {
		logger.info("json_productCheck()...");
		List<ShoppingVO> vos = sqlSession.selectList("json_productCheck", "%" + product + "%");
		return vos;
	}


}
