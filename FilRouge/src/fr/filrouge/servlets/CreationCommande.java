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
	
	public static final String CHAMP_NOM       = "nomClient";
    public static final String CHAMP_PRENOM    = "prenomClient";
    public static final String CHAMP_ADRESSE   = "adresseClient";
    public static final String CHAMP_TELEPHONE = "telephoneClient";
    public static final String CHAMP_EMAIL     = "emailClient";
    
    public static final String CHAMP_MONTANT          = "montantCommande";
    public static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    public static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    public static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    public static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";
    
    public static final String ATTRIBUT_NOM       = "nom";
    public static final String ATTRIBUT_PRENOM    = "prenom";
    public static final String ATTRIBUT_ADRESSE   = "adresse";
    public static final String ATTRIBUT_TELEPHONE = "telephone";
    public static final String ATTRIBUT_EMAIL     = "mail";
    
    public static final String ATTRIBUT_MODE_PAIEMENT    = "modePaiement";
    public static final String ATTRIBUT_STATUT_PAIEMENT  = "statutPaiement";
    public static final String ATTRIBUT_STATUT_LIVRAISON = "statutLivraison";
    public static final String ATTRIBUT_COMMANDE  = "commande";
    public static final String ATTRIBUT_CLIENT    = "client";
    public static final String ATTRIBUT_MESSAGE   = "message";
 
    public static final String VUE_FORMULAIRE     = "/WEB-INF/vues/FormulaireCreationCommande.jsp";
    public static final String VUE_RESULTAT       = "/WEB-INF/vues/AffichageInfoCommande.jsp";
       
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
		request.getRequestDispatcher(VUE_FORMULAIRE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String telephone = request.getParameter(CHAMP_TELEPHONE);
		String mail = request.getParameter(CHAMP_EMAIL);
		String message = "";
		
		double montant;
		try {
			montant = Double.parseDouble(request.getParameter(CHAMP_MONTANT));
		} catch (NumberFormatException e) {
			montant = -1;
		}
		
		String modePaiement = request.getParameter(CHAMP_MODE_PAIEMENT);
		String statutPaiement = request.getParameter(CHAMP_STATUT_PAIEMENT);
		String statutLivraison = request.getParameter(CHAMP_STATUT_LIVRAISON);
		String modeLivraison = request.getParameter(CHAMP_MODE_LIVRAISON);
		
		
		if (nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty()
				|| montant == -1 || modePaiement.trim().isEmpty() || statutPaiement.trim().isEmpty()
				|| statutLivraison.trim().isBlank()) {
			message = "Erreur - Vous n'avez pas rempli correctement tous les champs obligatoires. <br/>";
			request.setAttribute(ATTRIBUT_MESSAGE , message);
			request.setAttribute(ATTRIBUT_NOM, nom);
			request.setAttribute(ATTRIBUT_PRENOM, prenom);
			request.setAttribute(ATTRIBUT_ADRESSE, adresse);
			request.setAttribute(ATTRIBUT_TELEPHONE, telephone);
			request.setAttribute(ATTRIBUT_EMAIL, mail);
			request.setAttribute(ATTRIBUT_MODE_PAIEMENT, modePaiement);
			request.setAttribute(ATTRIBUT_STATUT_PAIEMENT, statutPaiement);
			request.setAttribute(ATTRIBUT_STATUT_LIVRAISON, statutLivraison);
			request.getRequestDispatcher(VUE_FORMULAIRE).forward(request, response);
		} else {
			message = "Commande créée avec succès";
			Client client = new Client(nom, prenom, adresse, telephone, mail);
			Commande commande = new Commande(client, montant, modePaiement, modeLivraison, statutLivraison, statutPaiement);
			request.setAttribute(ATTRIBUT_MESSAGE , message);
			request.setAttribute(ATTRIBUT_CLIENT, client);
			request.setAttribute(ATTRIBUT_COMMANDE , commande);
			request.getRequestDispatcher(VUE_RESULTAT).forward(request, response);
		}
	}

}
