<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<section id="page">
    <header>Header
      <button class="menu">버튼</button>
    </header>

  <main1>
        <div class="menu1"><h1>btn</h1></div>
        <h3>팀 순위</h3>
        <div class="div">
        
        		<table>
        		<tr>
        		<td><h3>순위</h3></td>
        		<td><h3>팀이름</h3></td>
        		<td><h3>게임</h3></td>
        		<td><h3>승리</h3></td>
        		<td><h3>패</h3></td>
        		<td><h3>무승부</h3></td>
        		<td><h3>승률</h3></td>
        		<td><h3>게임차</h3></td>
        		<td><h3>최근 10경기</h3></td>
        		<td><h3>연속</h3></td>
        		<td><h3>홈</h3></td>
        		<td><h3>방문</h3></td>
        		
    
        		</tr>
        		
        		<c:forEach var="teamrank" items="${teamrank}"> 
				<tr>
					<td><h3>${teamrank.rank}</h3></td>
					<td><h3>${teamrank.teamname}</h3></td>
					<td><h3>${teamrank.game}</h3></td>
					<td><h3>${teamrank.victory}</h3></td>
					<td><h3>${teamrank.lose}</h3></td>
					<td><h3>${teamrank.draw}</h3></td>
					<td><h3>${teamrank.gameodds}</h3></td>
					<td><h3>${teamrank.gamecar}</h3></td>
					<td><h3>${teamrank.recentgames}</h3></td>
					<td><h3>${teamrank.continuity}</h3></td>
					<td><h3>${teamrank.home}</h3></td>
					<td><h3>${teamrank.visiting}</h3></td>
								
				</tr>
				</c:forEach>
				</table>
        	
        	
        </div>
    </main1>
    <footer>Footer</footer>
</section>


<script
        src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>
<script>
    $(".menu1").hide();

    $(".menu").on("click", function () {
        $(".menu1").show('slow');
    })
    $("main1").on("click", function () {
        $(".menu1").hide();
    })
 </script>

<style>

.menu1 {
        position: absolute;
        display: block;
        background-color: #FFCCCC;
        width: 400px;
        height: 800px;
        -webkit-transform: rotate(0deg);
        transform: rotate(0deg);
        position: absolute;
    }
    html, body{
        height: 100%;
    }
    body{
        background-image: url('/resources/img/background.jpg');
        background-size: 100% ;
    }
    #page {
        display: grid;
        width: 100%;
        height: 100%;
        grid-template-areas: "head "
        "main1"
        "foot";
        grid-template-rows: 5% 90% 5%;
        grid-template-columns: 100%;
    }

    #page > header {
        grid-area: head;
        background-color: #C8DAF2;

    }


    #page > main1 {
        grid-area: main1;
     
    }

    .div {

        width:90%;
        height: 90%;
        margin: 5%;
        border: 2px solid red;
        background-color: rgba( 255, 255, 255, 0.5 );
        

/*     } */


    #page > footer {
        grid-area: foot;
        background-color: #C8DAF2;

    }



</style>
</body>

</html>

</html>