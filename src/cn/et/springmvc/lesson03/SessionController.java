package cn.et.springmvc.lesson03;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc��model��ض���  �Ǵ����������صĶ���
 * 	@ModelAttribute  ������  ��������
 * 	Model(ModelMap|Map) �������ݵ���ͼ(request.setAttribute)
 *
 *
 *	ModelAndView  �����ݵ���ͼ��ModelAndView���ڴ������� view����������ת��
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
