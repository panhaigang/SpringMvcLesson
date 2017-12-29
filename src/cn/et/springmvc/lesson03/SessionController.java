package cn.et.springmvc.lesson03;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc中model相关对象  是处理和数据相关的对象
 * 	@ModelAttribute  重命名  参数数据
 * 	Model(ModelMap|Map) 传递数据到视图(request.setAttribute)
 *
 *
 *	ModelAndView  绑定数据到视图（ModelAndView用于传递数据 view对象用于跳转）
 */
@Controller
public class SessionController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map){
		map.put("A","B");
		return "/lesson03/res.jsp";
	}
	
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2(){
		ModelAndView mav=new ModelAndView("/lesson03/res.jsp");
		//mav.setViewName("/lesson03/res.jsp");
		mav.addObject("A","C");
		return mav;
	}
}
