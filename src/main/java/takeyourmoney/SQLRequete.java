/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.sql.*;

/**
 *
 * @author Pascal
 */
public class SQLRequete {
    
    private final Connection con;
    private ResultSet res;
        
    SQLRequete(Connection conn){
        this.con = conn;
    }

    // pullRequest : requete de type SELECT        
    public ResultSet pullRequest(String reqSQL){

        System.out.println("SQLRequete pullRequest : " + reqSQL);        
        try{
            // l'optionSCROLL_INSENTIVIE permet de déplacer le curseur 
            //comme on veut, et donc d'en deduire le nombre de lignes
            Statement stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);      
            this.res = stmt.executeQuery(reqSQL);       
        }
        catch(Exception e){ 
            System.out.println("SQLRequete pullrequest : " + e);
        }
        return this.res;
    }
    
    // pushRequest : requete de type INSERT, UPDATE, DELETE     
    public ResultSet pushRequest(String reqSQL){

        System.out.println("SQLRequete pushRequest : " + reqSQL);        
        try{ 
            Statement stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);      
            int ligne = stmt.executeUpdate(reqSQL);
        }
        catch(Exception e){ 
            System.out.println("SQLRequete pushRequest : " + e);
        }
        return this.res;
    }
}
