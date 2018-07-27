package group1.presentation;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Comptes")
public class MaServlet2 extends HttpServlet{

	public MaServlet2() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String id=request.getParameter("id");
		
		HttpSession maSession = request.getSession();	
		maSession.setAttribute("idClient", id);
		
		
		
		RequestDispatcher   dispatcher = request.getRequestDispatcher("detail-client.jsp");
		dispatcher.forward(request, response);	
	}
		

}
