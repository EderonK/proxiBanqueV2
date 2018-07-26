<%@ page  import= "java.util.ArrayList" %>
<%@ page  import= "domaine.main.Client" %>
<%@ page  import= "domaine.main.Compte" %>
<%@ page  import= "domaine.main.CompteCourant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proxi Banque - Accueil</title>
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
				<li class="nav-item w-75"><a class="navbar-brand"
					href="index.html"></a></li>
				<li class="nav-item w-25"><span id="dateTimeText"
					class="navbar-text"></span></li>
			</ul>
		</div>
		<!-- end navbar-collapse -->
	</div>
	<!-- end navbar -->
<%   ArrayList<Client> listeClient = (ArrayList<Client>) session.getAttribute( "listeClient" ) ;	%>
	<div class="container">
		<div class="card">
			<div class="card-header card-header-custom text-center">
				<h4>Liste des clients</h4>
			</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Prénom</th>
							<th scope="col">Nom</th>
							<th scope="col">Solde compte courant</th>
						</tr>
					</thead>
					<tbody>
						<%int i =1;%>
					<% for(Client client : listeClient){%>
						<tr>
							<th scope="row"><%=i %></th>
							<td><%= client.getPrenom()%></td>
							<td><%=client.getNom()%> </td>
							<td><%ArrayList<Compte> listComptes=client.getListComptes();%>
							<% for(Compte compte: listComptes){%>
								<%if (compte instanceof CompteCourant){%>
								 <%=compte.getSolde()%> 
							<%}}%>
							</td>
							<td><a href="Comptes?id=<%=i%>" method=get>Détail client</a></td>
						</tr>
						<%   i =i+1; }%>
						
						</tr>
					</tbody>
				</table>
			</div>
			<!-- end card-body -->
		</div>
		<!-- end card -->
	</div>
	<!-- end container -->

	<!-- Footer -->
	<footer class="footer footer-custom text-right">
		<button type="submit" class="btn btn-primary" action="index.jsp">Déconnexion</button>
	</footer>
	<!-- Footer -->

</body>
</html>