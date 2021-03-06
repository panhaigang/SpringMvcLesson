<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'list.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	function query() {
		var xmlhttp=null;
		//兼容所有的浏览器 创建XHR对象
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		//回调函数  当请求发送后  收到结果自动调用该方法
		xmlhttp.onreadystatechange=function() {
		/*
			xmlhttp.readyState存有XMLHttpRequest的状态。readyState从0到4 发生变化
			xmlhttp.readyState=0：请求未初始化（没有调用send方法）
			xmlhttp.readyState=1：服务器连接已建立（socket已连接）
			xmlhttp.readyState=2：请求已接收（获取到了参数 没有执行action方法）
			xmlhttp.readyState=3：请求处理中（已经在执行action方法 未执行完）
			xmlhttp.readyState=4：请求已完成，且响应已就绪（已经响应  并且能获取到最终的数据）

			xmlhttp.status==200：响应状态  200表示成功
		

		*/
		
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    	var resultJson=xmlhttp.responseText;
		    	//转化为js对象  返回为一个集合
		    	var resultObj=JSON.parse(resultJson);
		    	
		    	//获取表格id为myTable对象
		    	var table=document.getElementById("myTable");
		    	//获取所有的name为dataTr的tr
		    	var allDataTr=document.getElementsByName("dataTr");
		    	for(var i=0;allDataTr.length;i++){
		    		//数组是动态变化的   删了第一个 第二个会变成第一个
		    		table.removeChild(allDataTr[0]);
		    	}
		    	
		    	//展示查询的结果
		    	for(var i=0;i<resultObj.length;i++){
		    		var obj=resultObj[i];
		    		
		    		//获取td对象
		    		var td=document.createElement("td");
		    		//设值
		    		td.innerText=obj.foodName;
		    		var td1=document.createElement("td");
		    		td1.innerText=obj.price;
		    		
		    		//获取tr对象
		    		var tr=document.createElement("tr");
		    		//给tr标签设一个标识
		    		tr.setAttribute("name","dataTr");
					//在tr追加td
					tr.appendChild(td);
					tr.appendChild(td1);
					//把tr追加到table后
		    		table.appendChild(tr);
		    	}
		    }
	  }
	  
	  	var foodname=document.getElementsByName("foodName")[0].value;
		//get请求
		/*xmlhttp.open("GET","${pageContext.request.contextPath}/popo?foodname="+foodname,true);
		xmlhttp.send();*/
		/*
			一个ajax线程是否执行完成  可以通过回调函数xmlhttp.onreadystatechange  是否执行完成来判断
			异步  多个线程同时执行 无法判断 谁先执行  true
			同步  一次只允许一个线程执行 false
		
		*/
		//post请求
		xmlhttp.open("POST","${pageContext.request.contextPath}/queryFoodList",true);
		//charset=UTF-8  解决乱码问题
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
		xmlhttp.send("foodname="+foodname);
	}
</script>

	</head>

	<body>
		<input type="text" name="foodName">
		<input type="button" value="提交" onclick="query()">
	</body>

	<table id="myTable">
		<tr><th>菜品名</th><th>菜品价格</th></tr>
	</table>
</html>
