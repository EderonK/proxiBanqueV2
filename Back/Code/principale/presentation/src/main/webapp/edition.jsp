<%@ page  import= "java.util.ArrayList" %>
<%@ page  import= "domaine.main.Client" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Edition client</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/app.css">
<script type="text/javascript" src="js/javascript.js"></script>
</head>
<body>
<%   String prenomDuConseiller = (String) session.getAttribute( "PrenomConseiller" ) ;	%>

<%   ArrayList<Client> listeClient = (ArrayList<Client>) session.getAttribute( "listeClient" ) ;	%>
<%String numero = (String) session.getAttribute( "idClient" ) ; %>
<%int num= Integer.parseInt(numero);  %>
<%num=num-1; %>
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
				<li class="nav-item"><a class="nav-link active"
					href="detail-client.jsp">Edition</a></li>
				
				
				<li class="nav-item"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- end navbar -->

	<!-- form-virement card -->
	<div class="form-edition card">
		<h5 class="card-header card-header-custom text-center">EDITION CLIENT</h5>
		<div class="card-body">
			<form class="form-edition" method="post" action="Edition">
				<div class="form-group">
					<label>Veuillez-saisir le nouveau nom du client</label> <input type="text" class="form-control"
						name="nomInput" value=<%=listeClient.get(num).getNom()%>
						required />
				</div>
				<div class="form-group">
					<label>Veuillez-saisir le nouveau prénom du client</label> <input type="text" class="form-control"
						name="prenomInput" value=<%=listeClient.get(num).getPrenom()%>
						 required />
				</div>
				<div class="form-group">
					<label>Veuillez-saisir la nouvelle adresse du client</label> <input type="text" class="form-control"
						name="adresseInput"
						value="<%=listeClient.get(num).getAdresse()%>" required />
				</div>
				<div class="form-group">
					<label>Veuillez-saisir le nouvel email du client</label> <input type="text" class="form-control"
						name="emailInput" value="<%=listeClient.get(num).getEmail()%>"
						required />
				</div>
				<div class="col-md-8 text-right">
					<button id="button1id" name="button1id" class="btn btn-success" type="submit" >Valider</button>
					<button id="button2id" name="button2id" class="btn btn-primary" action="edition.jsp">Annuler </button>
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
