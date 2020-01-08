package Compte;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Carte.Carte;
import DataAccess.DataConnection;

public class CompteDAOIMPL implements Serializable {
	private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection conn;
    public CompteDAOIMPL(){
        conn = DataConnection.getDataConnection().getConnection();
    }
   
    public Compte find(Compte account) {
    	Compte acc = null;
        String sql = "select * from compte a, carte c where a.id_carte = c.id_carte and " +
                "c.libelle_carte = ? and c.num_carte = ? and c.mois_carte = ? and c.annee_carte = ? and c.verification_carte = ?";
        
        ResultSet rs;

        try {
        	statement=conn.prepareStatement(sql);
        	statement.setString(1, account.getCarte().getLibelle_carte());
        	statement.setInt(2, account.getCarte().getNum_carte());
        	statement.setInt(3, account.getCarte().getMois_carte());
        	statement.setInt(4, account.getCarte().getAnnee_carte());
        	statement.setInt(5, account.getCarte().getVerification_carte());
            rs = statement.executeQuery();

            while (rs.next()) {
                double amount = rs.getDouble("a.montant_compte");
                int id = rs.getInt("a.id_compte");
                String type = rs.getString("c.libelle_carte");
                int num = rs.getInt("c.num_carte");
                int expMonth = rs.getInt("c.mois_carte");
                int expYear = rs.getInt("c.annee_carte");
                int verificationCode = rs.getInt("c.verification_carte");
                Carte card = new Carte(type, num, expYear,expMonth, verificationCode);

                acc = new Compte(id, amount,null, card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acc;
    }

   
  
    
    public void update(Compte obj,double tmp) {
          String sql = "update compte set montant_compte = ? where id_compte = ?";
        try{
        	statement=conn.prepareStatement(sql);
			statement.setDouble(1,obj.getMontant_compte()-tmp);
			statement.setLong(2,obj.getId_compte());
			
			statement.executeUpdate();
			
	
		
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }



}
