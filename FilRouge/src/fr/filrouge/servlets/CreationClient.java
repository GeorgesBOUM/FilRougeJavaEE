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
	
	public static final String CHAMP_NOM       = "nomClient";
    public static final String CHAMP_PRENOM    = "prenomClient";
    public static final String CHAMP_ADRESSE   = "adresseClient";
    public static final String CHAMP_TELEPHONE = "telephoneClient";
    public static final String CHAMP_EMAIL     = "emailClient";
    
    public static final String ATTRIBUT_NOM       = "nom";
    public static final String ATTRIBUT_PRENOM    = "prenom";
    public static final String ATTRIBUT_ADRESSE   = "adresse";
    public static final String ATTRIBUT_TELEPHONE = "telephone";
    public static final String ATTRIBUT_EMAIL     = "email";
 
    public static final String ATTRIBUT_CLIENT      = "client";
    public static final String ATTRIBUT_MESSAGE     = "message";
 
    public static final String VUE             = "/AffichageInfoClient.jsp";
       
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
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String telephone = request.getParameter(CHAMP_TELEPHONE);
		String mail = request.getParameter(CHAMP_EMAIL);
		String message = "";
		
		if (nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas rempli correctement tous les champs obligatoires. <br/>";
			request.setAttribute(ATTRIBUT_MESSAGE, message);
			request.setAttribute(ATTRIBUT_NOM, nom);
			request.setAttribute(ATTRIBUT_PRENOM, prenom);
			request.setAttribute(ATTRIBUT_ADRESSE, adresse);
			request.setAttribute(ATTRIBUT_TELEPHONE, telephone);
			request.setAttribute(ATTRIBUT_EMAIL, mail);
			request.getRequestDispatcher(VUE).forward(request, response);
		} else {
			message = "Client créé avec succès";
			Client client = new Client(nom, prenom, adresse, telephone, mail);
			request.setAttribute(ATTRIBUT_MESSAGE, message);
			request.setAttribute(ATTRIBUT_CLIENT, client);
			request.getRequestDispatcher("/AffichageInfoClient.jsp").forward(request, response);
		}
//		doGet(request, response);
	}

}
