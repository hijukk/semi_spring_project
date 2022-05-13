package test.com.semiproject.model;

import java.util.List;

public interface TravelDAO {
	public int insert(TravelVO vo);

	public int update(TravelVO vo);

	public int delete(TravelVO vo);

	public int myDelete(TravelVO vo);

	public TravelVO selectOne(TravelVO vo);

	public List<TravelVO> selectAll(int page);

	public List<TravelVO> searchLIst(String searchWord);

	public int myInsert(TravelVO vo);

	public List<TravelVO> mySelectAll(String session_id);

	public List<TravelVO> mySelectAll_admin();
	
	public int getPage_count();

}
