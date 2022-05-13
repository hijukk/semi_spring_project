package test.com.semiproject.model;

import java.util.List;

public interface ARSDAO {
	public JoinVO ars_phonecheck(JoinVO vo);

	public List<ARSVO> ars_phoneplan();

	public List<ARSVO> ars_optservice();
	
	
}
