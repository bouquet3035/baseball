<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KBO 전체 경기 일정</title>
 
</head>
<body>
<style>
   
 table, tr, td{
    border:1px solid #000000;
    border-collapse:collapse;
    }
 table {
  width: 100%;
   }
 h1{
  text-align:center;
  }
 td {
  text-align: center;
  }
 a:active {text-decoration: none;}
  a:hover {text-decoration: none;}
  a:link {text-decoration: none;}
  a:visited {text-decoration: none;}
   body{
        background-image: url('/resources/img/background.jpg');
        background-size: 100%;
    }

 </style>



 <Header>
 Header

        <button class="menu">버튼</button>

    </Header>
    
    <body>


 

     <div class="playschedule">		
 					
     			<table>
     				
        		<tr>
        		<th>월</th>
        		<th>화</th>
        		<th>수</th>
        		<th>목</th>
        		<th>금</th>
        		<th>토</th>
        		<th>일</th>
        		</tr>
        <tr>	
        <c:forEach var="playschedule" items="${playschedule}" begin = "6" end="12" step="1">		
        		<td>${playschedule.days} ${playschedule.plays} </td>
        </c:forEach>
        </tr>
        
        <tr>
        <c:forEach var="playschedule" items="${playschedule}" begin = "13" end="19" step="1">	
        	<td>${playschedule.days} ${playschedule.plays} </td>	
			
        		</c:forEach>
        	</tr>
        	
		<tr>
        <c:forEach var="playschedule" items="${playschedule}" begin = "20" end="26" step="1">	
        	<td>${playschedule.days} ${playschedule.plays} </td>	
			
        		</c:forEach>
        	</tr>
        	
        		<tr>
        <c:forEach var="playschedule" items="${playschedule}" begin = "27" end="33" step="1">	
        	<td>${playschedule.days} ${playschedule.plays} </td>	
			
        		</c:forEach>
        	</tr>
        	
        	  <c:forEach var="playschedule" items="${playschedule}" begin = "34" end="40" step="1">	
        	<td>${playschedule.days} ${playschedule.plays} </td>	
			
        		</c:forEach>
        	</tr>
			
        	
				</table></div>
        	
    
</body>
</html>