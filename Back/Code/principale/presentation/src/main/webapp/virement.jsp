<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Virement</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/app.css">
<script type="text/javascript" src="js/javascript.js"></script>
</head>
<body>
<%   String prenomDuConseiller = (String) session.getAttribute( "PrenomConseiller" ) ;	%>
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
				<li class="nav-item"><span class="navbar-text">Bonjour
						<%=prenomDuConseiller %></span></li>
			</ul>
			<ul class="navbar-nav nav-fill w-100">
				<li class="nav-item"><a class="nav-link" href="accueil.jsp">Acceuil</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="detail-client.jsp">Détail client</a></li>
				<li class="nav-item"><a class="nav-link" href="edition.jsp">Edition</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="detail-client.jsp">Virement</a></li>
				<li class="nav-item"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- end navbar -->

	<!-- form-virement card -->
	<div class="form-virement card">
		<h5 class="card-header card-header-custom text-center">VIREMENT</h5>
		<div class="card-body">
			<form class="form-virement" method="post">
				<div class="form-group">
					<label>Compte debiteur</label> <input type="text"
						class="form-control" name="compteDebiteurInput"
						placeholder="Veuillez-saisir le numero de compte a debiter"
						required />
				</div>
				<div class="form-group">
					<label>Compte crediteur</label> <input type="password"
						class="form-control" name="compteCrediteurInput"
						placeholder="Veuillez-saisir le numero de compte a crediter"
						required />
				</div>
				<div class="form-group">
					<label>Montant a virer</label> <input type="password"
						class="form-control" name="montantVirerInput"
						placeholder="Veuillez-saisir le montant a virer" required />
				</div>
				<div class="col-md-8 text-right">
					<button id="button1id" name="button1id" class="btn btn-success">Valider</button>
					<button id="button2id" name="button2id" class="btn btn-primary">Annuler</button>
				</div>
			</form>
		</div>
		<!-- end card-body -->
	</div>
	<!-- end form-virement card -->

	<!-- Footer -->
	<footer class="footer footer-custom text-right">
		<button type="submit" class="btn btn-primary" action="index.jsp">Déconnexion</button>
	</footer>
	<!-- Footer -->

</body>
</html>
