<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<section id="page">
    <header>Header</header>
    <main1><h3>월별 경기 일정</h3><div class="div"></div>
    
    </main1>

    <footer>Footer</footer>
</section>

<style>

	*{
		margin: 0px ; 
		padding: 0px; 
	}	
    body{
    	
         background-image: url("/resources/img/background.jpg"); 
        background-size: 100% 330%;
    }
    #page {
        display: grid;
        width: 100%;
        height: 30em;
        grid-template-areas: "head "
        "main1"
        "foot";
        grid-template-rows: 15% 300% 15%;
        grid-template-columns: 100%;
    }

    #page > header {
        grid-area: head;
       background-color: lime;

    }

  

    #page > main1 {
        grid-area: main1;

    }

    .div {

        width:90%;
        height: 90%;
        margin:40px;
        border: 3px solid blue;
        background-color: blue;
       

    }


    #page > footer {
        grid-area: foot;
       background-color: lime;

    }



</style>
</body>


</html>