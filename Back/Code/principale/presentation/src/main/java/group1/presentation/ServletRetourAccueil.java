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

@WebServlet("/Accueil1")
public class ServletRetourAccueil extends HttpServlet {

	
	public ServletRetourAccueil() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientService clientService = new ClientService();
		IdentificationService identificationService = new IdentificationService();	
		
		HttpSession maSession = request.getSession();
		String login= (String) maSession.getAttribute( "login" ) ;
		String pwd = (String) maSession.getAttribute( "pwd" ) ;
		Conseiller conseiller = (Conseiller) identificationService.verficationMotDePasse(login, pwd);
		ArrayList<Client> listeClient = clientService.retournerListeClient(conseiller);
		
		
		RequestDispatcher   dispatcher = request.getRequestDispatcher("accueil.jsp");
		dispatcher.forward(request, response);
	}
		

}