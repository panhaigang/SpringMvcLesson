package cn.et.springmvc.lesson03;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * ���ʽ
 * 
 * ����ʽ 
 * 
 * 
 * 
 * ��̨��֤����
 * 	1��javabean������֤ע��
 * 	2��action��ʹ��@valid��ʾjavabean  ʹ��Errors����BindingResult�ж��Ƿ���֤ʧ��
 * 	3������jar����ͻ
 * @author THINK
 *
 */
@Controller
public class RegController {
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	//@ModelAttribute("userInfo")  �޸Ķ�����   
	public String index(@ModelAttribute("userInfo") @Valid UserInfo user,BindingResult error){
		if(!user.getPassword().equals(user.getRepassword())){
			error.addError(new FieldError("userInfo","repassword","�����������벻һ��"));
		}
		if(user.getAge()==null||"".equals(user.getAge())){
			error.addError(new FieldError("userInfo","age","���䲻�ܿ�"));
		}else{
			Integer age;
			try {
				age = Integer.parseInt(user.getAge());
				if(age<1||age>100){
					error.addError(new FieldError("userInfo","age","���䲻�Ϸ�"));
				}
			} catch (NumberFormatException e) {
				error.addError(new FieldError("userInfo","age","����������"));
			}
		}
		if(error.hasErrors()){
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/suc.jsp";
	}
}