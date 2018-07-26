<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Tableau de bord des virements</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/app.css">
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="js/pie.js">
	
</script>
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
						<img src="img/logo.png" width="120" height="60">
				</a></li>
				<li class="nav-item w-75"><a class="navbar-brand"
					href="index.html">PROXIBANQUE</a></li>
				<li class="nav-item w-25"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- form-tableauBord card -->
	<div class="form-tableauBord card">
		<h5 class="card-header card-header-custom text-center">TABLEAU DE
			BORD DES VIREMENTS</h5>
		<div class="card-body">
			<legend>Il y a eu X virements pour ce mois-ci pour un total
				de Y euros</legend>
			<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
		</div>
		<!-- end card-body -->
	</div>
	<!-- end form-tableauBord card -->

	<!-- Footer -->
	<footer class="footer footer-custom text-right">
		<button type="submit" class="btn btn-primary" action="index.jsp">Déconnexion</button>
	</footer>
	<!-- Footer -->
</body>

</html>
