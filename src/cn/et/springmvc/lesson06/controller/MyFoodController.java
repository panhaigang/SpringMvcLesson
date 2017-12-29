package cn.et.springmvc.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.springmvc.lesson06.dao.MyFoodDapImpl;

@Controller
public class MyFoodController {
	@Autowired
	MyFoodDapImpl mdi;
	//查询
	
	/**
	 * 原始的输出json方式
	 * 	OutputStream os;
	 * 	os.write(通过第三方json-lib转换的json字符串.getByte())
	 */
	@RequestMapping(value="/popo",method=RequestMethod.GET)
	public String queryFood(String foodname, OutputStream os) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryAllFood = mdi.queryAllFood(foodname);
		JSONArray arry=JSONArray.fromObject(queryAllFood);
		String j=arry.toString();
		os.write(j.getBytes("UTF-8"));
		return null;
	}
	
	/**
	 * 直接返回 字節數組   記得加@ResponseBody註解
	 * @param foodname
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodReturn",method=RequestMethod.GET)
	public byte[] queryFoodReturn(String foodname) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryAllFood = mdi.queryAllFood(foodname);
		JSONArray arry=JSONArray.fromObject(queryAllFood);
		String j=arry.toString();
		return j.getBytes("UTF-8");
	}
	
	/**
	 * 直接返回一个对象  需要加@ResponseBody註解
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodList",method=RequestMethod.GET)
	public List<Map<String, Object>> queryFoodList(String foodname) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryAllFood = mdi.queryAllFood(foodname);
		return queryAllFood;
	}
	
	//删除
	@RequestMapping(value="/deleteFood/{foodid}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodid, OutputStream os) throws UnsupportedEncodingException, IOException{
		try{
			mdi.deleteFood(foodid);
			os.write("1".getBytes("UTF-8"));
		}catch(Exception e){
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	
	
	//修改
	@RequestMapping(value="/updateFood/{foodid}",method=RequestMethod.PUT)
	public String updateFood(@PathVariable String foodid,String foodname,String price, OutputStream os) throws UnsupportedEncodingException, IOException{
		try{
			mdi.updateFood(foodid, foodname, price);
			//返回以代表成功
			os.write("1".getBytes("UTF-8"));
		}catch(Exception e){
			//返回0代表失败
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	
	
	//增加
	@RequestMapping(value="/saveFood",method=RequestMethod.POST)
	public String saveFood(String foodname,String price, OutputStream os) throws UnsupportedEncodingException, IOException{
		try{
			mdi.saveFood(foodname, price);
			os.write("1".getBytes("UTF-8"));
		}catch(Exception e){
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
