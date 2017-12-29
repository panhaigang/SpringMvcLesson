package cn.et.springmvc.lesson05;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 */
@Controller
public class ViewController {
	@RequestMapping(value="/inte",method=RequestMethod.GET)
	public String ir(OutputStream os) throws IOException{
		os.write("dfdf".getBytes());
		return null;
	}
	
	@Autowired
	MoneyDaoImpl did;
	
	@RequestMapping(value="/pppp",method=RequestMethod.GET)
	public String ty(Integer m,OutputStream os) throws IOException{
		//ִ�п�Ǯ
		did.trasnateMoney(m);
		//��ѯ���
		os.write(("mmmm"+did.selectMoney()).getBytes());
		return null;
	}
}