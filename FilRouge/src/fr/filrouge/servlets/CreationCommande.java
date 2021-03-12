package fr.filrouge.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.filrouge.beans.Client;
import fr.filrouge.beans.Commande;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet("/CreationCommande")
public class CreationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/FormulaireCreationCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String mail = request.getParameter("emailClient");
		
		double montant;
		try {
			montant = Double.parseDouble(request.getParameter("montantCommande"));
		} catch (NumberFormatException e) {
			montant = -1;
		}
		
		String modePaiement = request.getParameter("modePaiementCommande");
		String statutPaiement = request.getParameter("statutPaiementCommande");
		String statutLivraison = request.getParameter("statutLivraisonCommande");
		String modeLivraison = request.getParameter("modeLivraisonCommande");
		
		String message = "";
		
		if (nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty()
				|| montant == -1 || modePaiement.trim().isEmpty() || statutPaiement.trim().isEmpty()
				|| statutLivraison.trim().isBlank()) {
			message = "Erreur - Vous n'avez pas rempli correctement tous les champs obligatoires. <br/>";
			request.setAttribute("message", message);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("adresse", adresse);
			request.setAttribute("telephone", telephone);
			request.setAttribute("mail", mail);
			request.setAttribute("modePaiement", modePaiement);
			request.setAttribute("statutPaiement", statutPaiement);
			request.setAttribute("statutLivraison", statutLivraison);
			request.getRequestDispatcher("/FormulaireCreationCommande.jsp").forward(request, response);
		} else {
			message = "Commande créée avec succès";
			Client client = new Client(nom, prenom, adresse, telephone, mail);
			Commande commande = new Commande(client, montant, modePaiement, modeLivraison, statutLivraison, statutPaiement);
			request.setAttribute("message", message);
			request.setAttribute("client", client);
			request.setAttribute("commande", commande);
			request.getRequestDispatcher("/AffichageInfoCommande.jsp").forward(request, response);
		}
	}

}
