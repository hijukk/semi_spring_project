package test.com.semiproject.model;

import java.util.List;

public interface ReviewDAO {
	public int rInsert(ReviewVO vo);

	public int rUpdate(ReviewVO vo);

	public int rDelete(ReviewVO vo);

	public ReviewVO rSelectOne(ReviewVO vo);

	public List<ReviewVO> rSelectAll(int page);

	public List<ReviewVO> rSearchList(String searchKey, String searchWord);

	public int getRpage_count();

}
