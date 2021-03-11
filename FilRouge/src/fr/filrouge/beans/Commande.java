package fr.filrouge.beans;

public class Commande {
	Client client;
	double montant;
	String modePaiement;
	String modeLivraison;
	String statutLivraison;
	String statutCommande;
	
	public Commande(Client client, double montant, String modePaiement, String modeLivraison, String statutLivraison,
			String statutCommande) {
		this.client = client;
		this.montant = montant;
		this.modePaiement = modePaiement;
		this.modeLivraison = modeLivraison;
		this.statutLivraison = statutLivraison;
		this.statutCommande = statutCommande;
	}

	public Client getClient() {
		return client;
	}

	public double getMontant() {
		return montant;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public String getModeLivraison() {
		return modeLivraison;
	}

	public String getStatutLivraison() {
		return statutLivraison;
	}

	public String getStatutCommande() {
		return statutCommande;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}

	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}
	
}
