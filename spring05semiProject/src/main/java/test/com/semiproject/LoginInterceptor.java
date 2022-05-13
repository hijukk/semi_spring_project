package test.com.semiproject;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Autowired
	ServletContext context;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle()..");

		String session_id = (String) request.getSession().getAttribute("session_id");
		logger.info("session_id: {}", session_id);
		
		//context
		String context_id = (String) context.getAttribute("context_id");
		logger.info("context: {}", context_id);
		
		String sPath = request.getServletPath();
		logger.info("sPath: {}", sPath);

		if (sPath.equals("/insert.do") || sPath.equals("/insertOK.do") || sPath.equals("/update.do")
				|| sPath.equals("/updateOK.do") || sPath.equals("/delete.do") || sPath.equals("/deleteOK.do")) {

			// admin만 들어갈수 있게 하는곳
			if (session_id == null || !session_id.equals("admin")) {
				response.sendRedirect("index.do");
				return false;
			}
		} else if (sPath.equals("/mySelectAll.do") || sPath.equals("/myInsertOK.do") || sPath.equals("/jSelectOne.do")
				|| sPath.equals("/jUpdate.do") || sPath.equals("/jDelete.do") || sPath.equals("/rSelectOne.do")
				|| sPath.equals("/jSelectAll.do")) {
			// 로그인 해야지 들어갈수 있는곳
			if (session_id == null) {
				response.sendRedirect("index.do");
				return false;
			}
		}
		return true;
	}

}
