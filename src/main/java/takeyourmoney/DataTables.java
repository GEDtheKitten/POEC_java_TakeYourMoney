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

    // structure de données récupérée
    private String[] entData;
    private Object[][] data;
    int nbLignes;
    int nbColonnes;
    
    // la table explorée    
    private final String nomTable;
    private final int sizeTable;
    
    // connecteur à la base de données
    private final Connection conTYM;
    
    // constructeur : en attendant de trouver mieux on passe nbLign en argument...
    DataTables(Connection cn, String nomTab){
        this.nomTable = nomTab;
        this.conTYM = cn;
        
        // on definit la taille de nomTable par la méthode privée
        this.sizeTable = setSizeTable();
    }
    
    public void getDataFromRequest(String reqSQL){
        
        // requete
        SQLRequete req = new SQLRequete(this.conTYM);
        ResultSet res = req.pullRequest(reqSQL);
               
        
        // extraction des resultats        
        try{
                // nombre de lignes != sizeTable selon les requetes...
                // action possible uniquement si ResultSet.SCROLL_(IN)SENTIVE
                res.last();               
                this.nbLignes = res.getRow();
                res.beforeFirst();
                
                // la structure des données (entete)
                ResultSetMetaData rsmd = res.getMetaData();
                this.nbColonnes = rsmd.getColumnCount();
                //System.out.println("nb colonne " + this.nbColonnes);
                
                rsmd.getColumnLabel(this.nbColonnes);
                this.entData = new String[this.nbColonnes];
                
                // on recupere les noms des colonnes dans enteteData
                for(int i = 1; i <= this.nbColonnes; i++){
                    this.entData[i-1] = rsmd.getColumnLabel(i);
                    //System.out.println("colonne " + i + " " + this.entData[i-1] + "\n");
                }

                // allocation dynamique de data[][]
                this.data = new Object[this.nbLignes][this.nbColonnes];
                
                // extraction / insertion des donnees dans data
                for(int i = 1; i <= this.nbLignes; i++){
                    res.absolute(i);                            // possible uniquement si ResultSet.SCROLL_(IN)SENTSIIVE
                    for(int j = 1; j <= this.nbColonnes; j++){
                        this.data[i-1][j-1] = res.getObject(j);
                        //System.out.println("value(" + i + "," + j + ") = " + this.data[i-1][j-1].toString());
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
    
    // utilisée uniquement par getDataFromRequest
    private int setSizeTable(){
        
        int size = 0;
        // requete SQL pour compter le nombre de lignes
        String reqSQL = "SELECT COUNT(*) FROM " + this.nomTable + ";";

        // requete
        SQLRequete req = new SQLRequete(this.conTYM);
        try{                        
            ResultSet res = req.pullRequest(reqSQL);
            while(res.next()){
                size = res.getInt("count(*)");
            }
        }
        catch(Exception e){
                System.out.println("ListIHM getSizeTable : " + e);
        }        
        return size;
    }
    
    public int getSizeTable(){
        return this.sizeTable;
    }    
}
