<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Authentification invalide</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/app.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div
		class="navbar navbar-expand-md navbar-dark bg-dark mb-3 navbar-custom">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="flex-column collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav nav-fill w-100">
				<li class="nav-item"><a class="navbar-brand" href="index.jsp">
						<img src="img/logo.png" width="120" height="60">
				</a></li>
				<li class="nav-item w-75"><a class="navbar-brand"
					href="index.jsp">PROXIBANQUE</a></li>
				<li class="nav-item w-25"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- end navbar -->

	<div class="container">
		<div class="jumbotron">
			<h1>Oups! Echec de l'authentification!</h1>
			<p class="lead">Identifiant ou mot de passe invalide. Veuillez
				reessayer.</p>
			<a class="btn btn-lg btn-primary" href="index.jsp">S'identifier</a>
		</div>
	</div>
</body>
</html>