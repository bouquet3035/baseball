<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<head>

<title>Insert title here</title>
</head>
<body>
<section id="page">
    <header>

       

    </header>

     
 
    <main1>
       <div class="menu1"><h1>btn</h1></div>
        <h1>팀 기록</h1>
        <div class = teamrecord >
        
        	<table id="teamrecord">
        	</table>
        </div>
   </main1>
   

    <main2><h1>팀 관련 뉴스</h1>
    <div class="div" id="teamnews">
				<ul>
					
				</ul>
    </div>
    </main2>

    
    <main3><h1>선수</h1>
	<div class="div" >
		
		<table id="teamplayer"> 
	
		<!--페이지 처리  -->	
		<ul class ="pagination">
			<input type = 'hidden' name = 'page' value =${pageMaker.cri.perPageNum} >
			<input type = 'hidden' name = 'perPageNum' value =${pageMaker.cri.perPageNum} >
		</ul>
				
			
		</table>
		
		
	
    </div>
    
    </main3>


    <footer></footer>
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

<script>

$(document).ready(function(){
	
	var getParameters = function (paramName) {
	    // 리턴값을 위한 변수 선언
	    var returnValue;

	    // 현재 URL 가져오기
	    var url = location.href;

	    // get 파라미터 값을 가져올 수 있는 ? 를 기점으로 slice 한 후 split 으로 나눔
	    var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');

	    // 나누어진 값의 비교를 통해 paramName 으로 요청된 데이터의 값만 return
	    for (var i = 0; i < parameters.length; i++) {
	        var varName = parameters[i].split('=')[0];
	        if (varName.toUpperCase() == paramName.toUpperCase()) {
	            returnValue = parameters[i].split('=')[1];
	            return decodeURIComponent(returnValue);
	        }
	    }
	};
	
	
	var teamname = getParameters('teamname');
	
	console.log(teamname);
	
	
	
	function shownews() {
		 var str = "";
		 var url = "/baseball/teamdetail/"+ teamname +"";
		 
		
		 $.getJSON(url,function(arr){
		 
			for(var i = 0; i < arr.length; i++){
								
				str += "<li><h2><a href='http://sports.news.naver.com/"+ arr[i].url +"' >"+arr[i].title +"</a></h2></li>";
				$("#teamnews").html(str);
		
			}
		 });
	
	}shownews();
	
	
	function showrecord() {
		
		 var str = "";
		 var url = "/baseball/teamrecord/"+teamname+"";
		
		
		 
		 $.getJSON(url,function(arr){

					 
		 	 str +="<tr>"
		 	 +"<th><h3>팀이름</h3></th>"
		 	+"<th><h3>WAR</h3></th>"
		 	+"<th><h3>G</h3></th>"
		 	+"<th><h3>타석</h3></th>"
		 	+"<th><h3>득점</h3></th>"
		 	+"<th><h3>안타</h3></th>"
		 	+"<th><h3>이타</h3></th>"
		 	+"<th><h3>삼타</h3></th>"
		 	+"<th><h3>홈런</h3></th>"
		 	+"<th><h3>루타</h3></th>"
		 	+"<th><h3>타점</h3></th>"
		 	+"<th><h3>도루</h3></th>"
		 	+"<th><h3>도실</h3></th>"
		 	+"<th><h3>볼넷</h3></th>"
			+"<th><h3>사구</h3></th>"
			+"<th><h3>고사</h3></th>"
			+"<th><h3>삼진</h3></th>"
			+"<th><h3>병살</h3></th>"
			+"<th><h3>타율</h3></th>"
			
			+"<tr>"
       	
			
			+"<tr>" 
			+"<td><h3>"+arr.teamname +"</h3></td>"
			+"<td><h3>"+arr.war +"</h3></td>"
			+"<td><h3>"+arr.game +"</h3></td>"
			+"<td><h3>"+arr.hs +"</h3></td>"
			+"<td><h3>"+arr.hn +"</h3></td>"
			+"<td><h3>"+arr.pt +"</h3></td>"
			+"<td><h3>"+arr.hit +"</h3></td>"
			+"<td><h3>"+arr.h2 +"</h3></td>"
			+"<td><h3>"+arr.h3 +"</h3></td>"
			+"<td><h3>"+arr.homerun +"</h3></td>"
			+"<td><h3>"+arr.bh +"</h3></td>"
			+"<td><h3>"+arr.rbi +"</h3></td>"
			+"<td><h3>"+arr.sb +"</h3></td>"
			+"<td><h3>"+arr.sf +"</h3></td>"
			+"<td><h3>"+arr.bb +"</h3></td>"
			+"<td><h3>"+arr.ddb +"</h3></td>"
			+"<td><h3>"+arr.ifb +"</h3></td>"
			+"<td><h3>"+arr.so +"</h3></td>"
			+"<td><h3>"+arr.doubleout +"</h3></td>"
		
			
			+"</tr>"
			
			
			 
			 $('#teamrecord').html(str);
			
		});

	}showrecord();	
	
	
	function showplayer() {
		
		 var str = "";
		 var url = "/baseball/playerdetail/"+teamname+"";
		
		 console.log(url); 	
		 
		 $.getJSON(url,function(arr){
			 
			 console.log(arr); 
					 
				 	 str +="<tr>"
				 	 +"<th><h3>선수명</h3></th>"
					 +"<th><h3>포지션</h3></th>"
				
					 
					 +"</tr>"
			 
			
					 for(var i = 0; i < arr.length; i++){			
					str += "<tr>" 
							+"<td><h3>"+"<a href =/baseball/playerdetail?playername="+arr[i].playerName+">"+arr[i].playerName +"</a>"+"</h3></td>"
							
							+"<td><h3>"+arr[i].position +"</h3></td>"
						
							+"</tr>"
					 }
			
		 	 $('#teamplayer').html(str);
		 	 	
			 });
	
	}showplayer();
	
	
	
});
</script>


<style>


table{
		table-layout:fixed ;
		border: 1px solid thick;	
		 border-collapse: collapse;
		}
		
th, td {
  border: 1px solid #444444;
  word-break:break-all;
  font-size: 25px;
  }




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
        background-image: url('/resources/img/image5.jpg');
        background-size: 100%
    }


    #page {
        display: grid;
        width: 100%;
        height: 100%;
        grid-template-areas: "head"
        "main1"
        "main2"
        "main3"
        "foot";
        grid-template-rows: 5% 30% 50% 30% 5%;
        grid-template-columns: 100%;


    }

    #page > header {
        grid-area: head;
       

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
        margin: 0px;
        border: 5px solid #D42E22;
        padding: 10%;
        background-color: rgba( 255, 255, 255, 0.5 );
    }
    .teamrecord {

        margin: 0px;
        border: 5px solid #477FD6;
        padding: 1px;
         background-color: rgba( 255, 255, 255, 0.5 );
    }
     .teamplayer {


        border: 5px solid #477FD6;
        
        background-color: rgba( 255, 255, 255, 0.5 );
    }
    



    #page > footer {
        grid-area: foot;
       


    }



</style>
</body>

</html>