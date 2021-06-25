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
public class DataTables {

    private ResultSet res;
    private ResultSetMetaData rsmd;
    
    private String[] entData;
    private Object[][] data;
    
    DataTables(){}
    
    public void getDataFromBDD(String nameDriver, String nameBDD, String reqSQL){

    // connexion
    SQLConnecteur con = SQLConnecteur.getInstance();
        //con.connectBDD(CONSTANTS.NAMEDRIVER, CONSTANTS.NAMEBDD);
        con.connectBDD(nameDriver, nameBDD);
    
    // requete
    SQLRequete req = new SQLRequete(con.getConnecteur(), reqSQL);
        this.res = req.requeteBDD();

    // fermeture
    con.closeBDD();        
    }
    
    // extraction des resultats
    public void extractResult(){
        
        try{
                this.rsmd = this.res.getMetaData();
                int nbColonnes = this.rsmd.getColumnCount();
                System.out.println("nb colonne " + nbColonnes);
                rsmd.getColumnLabel(nbColonnes);
                this.entData = new String[nbColonnes];
                
                // on recupere les noms des colonnes dans enteteData
                for(int i = 1; i <= nbColonnes; i++){
                    this.entData[i-1] = rsmd.getColumnLabel(i);
                    System.out.println("colonne " + i + " " + this.entData[i-1] + "\n");
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
    }
    
    public String[] getEntete(){
        return this.entData;
    }
    
    public Object[][] getData(){
        return this.data;
    }
}
