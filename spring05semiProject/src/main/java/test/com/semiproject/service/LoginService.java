package test.com.semiproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.semiproject.model.LoginDAO;
import test.com.semiproject.model.LoginVO;

@Service
public class LoginService {
	@Autowired
	LoginDAO dao;

	public LoginVO login(LoginVO vo) {
		return dao.login(vo);
	}

}
