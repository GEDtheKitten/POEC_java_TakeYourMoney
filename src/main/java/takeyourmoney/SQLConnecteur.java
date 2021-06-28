/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pascal
 */
// SINGLETON
public class SQLConnecteur {
   
    /** Constructeur privé */
    private SQLConnecteur(){
        }
 
    /** Instance unique pré-initialisée */
    private static SQLConnecteur INSTANCE = new SQLConnecteur();
          
    /** Point d'accès pour l'instance unique du singleton */
    public static SQLConnecteur getInstance(String nomPilote, String adresse){
        driverName = nomPilote;
        adress = adresse;
        return INSTANCE;
    }
    
   // attribut et méthodes
    private static String driverName;
    private static String adress;
    private Connection conn;
    
    
    public Connection openDB(String nomBDD, String user, String pass){
        System.out.println("Connexion à " + nomBDD + "...");
            try{
                //étape 1: charger la classe de driver
                Class.forName(this.driverName);

                //étape 2: créer l'objet de connexion
                this.conn = DriverManager.getConnection(this.adress, user, pass);
                System.out.println("Connexion réussie");
            }
            catch(Exception e){ 
                System.out.println("SQLConnecteur connectBDD : " + e);
            }
            return this.conn;
    }
            
    public void closeDB(){
        try{
            this.conn.close();
            System.out.println("Connexion fermée");
        }
        catch(Exception e){
            System.out.println("SQLConnecteur closeBDD : " + e);
        }
    }
    
    // getter pour recuperer l'objet Conn (non utilisé actuellement)
    public Connection getConnecteur(){
        return this.conn;
    }
}
