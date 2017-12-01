<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>

<title>Insert title here</title>
</head>


<body>
<section id="page"  >


    <header>
       
    </header>

		<div class="menu1"><h1>btn</h1></div>
    <playimg class="playerimg"> 
    
    </playimg>
    <profile class="profile">
    	
    </profile>
    <playrecord class = "basicyearrecord" >2017 년 기록 
    	
    	
   		
        
    </playrecord>
    <behind >
        <div class="behind">
        

        </div>
    </behind>
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
    })
    $("profile").on("click", function () {
        $(".menu1").hide();
    })
    $("behind").on("click", function () {
        $(".menu1").hide();
    })
    $("playrecord").on("click", function () {
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
	
	
	var playername = getParameters('playername');
	
	console.log(playername) ; 
	
	//선수 이미지 
	function playerimg() {
		 var str = "";
		 var url = "/baseball/playerimg/"+ playername +"";
		 
		
		 $.getJSON(url,function(arr){
		 
			 	str += "<img src = "+ arr.playerImg +">"
			 	$('.playerimg').html(str);
			});
		 
	
	}playerimg();
	
	
	
	//선수 프로파일 
	function profile () {
		 var str = "";
		 var url = "/baseball/profile/"+ playername +"";
		 
		
		 $.getJSON(url,function(arr){
			
	 		str +=   "<div><p>등번호 :"+arr.playerNum+" </p></div>"
				       + "<div><p>이름 :"+arr.playerName+"</p></div>"
				       + "<div><p>포지션 :"+arr.position+"</p></div>"
				       + "<div><p>생년월일:"+arr.birthday+"</p></div>"
				       + "<div><p>체격:"+arr.hnW+"</p></div>"
				       + "<div><p>출신교:"+arr.school+"</p></div>"
				       + "<div>연봉 :"+arr.salary+"</div>"		 
				        $('.profile').html(str);
			});
		 
	
	}profile();
	
	
	//선수 2017년 정보
	function record () {
		 var str = "";
		 var url = "/baseball/record/"+ playername +"";
		 
		
		 $.getJSON(url,function(arr){

			 console.log(arr) ; 
			 
				//타자 정보 
			 if(arr.position == "타자"){
				 console.log("성공") ; 
				 str+= "<table>"
					+"<tr>"
				 	+"<th><h3>팀명</h3></th>"
				 	+"<th><h3>AVG</h3></th>"
				 	+"<th><h3>G</h3></th>"
				 	+"<th><h3>PA</h3></th>"
				 	+"<th><h3>AB</h3></th>"
				 	+"<th><h3>R</h3></th>"
				 	+"<th><h3>H</h3></th>"
				 	+"<th><h3>2B</h3></th>"
				 	+"<th><h3>3B</h3></th>"
				 	+"<th><h3>HR</h3></th>"
				 	+"<th><h3>TB</h3></th>"
				 	+"<th><h3>RBI</h3></th>"
				 	+"<th><h3>SB</h3></th>"
				 	+"<th><h3>CS</h3></th>"
				 	+"<th><h3>SAC</h3></th>"
				 	+"<th><h3>SF</h3></th>"
				 	+"</tr>"
				 	
					 str+= "<tr>"
						 	+"<td>"+arr.teamname+"</td>"
						 	+"<td>"+arr.avg+"</td>"
						 	+"<td>"+arr.g+"</td>"
						 	+"<td>"+arr.pa+"</td>"
						 	+"<td>"+arr.ab+"</td>"
						 	+"<td>"+arr.r+"</td>"
						 	+"<td>"+arr.h+"</td>"
						 	+"<td>"+arr.twob+"</td>"
						 	+"<td>"+arr.threeb+"</td>"
						 	+"<td>"+arr.hr+"</td>"
						 	+"<td>"+arr.tb+"</td>"
						 	+"<td>"+arr.rbi+"</td>"
						 	+"<td>"+arr.sb+"</td>"
						 	+"<td>"+arr.cs+"</td>"
						 	+"<td>"+arr.sac+"</td>"
						 	+"<td>"+arr.sf+"</td>"
						
						 	
						 	+"</tr>"
						 	+"</table>"
						 	
				 	
				 	
				 $('.basicyearrecord').html(str);
			 }else {

					//투수 정보 
				 str+= "<table>"
						+"<tr>"
					 	+"<th><h3>팀명</h3></th>"
					 	+"<th><h3>ERA</h3></th>"
					 	+"<th><h3>G</h3></th>"
					 	+"<th><h3>CG</h3></th>"
					 	+"<th><h3>SHO</h3></th>"
					 	+"<th><h3>W</h3></th>"
					 	+"<th><h3>L</h3></th>"
					 	+"<th><h3>SV</h3></th>"
					 	+"<th><h3>HLD</h3></th>"
					 	+"<th><h3>WPCT</h3></th>"
					 	+"<th><h3>NP</h3></th>"
					 	+"<th><h3>IP</h3></th>"
					 	+"<th><h3>H</h3></th>"
					 	+"<th><h3>2B</h3></th>"
					 	+"<th><h3>3B</h3></th>"
					 	+"<th><h3>HR</h3></th>"
					 	+"</tr>"
					 	
						 str+= "<tr>"
							 	+"<td>"+arr.teamname+"</td>"
							 	+"<td>"+arr.era+"</td>"
							 	+"<td>"+arr.g+"</td>"
							 	+"<td>"+arr.cg+"</td>"
							 	+"<td>"+arr.sho+"</td>"
							 	+"<td>"+arr.w+"</td>"
							 	+"<td>"+arr.l+"</td>"
							 	+"<td>"+arr.sv+"</td>"
							 	+"<td>"+arr.hld+"</td>"
							 	+"<td>"+arr.wpct+"</td>"
							 	+"<td>"+arr.np+"</td>"
							 	+"<td>"+arr.ip+"</td>"
							 	+"<td>"+arr.h+"</td>"
							 	+"<td>"+arr.twob+"</td>"
							 	+"<td>"+arr.threeb+"</td>"
							 	+"<td>"+arr.hr+"</td>"
							
							 	
							 	+"</tr>"
							 	+"</table>"
								 $('.basicyearrecord').html(str);
			 }
			});
		 
	
	}record();
	
	
	
	
});
	
	
</script>

