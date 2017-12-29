package cn.et.springmvc.lesson04;




import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 */
@Controller
public class RController {
	@RequestMapping(value="/inter",method=RequestMethod.GET)
	public String ir(HttpServletResponse re) throws IOException{
		re.getWriter().println("dd");
		return null;
	}
}