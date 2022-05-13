package test.com.semiproject.model;

import java.util.List;

public interface JoinDAO {
	public int jInsert(JoinVO vo);

	public int jUpdate(JoinVO vo);

	public int jDelete(JoinVO vo);

	public JoinVO jSelectOne(JoinVO vo);

	public List<JoinVO> jSelectAll(int page);

	public List<JoinVO> jSearchList(String searchKey, String searchWord);
	
	public JoinVO idCheck(JoinVO vo);

	public int getJpage_count();

}
