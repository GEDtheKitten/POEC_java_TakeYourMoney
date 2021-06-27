/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

/**
 *
 * @author Pascal
 */

// Cette classe recense des constantes pour tout le code
public class CONSTANTS {
    
    // Connexion à la base de données
    
    //public static final String USER = "root";
    //public static final String PASS = "/#123root321#/";    
    public static final String USER = "atelierjava";
    public static final String PASS = "atelierjava";
    
    public static final String NAMEBDD = "take_your_money";

    // adresse de connexion et driver
    public static final String NAMEDRIVER = "com.mysql.cj.jdbc.Driver";   
    //public static final String NAMEDRIVER = "org.mariadb.jdbc.Driver";
    public static final String ADRESSE = "jdbc:mysql://localhost:3306/" + NAMEBDD;
         
}
