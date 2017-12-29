package cn.et.springmvc.lesson01;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
	/*@Autowired
	JdbcTemplate jdbc;
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String index(@PathVariable(value="id") String id,HttpServletResponse response) throws IOException{
		String sql="select * from str where id="+id;
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		return "/index.jsp";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(String name,HttpServletResponse response) throws IOException{
		response.getWriter().println(name);
		return null;
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String update(@PathVariable String id,HttpServletResponse response) throws IOException{
		response.getWriter().println(id+"----update success");
		return null;
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable String id,HttpServletResponse response) throws IOException{
		response.getWriter().println(id+"----delete success");
		return null;
	}*/
}
