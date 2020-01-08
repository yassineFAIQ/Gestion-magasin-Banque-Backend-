package Compte;

import java.io.Serializable;

import Carte.Carte;
import Client.Client;

public class Compte implements Serializable {

		private int id_compte;
   	    private double montant_compte;
   	    private Client client;
	    private Carte carte;
		public Compte(int id_compte, double montant_compte, Client client, Carte carte) {
		
			this.id_compte = id_compte;
			this.montant_compte = montant_compte;
			this.client = client;
			this.carte = carte;
		}
		public Compte(double montant_compte, Client client, Carte carte) {
			
			this.montant_compte = montant_compte;
			this.client = client;
			this.carte = carte;
		}
		public int getId_compte() {
			return id_compte;
		}
		public void setId_compte(int id_compte) {
			this.id_compte = id_compte;
		}
		public double getMontant_compte() {
			return montant_compte;
		}
		public void setMontant_compte(double montant_compte) {
			this.montant_compte = montant_compte;
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		public Carte getCarte() {
			return carte;
		}
		public void setCarte(Carte carte) {
			this.carte = carte;
		}
		
	   
		
	    
	    
	   
}
