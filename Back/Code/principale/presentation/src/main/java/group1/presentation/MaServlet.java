package group1.presentation;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.main.Client;
import domaine.main.Conseiller;
import group1.service.ClientService;

import group1.service.IdentificationService;
import domaine.main.Utilisateur;


	
	@WebServlet("/authentification")
	public class MaServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public MaServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			traitement(request,response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			traitement(request,response);
		}
		
		protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Etape 1 : Récupération des paramètres de la requête
		
		String login = request.getParameter("usernameInput");
		String pwd = request.getParameter("passwordInput");
		
		// Etape 2 : Soumettre les paramètres de la requête à la couche service et récupérer résultat
		
			

		
		IdentificationService identificationService = new IdentificationService();
		

		
		Conseiller conseiller = (Conseiller) identificationService.verficationMotDePasse(login, pwd);

		ClientService clientService = new ClientService();
	
		
		
		HttpSession maSession = request.getSession();	
		maSession.setAttribute("login", login);
		maSession.setAttribute("pwd", pwd);

		
	
		// Etape 3 : Réponse à l'utilisateur
		
		RequestDispatcher dispatcher;

		
		
		if (conseiller!= null) {
			ArrayList<Client> listeClient = clientService.retournerListeClient(conseiller);
			String prenomConseiller= conseiller.getPrenom();
			
			maSession.setAttribute("listeClient", listeClient);
			maSession.setAttribute("PrenomConseiller", prenomConseiller);
			 dispatcher = request.getRequestDispatcher("accueil.jsp");
			
			
			
		} else {
			 dispatcher = request.getRequestDispatcher("authentification-invalide.jsp");
		}
		dispatcher.forward(request, response);
		}

	}




