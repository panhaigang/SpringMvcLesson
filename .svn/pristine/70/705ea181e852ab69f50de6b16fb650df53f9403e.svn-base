package cn.et.springmvc.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	/*
	 * @RequestMapping注解是一个用来处理请求地址映射的注解，可用于类或方法上。
	 * 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
	 * 
	 */
	
	
	//request 接收参数
	@RequestMapping("/test")
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().println("hello springmvc="+request.getParameter("id"));
		return null;
	}
	
	
	//实体类接受参数
	@RequestMapping("/param")
	public String param(User user,HttpServletResponse response) throws IOException{
		response.getWriter().println(user.getId()+"---"+user.getName());
		return null;
	}
	
	//跳转到index.jsp
	@RequestMapping("/mvc")
	public String mvc(HttpServletRequest request) {
		request.setAttribute("a","zs");
		return "/index.jsp";
	}
}
