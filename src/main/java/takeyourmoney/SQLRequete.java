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
    private final String requeteSQL;

    private ResultSet res;
    //private ResultSetMetaData rsmd;
    
    //private String[] entData;
    //private Object[][] data;
        
    SQLRequete(Connection conn, String reqSQL){
        this.con = conn;
        this.requeteSQL = reqSQL;
    }

    // requete : on passe l'objet conn et un string requete SQL en argument        
    public ResultSet requeteBDD(){

        try{
            //étape 3: créer l'objet statement 
            Statement stmt = this.con.createStatement();

            System.out.println("REQUETE");      
            this.res = stmt.executeQuery(this.requeteSQL);       
        }
        catch(Exception e){ 
            System.out.println("SQLRequete requeteBDD : " + e);
        }
        return this.res;
    }
    
    // extraction des resultats
    /*public void extractResult(){
        
        this.res = requeteBDD();
        try{
                this.rsmd = this.res.getMetaData();
                int nbColonnes = this.rsmd.getColumnCount();
                System.out.println("nb colonne " + nbColonnes);
                rsmd.getColumnLabel(nbColonnes);
                this.entData = new String[nbColonnes];
                
                // on recupere les noms des colonnes dans enteteData
                for(int i = 1; i <= nbColonnes; i++){
                    this.entData[i-1] = rsmd.getColumnLabel(i);
                    //System.out.println("colonne " + i + " " + this.entData[i-1]);
                }
                
                // on compte le nombre de lignes
                int nbLignes = 0;
                while(this.res.next())
                    nbLignes ++;
                
                // allocation dynamique de data[][]
                this.data = new Object[nbLignes][nbColonnes];
                
                // insertion des donnees dans data
                for(int i = 1; i <= nbLignes; i++){
                    this.res.absolute(i);       // on se positionne aà la ligne i
                    for(int j = 1; j <= nbColonnes; j++){
                        this.data[i-1][j-1] = res.getObject(j);
                        System.out.println("value(" + i + "," + j + ") = " + this.data[i-1][j-1].toString());
                    }
                }
        }
        catch(Exception e){
            System.out.println("SQLRequete extractResult : " + e);
        }
    }*/

}
