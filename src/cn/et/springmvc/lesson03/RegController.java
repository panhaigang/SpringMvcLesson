package cn.et.springmvc.lesson03;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 编程式
 * 
 * 生名式 
 * 
 * 
 * 
 * 后台验证步骤
 * 	1、javabean添加验证注解
 * 	2、action中使用@valid表示javabean  使用Errors或者BindingResult判断是否验证失败
 * 	3、出现jar包冲突
 * @author THINK
 *
 */
@Controller
public class RegController {
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	//@ModelAttribute("userInfo")  修改对象名   
	public String index(@ModelAttribute("userInfo") @Valid UserInfo user,BindingResult error){
		if(!user.getPassword().equals(user.getRepassword())){
			error.addError(new FieldError("userInfo","repassword","两次密码输入不一致"));
		}
		if(user.getAge()==null||"".equals(user.getAge())){
			error.addError(new FieldError("userInfo","age","年龄不能空"));
		}else{
			Integer age;
			try {
				age = Integer.parseInt(user.getAge());
				if(age<1||age>100){
					error.addError(new FieldError("userInfo","age","年龄不合法"));
				}
			} catch (NumberFormatException e) {
				error.addError(new FieldError("userInfo","age","必须是数字"));
			}
		}
		if(error.hasErrors()){
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/suc.jsp";
	}
}
