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
    <header>
    	
    </header>

    <main1>
      <div class="menu1"><h1>btn</h1></div>
   <div class="div">  
   	<span> 
     	
   	</span>
   	
   	
		<form action="/login" method="post" class= "aa">
		<h1>login</h1>
			<div class="form-group has-feedback">
			<input type="text" name="uid" class="form-control" placeholder ="USER ID"/>
			<span class="glyphon glyphon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" name="upw" class="form-control" placeholder="Password"/>
				<span class="glyphon glyphon-envelope form-control-feedback"></span>
			</div>
			
			<div class="row">
				<div class ="col-xs-8">
					<div class="checkbox icheck">
						<label>
							<input type ="checkbox" name="useCookie"> Remmember Me
						</label>
					</div>
				</div>	
				<button type = "submit" class= "btn btn-primary btn-block btn-flat">sign in</button>
			</div>
			
		</form>
   </div>
   
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

<style>

.aa{
	margin: 20% 30% ; 
	
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

    .div {

        width:90%;
        height: 90%;
        margin: 5%;
        border: 2px solid red;
         background-color: rgba( 255, 255, 255, 0.5 );
     

    }


    #page > footer {
        grid-area: foot;
        

    }



</style>
</body>

</html>