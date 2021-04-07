package fr.filrouge.validations;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.filrouge.beans.Commande;

public class ValidationCommande {
	
	private static final String CHAMP_DATE             = "dateCommande";
    private static final String CHAMP_MONTANT          = "montantCommande";
    private static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    private static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    private static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    private static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";
    
    private static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";
	
	private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public String getResultat() {
		return resultat;
	}
    
    public Map<String, String> getErreurs() {
		return erreurs;
	}
    
    public Commande validerNouvelleCommande (HttpServletRequest request) {
		
//    	DateTime dt = new DateTime();
//        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
//        String date = dt.toString( formatter );

        String montant = getValeurChamp( request, CHAMP_MONTANT );
        String modePaiement = getValeurChamp( request, CHAMP_MODE_PAIEMENT );
        String statutPaiement = getValeurChamp( request, CHAMP_STATUT_PAIEMENT );
        String modeLivraison = getValeurChamp( request, CHAMP_MODE_LIVRAISON );
        String statutLivraison = getValeurChamp( request, CHAMP_STATUT_LIVRAISON );
        
    	Commande commande = new Commande();
    	
    	
    	
    	return commande;
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
}
