package cn.et.springmvc.lesson06.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyFoodDapImpl {
	@Autowired
	JdbcTemplate jdbc;
	public List<Map<String, Object>> queryAllFood(String foodname){
		String sql="select * from food where foodName like '%"+foodname+"%'";
		return jdbc.queryForList(sql);
	}
	
	public void deleteFood(String foodid){
		String sql="delete from food where foodid="+foodid;
		jdbc.execute(sql);
	}
	
	public void saveFood(String foodname,String price){
		String sql="insert into food(foodName,price) values('"+foodname+"','"+price+"')";
		jdbc.execute(sql);
	}
	
	public void updateFood(String foodid,String foodname,String price){
		String sql="update food set foodName='"+foodname+"',price='"+price+"' where foodid="+foodid;
		jdbc.execute(sql);
	}
}
