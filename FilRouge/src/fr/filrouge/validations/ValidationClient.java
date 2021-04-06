package fr.filrouge.validations;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.filrouge.beans.Client;

public class ValidationClient {
	
	public static final String CHAMP_NOM       = "nomClient";
    public static final String CHAMP_PRENOM    = "prenomClient";
    public static final String CHAMP_ADRESSE   = "adresseClient";
    public static final String CHAMP_TELEPHONE = "telephoneClient";
    public static final String CHAMP_EMAIL     = "emailClient";
    
//    public static final String ATTRIBUT_NOM       = "nom";
//    public static final String ATTRIBUT_PRENOM    = "prenom";
//    public static final String ATTRIBUT_ADRESSE   = "adresse";
//    public static final String ATTRIBUT_TELEPHONE = "telephone";
//    public static final String ATTRIBUT_EMAIL     = "email";
// 
//    public static final String ATTRIBUT_CLIENT      = "client";
//    public static final String ATTRIBUT_MESSAGE     = "message";
 
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public String getResultat() {
		return resultat;
	}
    
    public Map<String, String> getErreurs() {
		return erreurs;
	}
    
    public Client validerNouveauClient (HttpServletRequest request) {
    	
    	String nom 		 = getValeurChamp(request, CHAMP_NOM);
    	String prenom 	 = getValeurChamp(request, CHAMP_PRENOM);
    	String adresse 	 = getValeurChamp(request, CHAMP_ADRESSE);
    	String telephone = getValeurChamp(request, CHAMP_TELEPHONE);
    	String mail 	 = getValeurChamp(request, CHAMP_EMAIL);
    	
    	Client client = new Client();
    	
    	try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
    	client.setNom(nom);
    	
    	try {
			validationPrenom(prenom);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
    	client.setPrenom(prenom);
    	
    	try {
			validationAdresse(adresse);
		} catch (Exception e) {
			setErreur(CHAMP_ADRESSE, e.getMessage());
		}
    	client.setAdresseLivraison(adresse);
    	
    	try {
			validationTelephone(telephone);
		} catch (Exception e) {
			setErreur(CHAMP_TELEPHONE, e.getMessage());
		}
    	client.setTelephone(telephone);
    	
    	try {
			validationMail(mail);
		} catch (Exception e) {
			setErreur(mail, e.getMessage());
		}
    	client.setMail(mail);
    	
    	if (erreurs.isEmpty()) {
			resultat = "Succès de la création du client";
		} else {
			resultat = "Echec de la création du client";
		}
    	
    	return client;
    }
    
    private String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    private void validationNom(String nom) throws Exception {
    	if ( nom != null && nom.length() < 2 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
        } else {
        	throw new Exception( "Merci de saisir votre Nom" );
        }
	}
    
	private void validationPrenom(String prenom) throws Exception {
		if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "Le prenom doit contenir au moins 2 caractères." );
        }
	}
	
	private void validationAdresse(String adresse) throws Exception{
		if ( adresse != null && adresse.length() < 2 ) {
            throw new Exception( "L'adresse doit contenir au moins 10 caractères." );
        } else {
        	throw new Exception( "Merci de saisir votre Adresse" );
        }
	}
	
	private void validationTelephone(String telephone) throws Exception {
		if (telephone != null) {
			if (!telephone.matches("[0-9]{4,}")) {
				throw new Exception("Le numéro de téléphone doit contenir au moins 4 chiffres");
			}
		} else {
			throw new Exception("Merci de saisir votre numéro de téléphone");
		}
	}
	
	private void validationMail(String mail) throws Exception {
		if (mail != null && !!mail.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide");
		}
	}
}
