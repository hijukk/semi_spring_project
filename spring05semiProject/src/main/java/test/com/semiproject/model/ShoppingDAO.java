package test.com.semiproject.model;

import java.util.List;

public interface ShoppingDAO {

	public List<ShoppingVO> selectAll();

	public List<ShoppingVO> json_productCheck(String product);



}
