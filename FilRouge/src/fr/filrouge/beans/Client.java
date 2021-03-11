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

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
