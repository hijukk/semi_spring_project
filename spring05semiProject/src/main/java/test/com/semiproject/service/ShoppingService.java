package test.com.semiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.semiproject.model.ShoppingDAO;
import test.com.semiproject.model.ShoppingVO;

@Service
public class ShoppingService {
	@Autowired
	ShoppingDAO dao;
	
	public List<ShoppingVO> selectAll(){
		
		return dao.selectAll();
	}

	public List<ShoppingVO> json_productCheck(String product) {
		
		return dao.json_productCheck(product);
	}
	
}
