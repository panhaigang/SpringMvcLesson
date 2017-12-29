package cn.et.springmvc.lesson03;



import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.et.springmvc.lesson01.User;
/**
 *   http:......s1?id=1
 * 请求转发  forward
 * 请求重定向  redirect
 * 
 */
@SessionAttributes("user")
@Controller
public class ModelController {
	@ModelAttribute("user")
	public User getUser(){
		User user=new User();
		return user;
	}
	
	
	
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(Map map,User user){
		map.put("A", "a");
		return "/s2";
	}
	
	
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(String id,Map map,HttpServletResponse res,SessionStatus s) throws IOException{
		//res.getWriter().println(map.get("A"));
		User user=(User)map.get("user");
		res.getWriter().println(user.getId());
		s.setComplete();
		return null;
	}
}
