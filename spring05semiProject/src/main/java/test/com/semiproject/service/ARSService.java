package test.com.semiproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.semiproject.model.ARSDAO;
import test.com.semiproject.model.ARSVO;
import test.com.semiproject.model.JoinVO;

@Service
public class ARSService {
	@Autowired
	ARSDAO dao;
	
	public JoinVO ars_phonecheck(JoinVO vo) {
			return dao.ars_phonecheck(vo);
	}

	public List<ARSVO> ars_phoneplan() {
		return dao.ars_phoneplan();
	}

	public List<ARSVO> ars_optservice() {
		return dao.ars_optservice();
	}

}