<style>
p{
 font-size: 20px;
 font-weight: bold;
 
}
    *{padding: 0px;
        margin: 0px;
    }
    
table{
		table-layout:fixed ;
		border: 3px solid thick;	
		 border-collapse: collapse;
		}
		
th, td {
  border: 3px solid #444444;
  word-break:break-all;
  font-size: 30px;
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
    body , html {
        height: 100%;
    }

    body{
        background-image: url('/resources/img/image5.jpg');
        background-size: 100%;
    }



    .behind{
      
        margin: 10px 10px;
        background-color: rgba( 255, 255, 255, 0.5 );
    }

    .basicyearrecord{
          border: px solid pink ;
        margin: 10px 10px;
        background-color: rgba( 255, 255, 255, 0.5 );
    }

    #page {
        display: grid;
        width: 100%;
        height: 100%;

        grid-template-areas: "head  head"
        " playimg profile"
        " playrecord playrecord"
        " behind behind"
        " foot foot" ;
        grid-template-rows: 5% 15% 35% 40% 5%;
        grid-template-columns: 15% 85%;
    }

    #page>playimg{
        grid-area: playimg;
        background-color: rgba( 255, 255, 255, 0.5 );

    }
    #page> behind{
        grid-area: behind;
    
    }
    #page>playrecord{
        grid-area: playrecord;
        background-color: rgba( 255, 255, 255, 0.5 );

    }

    #page>profile{
        grid-area: profile;
        background-color: rgba( 255, 255, 255, 0.5 );

    }

    #page > header {
        grid-area: head;
        
    }





    #page > footer {
        grid-area: foot;
      
    }

</style>
</body>

</html>