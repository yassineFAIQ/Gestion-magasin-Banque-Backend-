package Carte;

import java.io.Serializable;

public class Carte implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int id_carte;
	    private String libelle_carte ;
	    private int num_carte;
	    private int annee_carte;
	    private int mois_carte;
	    private int verification_carte;
		public Carte(int id_carte, String libelle_carte, int num_carte, int annee_carte, int mois_carte,
				int verification_carte) {
	
			this.id_carte = id_carte;
			this.libelle_carte = libelle_carte;
			this.num_carte = num_carte;
			this.annee_carte = annee_carte;
			this.mois_carte = mois_carte;
			this.verification_carte = verification_carte;
		}
		public Carte(String libelle_carte, int num_carte, int annee_carte, int mois_carte, int verification_carte) {
			
			this.libelle_carte = libelle_carte;
			this.num_carte = num_carte;
			this.annee_carte = annee_carte;
			this.mois_carte = mois_carte;
			this.verification_carte = verification_carte;
		}
		
		
		public int getId_carte() {
			return id_carte;
		}
		public void setId_carte(int id_carte) {
			this.id_carte = id_carte;
		}
		public String getLibelle_carte() {
			return libelle_carte;
		}
		public void setLibelle_carte(String libelle_carte) {
			this.libelle_carte = libelle_carte;
		}
		public int getNum_carte() {
			return num_carte;
		}
		public void setNum_carte(int num_carte) {
			this.num_carte = num_carte;
		}
		public int getAnnee_carte() {
			return annee_carte;
		}
		public void setAnnee_carte(int annee_carte) {
			this.annee_carte = annee_carte;
		}
		public int getMois_carte() {
			return mois_carte;
		}
		public void setMois_carte(int mois_carte) {
			this.mois_carte = mois_carte;
		}
		public int getVerification_carte() {
			return verification_carte;
		}
		public void setVerification_carte(int verification_carte) {
			this.verification_carte = verification_carte;
		}

		
		
		
	    
	    
	    
	    
}
