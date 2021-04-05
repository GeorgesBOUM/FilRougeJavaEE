package fr.filrouge.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.filrouge.beans.Client;
import fr.filrouge.validations.ValidationClient;

/**
 * Servlet implementation class CreationClient
 */
@WebServlet("/CreationClient")
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_RESULTAT         = "/WEB-INF/vues/AffichageInfoClient.jsp";
    public static final String VUE_FORMULAIRE       = "/WEB-INF/vues/FormulaireCreationClient.jsp";
    
    public static final String ATT_CLIENT           = "client";
    public static final String ATT_VALIDATION       = "validation";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher(VUE_FORMULAIRE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ValidationClient validationClient = new ValidationClient();
		Client client = validationClient.validerNouveauClient(request);
		
		request.setAttribute(ATT_VALIDATION, validationClient);
		request.setAttribute(ATT_CLIENT, client);
		
		if (validationClient.getErreurs().isEmpty()) {
			request.getRequestDispatcher(VUE_RESULTAT).forward(request, response);
		} else {
			request.getRequestDispatcher(VUE_FORMULAIRE).forward(request, response);
		}
	}

}
