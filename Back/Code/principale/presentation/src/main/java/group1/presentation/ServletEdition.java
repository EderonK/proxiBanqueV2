package group1.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		
		RequestDispatcher   dispatcher = request.getRequestDispatcher("edition.jsp");
		dispatcher.forward(request, response);	
	}
		

}


