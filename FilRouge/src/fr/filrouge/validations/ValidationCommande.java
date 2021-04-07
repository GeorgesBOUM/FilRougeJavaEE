package fr.filrouge.validations;

import java.util.HashMap;
import java.util.Map;

public class ValidationCommande {
	
	private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public String getResultat() {
		return resultat;
	}
    
    public Map<String, String> getErreurs() {
		return erreurs;
	}
}
