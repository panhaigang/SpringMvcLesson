package cn.et.springmvc.lesson06.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	
	public static void parseObject(){
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		
		JSONObject jo=JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	
	public static void parseArray(){
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		
		Map map1=new HashMap();
		map1.put("id", "2");
		map1.put("username", "B");
		
		List list=new ArrayList();
		list.add(map);
		list.add(map1);
		
		JSONArray jo=JSONArray.fromObject(list);
		System.out.println(jo.toString());
	}
	
	
	public static void main(String[] args) {
		//parseObject();
		parseArray();
	}
}
