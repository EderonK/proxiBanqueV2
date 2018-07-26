<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Detail client</title>
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
				<li class="nav-item"><a class="navbar-brand" href="index.jsp">
						<img src="img/logo.png" width="120" height="60">
				</a></li>
				<li class="nav-item w-75"><a class="navbar-brand"
					href="index.jsp">PROXIBANQUE</a></li>
				<li class="nav-item"><span class="navbar-text">Bonjour
						Douglas</span></li>
			</ul>
			<ul class="navbar-nav nav-fill w-100">
				<li class="nav-item"><a class="nav-link" href="accueil.jsp">Acceuil</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="detail-client.jsp">D�tail client</a></li>
				<li class="nav-item"><a class="nav-link" href="edition.jsp">Edition</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="virement.jsp">Virement</a>
				</li>
				<li class="nav-item"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- end navbar -->

	<div class="container">
		<div class="card mb-3">
			<div class="card-header card-header-custom text-center">
				<h4>D�tail du client</h4>
			</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Pr�nom</th>
							<th scope="col">Nom</th>
							<th scope="col">Adresse</th>
							<th scope="col">Courriel</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Xuxu 1</td>
							<td>XAXA 1</td>
							<td>75000</td>
							<td>abc@gmail.com</td>
						</tr>

					</tbody>
				</table>

				<div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
								<h5>Compte courant</h5>
								<p>Num�ro compte : 1234567890</p>

								<table class="table">
									<thead>
										<tr>
											<th scope="col">Date</th>
											<th scope="col">Op�ration</th>
											<th scope="col">D�bit</th>
											<th scope="col">Cr�dit</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td scope="row">10/10/2010</td>
											<td>ABC</td>
											<td></td>
											<td>100</td>
										</tr>
										<tr>
											<td scope="row">10/10/2010</td>
											<td>DEF</td>
											<td>200</td>
											<td></td>
										</tr>
										<tr>
											<td scope="row">10/10/2010</td>
											<td>GHI</td>
											<td>300</td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- end card-body -->
						</div>
						<!-- end card -->
					</div>
					<!-- end col-md-6 -->

					<div class="col-md-6">
						<div class="card">
							<div class="card-body ">
								<h5>Compte epargne</h5>
								<p>Num�ro compte : 1234567890</p>

								<table class="table">
									<thead>
										<tr>
											<th scope="col">Date</th>
											<th scope="col">Op�ration</th>
											<th scope="col">D�bit</th>
											<th scope="col">Cr�dit</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td scope="row">10/10/2010</td>
											<td>ABC</td>
											<td></td>
											<td>100</td>
										</tr>
										<tr>
											<td scope="row">10/10/2010</td>
											<td>DEF</td>
											<td>200</td>
											<td></td>
										</tr>
										<tr>
											<td scope="row">10/10/2010</td>
											<td>GHI</td>
											<td>300</td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- end card-body -->
						</div>
						<!-- end card -->
					</div>
					<!-- end col-md-6 -->
				</div>
				<!-- end row -->
			</div>
			<!-- end card-body -->
		</div>
		<!-- end card -->
	</div>
	<!-- end container -->
	<!-- Footer -->
	<footer class="footer footer-custom text-right">
		<button type="submit" class="btn btn-primary" action="index.jsp">D�connexion</button>
	</footer>
	<!-- Footer -->
</body>
</html>