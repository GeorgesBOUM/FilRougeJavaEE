package fr.filrouge.beans;

public class Client {
	private String nom;
	private String prenom;
	private String adresseLivraison;
	private String telephone;
	private String mail;
	
	public Client(String nom, String prenom, String adresseLivraison, String telephone, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresseLivraison = adresseLivraison;
		this.telephone = telephone;
		this.mail = mail;
	}

}
