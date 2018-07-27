package group1.presentation;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
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
import group1.service.ClientService;

@WebServlet("/Edition")
public class ServletEdition extends HttpServlet {

	
	public ServletEdition() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClientService clientService =new ClientService();
		
		String prenom = request.getParameter("prenomInput");
		String nom = request.getParameter("nomInput");
		String adresse = request.getParameter("adresseInput");
		String email = request.getParameter("emailInput");
		
		
		HttpSession maSession = request.getSession();
		
		ArrayList<Client> listeClient = (ArrayList<Client>) maSession.getAttribute( "listeClient" ) ;	
		String numero = (String) maSession.getAttribute( "idClient" ) ; 
		int num= Integer.parseInt(numero); 
		num=num-1;
		int id = listeClient.get(num).getIdClient();
		Client client= new Client(id,prenom,nom,adresse,email,listeClient.get(num).getListComptes());
		
		clientService.modifierClientById(id,client);
		
		RequestDispatcher   dispatcher = request.getRequestDispatcher("accueil.jsp");
		
		dispatcher.forward(request, response);	
	}
		

}


