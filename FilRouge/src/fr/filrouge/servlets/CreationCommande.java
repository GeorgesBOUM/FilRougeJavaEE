package fr.filrouge.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.filrouge.beans.Client;
import fr.filrouge.beans.Commande;
import fr.filrouge.validations.ValidationCommande;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet("/CreationCommande")
public class CreationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
    public static final String VUE_FORMULAIRE     = "/WEB-INF/vues/FormulaireCreationCommande.jsp";
    public static final String VUE_RESULTAT       = "/WEB-INF/vues/AffichageInfoCommande.jsp";
    
    public static final String ATT_COMMANDE       = "commande";
    public static final String ATT_VALIDATION     = "validation";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCommande() {
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
		
		ValidationCommande validationCommande = new ValidationCommande();
		Commande commande = validationCommande.validerNouvelleCommande(request);
		
		request.setAttribute(ATT_COMMANDE, commande);
		request.setAttribute(ATT_VALIDATION, validationCommande);
		
		if (validationCommande.getErreurs().isEmpty()) {
			request.getRequestDispatcher(VUE_RESULTAT).forward(request, response);
		} else {
			request.getRequestDispatcher(VUE_FORMULAIRE).forward(request, response);
		}
	}

}
