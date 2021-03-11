package fr.filrouge.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.filrouge.beans.Client;

/**
 * Servlet implementation class CreationClient
 */
@WebServlet("/CreationClient")
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/FormulaireCreationClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String mail = request.getParameter("emailClient");
		String message = "";
		
		if (nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas rempli correctement tous les champs obligatoires. <br/>";
			request.setAttribute("message", message);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("adresse", adresse);
			request.setAttribute("telephone", telephone);
			request.setAttribute("mail", mail);
			request.getRequestDispatcher("/FormulaireCreationClient.jsp").forward(request, response);
		} else {
			message = "Client créé avec succès";
			Client client = new Client(nom, prenom, adresse, telephone, mail);
			request.setAttribute("message", message);
			request.setAttribute("client", client);
			request.getRequestDispatcher("/AffichageInfoClient.jsp").forward(request, response);
		}
//		doGet(request, response);
	}

}
