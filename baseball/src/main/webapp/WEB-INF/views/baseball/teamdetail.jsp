<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<section id="page">
    <header>Header

        <button class="menu">버튼</button>

    </header>
   <main0>
       <div class="menu1"><h1>btn</h1></div>
       <h3>선수 명단</h3><div class="div">
		
   </div>
   </main0>
    <main1>
        <h3>팀 기록</h3>
        <div class="teamrecord">
        		<table>
        		<tr>
        		<td><h3>팀이름</h3></td>
        		<td><h3>WAR</h3></td>
        		<td><h3>G</h3></td>
        		<td><h3>타석</h3></td>
        		<td><h3>타수</h3></td>
        		<td><h3>득점</h3></td>
        		<td><h3>안타</h3></td>
        		<td><h3>이타</h3></td>
        		<td><h3>삼타</h3></td>
        		<td><h3>홈런</h3></td>
        		<td><h3>루타</h3></td>
        		<td><h3>타점</h3></td>
        		<td><h3>도루</h3></td>
        		<td><h3>도실</h3></td>
        		<td><h3>볼넷</h3></td>
        		<td><h3>사구</h3></td>
        		<td><h3>고사</h3></td>
        		<td><h3>삼진</h3></td>
        		<td><h3>병살</h3></td>
        		<td><h3>타율</h3></td>
        		<td><h3>출투율</h3></td>
        		<td><h3>장타율</h3></td>
        		<td><h3>OPS</h3></td>
        		
        		</tr>
        		
        		<c:forEach var="teamrecord" items="${teamrecord}"> 
				<tr>
					<td><h3>${teamrecord.teamname}</h3></td>
					<td><h3>${teamrecord.war}</h3></td>
					<td><h3>${teamrecord.game}</h3></td>
					<td><h3>${teamrecord.hs}</h3></td>
					<td><h3>${teamrecord.hn}</h3></td>
					<td><h3>${teamrecord.pt}</h3></td>
					<td><h3>${teamrecord.hit}</h3></td>
					<td><h3>${teamrecord.h2}</h3></td>
					<td><h3>${teamrecord.h3}</h3></td>
					<td><h3>${teamrecord.homerun}</h3></td>
					<td><h3>${teamrecord.bh}</h3></td>
					<td><h3>${teamrecord.rbi}</h3></td>
					<td><h3>${teamrecord.sb}</h3></td>
					<td><h3>${teamrecord.sf}</h3></td>
					<td><h3>${teamrecord.bb}</h3></td>
					<td><h3>${teamrecord.ddb}</h3></td>
					<td><h3>${teamrecord.ifb}</h3></td>
					<td><h3>${teamrecord.so}</h3></td>
					<td><h3>${teamrecord.doubleout}</h3></td>
					<td><h3>${teamrecord.avg}</h3></td>
					<td><h3>${teamrecord.obp}</h3></td>
					<td><h3>${teamrecord.sig}</h3></td>
					<td><h3>${teamrecord.ops}</h3></td>					
				</tr>
				</c:forEach>
				</table>
				
				
				
        </div>
   </main1>
   
   
    <main2><h3>팀 관련 뉴스</h3><div class="div"></div></main2>
    <main3><h3>선수</h3><div class="div"></div></main3>

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
    });
    $("main0").on("click", function () {
        $(".menu1").hide();
    })
    $("main1").on("click", function () {
        $(".menu1").hide();
    })
    $("main2").on("click", function () {
        $(".menu1").hide();
    })
    $("main3").on("click", function () {
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
        background-size: 100%
    }


    #page {
        display: grid;
        width: 100%;
        height: 100%;
        grid-template-areas: "head "
        "main0"
        "main1"
        "main2"
        "main3"
        "foot";
        grid-template-rows: 5% 20% 25% 25% 20% 5%;
        grid-template-columns: 100%;


    }

    #page > header {
        grid-area: head;
        background-color: #C8DAF2;

    }


    #page > main0 {
        grid-area: main0;
        background-color: #E5E5E5;
    }

    #page > main1 {
        grid-area: main1;


    }
    #page > main2 {
        grid-area: main2;


    }
    #page > main3 {
        grid-area: main3;


    }
    .div {
        margin: 20px;
        border: 5px solid #D42E22;
        padding: 10%;
         background-color: rgba( 255, 255, 255, 0.5 );
    }
    .teamrecord {

        margin: 20px;
        border: 5px solid #477FD6;
        padding: 1px;
        background-color: #C8DAF2;
    }
    



    #page > footer {
        grid-area: foot;
        background-color: #C8DAF2;


    }



</style>
</body>

</html>