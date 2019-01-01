package com.asamu.plmp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.asamu.plmp.pojo.entity.UserDO;
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
	//在控制器执行前调用
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		UserDO user = (UserDO)session.getAttribute("user");
		if(user==null) {//未登录
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		return true;
	}
}
