<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    
    <title>Title</title>
</head>
<body>
<section id="page">
    <header>
      
    </header>

  <main1>
        <div class="menu1"><h1>btn</h1></div>
        <h1>팀 순위</h1>>
        
         <table class="wantPoint" >
			
		</table>
</main1> 
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
    $("main1").on("click", function () {
        $(".menu1").hide();
    })
 </script>

<script>

$(document).ready(function(){
	
	function shownews() {
		
		 var str = "";
		 var main = ""; 
		 var url = "/baseball/teaminforank"; 
		
			
		 $.getJSON(url,function(arr){
				 	  	
		 	 
		 	 str +="<tr>" 
		 		 		+"<th><h3>순위</h3></th>"
			     		+"<th><h3>팀이름</h3></th>"
			    		+"<th><h3>게임</h3></th>"
			    		+"<th><h3>승리</h3></th>"
			    		+"<th><h3>패</h3></th>"
			    		+"<th><h3>무승부</h3></th>"
			    		+"<th><h3>승률</h3></th>"
			    		+"<th><h3>게임차</h3></th>"
			    		+"<th><h3>최근 10경기</h3></th>"
			    		+"<th><h3>연속</h3></th>"
			    		+"<th><h3>홈</h3></th>"
			    		+"<th><h3>방문</h3></th>"
			    		+"</tr>"
        	
			 for (var i = 0; i < arr.length; i++) {
					str +="<tr>" 
					+"<td>"+arr[i].rank +"</td>"
					+"<td><a href=/baseball/teamdetail?teamname="+ arr[i].teamName +">"+arr[i].teamName +"</a></td>"
							
							
							
					+"<td>"+arr[i].game+"</td>"
					+"<td>"+arr[i].victory+"</td>"
					+"<td>"+ arr[i].lose+"</td>"
					+"<td>"+arr[i].draw+"</td>"
					+"<td>"+arr[i].gameOdds+"</td>"
					+"<td>"+arr[i].gameCar+"</td>"
					+"<td>"+arr[i].recentGames+"</td>"
					+"<td>"+arr[i].continuity+"</td>"
					+"<td>"+arr[i].home+"</td>"
					+"<td>"+arr[i].visiting+"</td>"
					+"</tr>" 
				
			 }
			 $('.wantPoint').html(str);
			
		});
	} 
	shownews();
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
        

    }


    #page > main1 {
        grid-area: main1;
     
    }

    .wantPoint {

        width:100%;
        height: 90%;
        margin: 1%;
        border: 2px solid red;
        background-color: rgba( 255, 255, 255, 0.5 );
        

		}


    #page > footer {
        grid-area: foot;
       

    }



</style>
</body>

</html>

</html>