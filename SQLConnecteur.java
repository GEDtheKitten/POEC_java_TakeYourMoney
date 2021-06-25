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
    private SQLConnecteur(){}
 
    /** Instance unique pré-initialisée */
    private static SQLConnecteur INSTANCE = new SQLConnecteur();
     
    /** Point d'accès pour l'instance unique du singleton */
    public static SQLConnecteur getInstance(){
        return INSTANCE;
    }
    
    private Connection conn;
    
    public void connectBDD(String driverName, String nomBDD){
        System.out.println("ESSAI DE JAVA BDD");
            try{
                //étape 1: charger la classe de driver
                System.out.println("Charger la classe driver...");
                Class.forName(driverName);
                System.out.println("Charger la classe driver : OK");

                //étape 2: créer l'objet de connexion
                this.conn = DriverManager.getConnection(
                //"jdbc:mysql://localhost:3306/" + nomBDD, "root", "");
                CONSTANTS.ADRESSE, CONSTANTS.USER, CONSTANTS.PASS);
                System.out.println("Connexion OK");
            }
            catch(Exception e){ 
                System.out.println("SQLConnecteur connectBDD : " + e);
            }
    }
            
    public void closeBDD(){
        try{
            this.conn.close();
        }
        catch(Exception e){
            System.out.println("SQLConnecteur closeBDD : " + e);
        }
    }
    
    // getter pour recuperer l'objet Conn
    public Connection getConnecteur(){
        return this.conn;
    }
}
