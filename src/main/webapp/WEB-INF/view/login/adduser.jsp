<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Freshshop-Register</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="../../../css/stylelog.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form:form action="/login/adduserprocess" method="post" modelAttribute="user" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
                                    <form:input
								    path="name"	type="text" name="name" id="name" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label>
                                <form:input
								path="mobileNo" name="mobileNo" id="mobileNo" placeholder="Your Mobile no" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                 <form:input
                                 path="address.address"	type="text" name="address" id="address" placeholder="Address Line" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<form:input path="address.city" type="text" name="city" id="city"
									placeholder="City" />
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<form:input path="address.pinCode" type="text" name="pin" id="pin"
									placeholder="Zip code" />
							</div>
                            <div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<form:input path="address.State" type="text" name="state" id="state"
									placeholder="State" />
							</div>
                            <div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<form:input path="userName" type="text" name="userName" id="userName"
									placeholder="Create User Name" />
							</div>
                            <div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<form:input path="password" type="password" name="password" id="password"
									placeholder="Create your password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form:form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="../../../images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="/login" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<!-- <script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script> -->



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>