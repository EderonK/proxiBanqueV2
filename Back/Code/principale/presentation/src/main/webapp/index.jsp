<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Index</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/app.css">
<script type="text/javascript" src="js/javascript.js"></script>
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
				<li class="nav-item"><a class="navbar-brand" href="index.html">
						<img src="img/logo.png" width="30" height="30">
				</a></li>
				<li class="nav-item w-75"><a class="navbar-brand"
					href="index.html">PROXIBANQUE</a></li>
				<li class="nav-item w-25"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- end navbar -->
	<div class="form-signin card">
		<h5 class="card-header">Authentification</h5>
		<div class="card-body">
			<form class="form-signin" method="post" action="authentification">
				<div class="form-group">
					<label>Identifiant</label> <input type="text" class="form-control"
						name="usernameInput" placeholder="Entrez votre identifiant"
						required />
				</div>
				<div class="form-group">
					<label>Mot de passe</label> <input type="password"
						class="form-control" name="passwordInput"
						placeholder="Entrez votre mot de passe" required />
				</div>
				<button type="submit" class="btn btn-primary" action="accueil.jsp">Connexion</button>
			</form>
		</div>
		<!-- end card-body -->
	</div>
	<!-- end form-signin card -->
</body>
</html>