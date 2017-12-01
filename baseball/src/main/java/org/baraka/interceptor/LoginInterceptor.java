package org.baraka.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final String LOGIN ="login" ; 
	private static final Logger logger =LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception{
		
		HttpSession session = request.getSession() ;
		
		ModelMap modelMap = modelAndView.getModelMap() ;
		Object UserDTO = modelMap.get("UserDTO") ; 
		
		if(UserDTO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, UserDTO);
			response.sendRedirect("/");
		}
		
		
	}
	
	
	@Override
	public boolean preHandle (HttpServletRequest requset, HttpServletResponse response, Object object) throws Exception{
		HttpSession session = requset.getSession() ; 
		
		if(session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
			
		}
		return true ; 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

} 
