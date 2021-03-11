package fr.filrouge.beans;

public class Commande {
	Client client;
	double montant;
	String modePaiement;
	String modeLivraison;
	boolean statutLivraison;
	boolean statutCommande;
	
	public Commande(Client client, double montant, String modePaiement, String modeLivraison, boolean statutLivraison,
			boolean statutCommande) {
		this.client = client;
		this.montant = montant;
		this.modePaiement = modePaiement;
		this.modeLivraison = modeLivraison;
		this.statutLivraison = statutLivraison;
		this.statutCommande = statutCommande;
	}
	
	
}
