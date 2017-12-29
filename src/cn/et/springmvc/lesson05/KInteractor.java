package cn.et.springmvc.lesson05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




public class KInteractor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//����action������֮ǰִ��
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//��ȡ�����е�myToken�����ֵ
		String m=request.getParameter("myToken");
		//��ȡ��һ�η���ҳ��ʱ��session�����ֵ
		Object m1=request.getSession().getAttribute("myToken");
		//��m��Ϊ��   ˵�������ύ   ��Ҫ�ж��Ƿ����ظ��ύ
		if(m!=null){
			//��m1��Ϊ��  session����ֵ   ���������ظ��ύ
			if(m1!=null){
				//Ϊ�˷�ֹ�����������۸�   ��Ҫ�ж����ر�����session�е�ֵ�Ƿ����
				if(m.equals(m1)){
					//��session�е�Ψһ��ʾ�����
					request.getSession().removeAttribute("myToken");
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
}