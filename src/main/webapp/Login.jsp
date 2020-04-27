
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
h3 {
	color: #FFA500;
}

footer {
	background-color: #555;
	color: white;
	padding: 1px;
	position: fixed;
	bottom: 0px;
	left: 0px;
	right: 0px;
	margin-bottom: 0px;
}

span {
	text-align: right;
}
</style>
<body>

	<nav class="navbar navbar-inverse"
		style="background-color: #696969; border-color: #696969">
		<div class="container-fluid">


			<div class="navbar-header">

				<h3
					style="font-style: oblique; font-family: fantasy; font-size: xx-large; font-weight: bold;">
					<img src="images/xworkz.jpg" style="height: 70px; width: 70px" />
					Xworkz-CM
				</h3>


			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="Registration.jsp"><span
						style="color: #FFA500; font-family: monospace;">Registration</span></a></li>


			</ul>
		</div>
	</nav>
	${invalid} ${fail} ${block}
	<div class="row" style="align-self: center;">
		<div class="col-sm-4">
			<form action="login.do" method="post">

				<div class="form-group">
					<label>Email</label> <input type="email" class="form-control"
						name="email" placeholder="Enter registered email"><br>${email_err}


				</div>
				<div class="form-group">
					<label>Password</label> <input type="text" name="password"
						class="form-control" placeholder="Enter valid password"><br>${pwd_err}


				</div>

				<button class="btn btn-primary" type="submit">Login</button>

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