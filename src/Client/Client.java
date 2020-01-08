package Client;

import java.io.Serializable;

public class Client implements Serializable{
    private long id_client;
    private String prenom;
    private String nom;
    private String email;
    private String adresse;
    private int tel;

    

    public Client(long id_client, String prenom,String nom , String email , String adresse ,  int tel) {
        this.id_client = id_client;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.tel = tel;
    }
    public Client(String prenom,String nom , String email , String adresse ,  int tel) {
    	 this.prenom = prenom;
         this.nom = nom;
         this.email = email;
         this.adresse = adresse;
         this.tel = tel;
    }
    
    
	public Client(long id_client, String prenom, String nom) {
		super();
		this.id_client = id_client;
		this.prenom = prenom;
		this.nom = nom;
	}
	public long getId_client() {
		return id_client;
	}
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return prenom + " " + nom ;
	}
	
	

    
}

