package cn.et.springmvc.lesson04.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class UserInfo {
	/**
	 * NotNull 属性名 !=null
	 * NotEmpty 属性名!=null &&  !属性名.equals("")
	 */
	@NotEmpty(message="{userError}")
	private String userName;

	@NotEmpty(message="{passwordError}")
	private String password;
	
	@NotEmpty(message="{repasswordError}")
	private String repassword;
	
	// lixin@126.com  
	//@Pattern(message="邮箱格式错误",regexp=".+@.+\\..+")
	@Email(message="{mailboxError}")  
	private String email;
	
	@NotEmpty(message="{ageError}")
	@Max(value=100,message="{maxError}")
	@Min(value=1,message="{minError}")
	private String age;
	
	@Size(min=11, max=11,message="{phoneError}")
	private String phone;
	@Pattern(message="{websiteError}",regexp="^(?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*$")
	private String website;
	@Pattern(message="{dateError}",regexp="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")
	private String date;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "UserInfo [age=" + age + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", repassword=" + repassword
				+ ", userName=" + userName + "]";
	}
}
