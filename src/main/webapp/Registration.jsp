
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
h3 {
	color: #FFA500;
}

footer {
	background-color: #555;
	color: white;
	padding: 1px;
	position: relative;
	bottom: 0px;
	left: 0px;
	right: 0px;
	margin-bottom: 0px;
}

span {
	text-align: right;
}
</style>
<body style="background-color: #F5F5F5">
	<div>
		<nav class="navbar navbar-inverse"
			style="background-color: #696969; border-color: #696969">
			<div class="container-fluid">


				<div class="navbar-header">

					<h3
						style="font-style: oblique; font-family: fantasy; font-size: xx-large; font-weight: bold;">
						<img src="images/xworkz.jpg" style="height: 70px; width: 70px" />
						X-Workz CM
					</h3>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp"><span
							style="color: #FFA500; font-family: monospace;">Home</span></a></li>
					<li><a href="Login.jsp"><span
							style="color: #FFA500; font-family: monospace;">Login</span></a></li>


				</ul>
			</div>
		</nav>
	</div>


	${save }
	<div class="row">
		<div class="col-sm-6">
			<form action="registerUser.do" method="post">
				<div class="form-group">
					<label>User Id</label> <input type="text" name="usrId"
						class="form-control" placeholder="Enter User id">${uid_err} ${uid_exist}

				</div>
				<div class="form-group">
					<label>Email</label> <input type="email" class="form-control"
						name="email" placeholder="Enter email">${email_err} ${email_exist }

				</div>
				<div class="form-group">
					<label>Phone</label> <input type="number" name="phone"
						class="form-control" placeholder="Enter phone no">

				</div>
				<div class="form-group">
					<label>Course Intrested</label> <select class="form-control"
						name="course">
						<option value="Dev">Dev</option>
						<option value="Qa">Qa</option>
					</select>
				</div>

				<div class="form-group">
					<label>Agree</label> <input type="radio" name="agree" value="yes"
						checked="checked"> agree<input type="radio"
						name="agree" value="no">dis-agree<br>
						${agree}
				</div>



				<button class="btn btn-success" type="submit">Register</button>

			</form>
		</div>
	</div>




	<footer class="container-fluid ">
		<div>
			<h4>
				<span>@CopyRightsReserved </span> <a href=""><span>facebook</span></a>
				<a href=""><span>instagram</span></a>
			</h4>
		</div>

	</footer>

</body>
</html>