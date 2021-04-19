<%@ page language="java" import="cn.edu.zjut.jprofiler.test.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>init</title>
	</head>
	<body>
		<%TestCPU.testCPU();
		%>
		CPU usage is controlled in Sin shape!<br />
		Thread Counter:<%=TestCPU.threadList.size()%>
	</body>
</html>
