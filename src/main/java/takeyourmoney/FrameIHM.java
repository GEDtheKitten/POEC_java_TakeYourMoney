/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal
 */
public class FrameIHM{

    // connecteur vers la base de données
    private final Connection connTakeYourMoney;
    
    // constructeur de l'interface de base
    FrameIHM(){

        // instanciation d'un connecteur SINGLETON
        SQLConnecteur sqlConnecteur = SQLConnecteur.getInstance(CONSTANTS.NAMEDRIVER, CONSTANTS.ADRESSE);
        // initialisation de la connexion        
        connTakeYourMoney = sqlConnecteur.openDB(CONSTANTS.NAMEBDD, CONSTANTS.USER, CONSTANTS.PASS);

        
        // LES WIDGETS
        // Fenetre principale + widgets associés
        JFrame jf = new JFrame("TakeYourMoney");        
        jf.setPreferredSize(new Dimension(800, 600));
        jf.getContentPane().setBackground(Color.white);
        jf.pack();

        // label gerer
        String gererText = "Gérer";
        JLabel gererLabel = new JLabel(gererText, JLabel.CENTER);
        
         // label affichage
        String listerText = "Afficher";        
        JLabel listerLabel = new JLabel(listerText, JLabel.CENTER);
        
         // label affichage particulier sur les produits
        String produitText = "Affichages particuliers sur les produits";        
        JLabel produitLabel = new JLabel(produitText, JLabel.CENTER);
        
        // boutons de gestion
        JButton gererClients = new JButton("Client");
        JButton gererProduits = new JButton("Produits");
        JButton gererCommandes = new JButton("Commandes");
        
        // boutons d'affichage
        JButton listerClients = new JButton("Client");
        JButton listerProduits = new JButton("Produits");
        JButton listerCommandes = new JButton("Commandes");
        
        // boutons d'affichage particulier sur les produits
        JButton produitsPlusVendus = new JButton("Les plus vendus");
        JButton produitsMoinsVendus = new JButton("Les moins vendus");
        JButton produitsJamaisVendus = new JButton("Ceux jamais vendus");
        
        // boutons de statistiques et fermeture
        JButton statCA = new JButton("statistiques");
        JButton quit = new JButton("quitter");
        
        // assemblage des boutons de gestion      
        JPanel gererBoutonPan = new JPanel();
        gererBoutonPan.setBackground(Color.WHITE);
            gererBoutonPan.add(gererLabel);
            gererBoutonPan.add(gererClients);
            gererBoutonPan.add(gererProduits);
            gererBoutonPan.add(gererCommandes);
            
        // assemblage des boutons d'affichage      
        JPanel listerBoutonPan = new JPanel();
        listerBoutonPan.setBackground(Color.WHITE);
            listerBoutonPan.add(listerLabel);
            listerBoutonPan.add(listerClients);
            listerBoutonPan.add(listerProduits);
            listerBoutonPan.add(listerCommandes);
            
        // assemblage des boutons d'affichage particulier sur les produits      
        JPanel produitBoutonPan = new JPanel();
        produitBoutonPan.setBackground(Color.WHITE);
            produitBoutonPan.add(produitLabel);
            produitBoutonPan.add(produitsPlusVendus);
            produitBoutonPan.add(produitsMoinsVendus);
            produitBoutonPan.add(produitsJamaisVendus);
            
        // assemblage des boutons de stat et fermeture
        JPanel statBoutonPan = new JPanel();
        statBoutonPan.setBackground(Color.WHITE);
            statBoutonPan.add(statCA);
            statBoutonPan.add(quit);            
                     
        // label presentation        
        String banName = "banniereTYM.jpg";
        JLabel banLabel = new JLabel("", new ImageIcon(banName), JLabel.CENTER);
        
        String bienvenueText = "<html><h2>Bienvenue sur Take Your Money!</h2></html>";
        JLabel bienvenueLabel = new JLabel(bienvenueText, JLabel.CENTER);
                                
        // assemblage JLabel et JPanel        
        JPanel globalPan = new JPanel();
        
        JPanel gererPan = new JPanel(new BorderLayout());
            gererPan.add(gererLabel, BorderLayout.NORTH);
            gererPan.add(gererBoutonPan, BorderLayout.SOUTH);
            gererPan.setBackground(Color.WHITE);
        
        JPanel listerPan = new JPanel(new BorderLayout());
            listerPan.add(listerLabel, BorderLayout.NORTH);
            listerPan.add(listerBoutonPan, BorderLayout.SOUTH);            
            listerPan.setBackground(Color.WHITE);
            
        JPanel produitPan = new JPanel(new BorderLayout());
            produitPan.add(produitLabel, BorderLayout.NORTH);
            produitPan.add(produitBoutonPan, BorderLayout.SOUTH);            
            produitPan.setBackground(Color.WHITE);
            
        GridLayout gl = new GridLayout(5,1, 0, 20);
        globalPan.setLayout(gl);
        
            // assemblage du bloc de boutons
            globalPan.add(gererPan);
            globalPan.add(listerPan);
            globalPan.add(produitPan);
            globalPan.add(statBoutonPan);
            globalPan.setBackground(Color.WHITE);
      
        //jf.add(bienvenueLabel, BorderLayout.CENTER);
        jf.add(banLabel, BorderLayout.NORTH);
        jf.add(bienvenueLabel, BorderLayout.CENTER);
        jf.add(globalPan, BorderLayout.SOUTH);
        
        
        // reflexes pour les boutons de l'interface principale
        // "à la lambda"
        
        // gerer
        gererClients.addActionListener(e ->    { try {
            refGerer("Clients");
            } catch (SQLException ex) {
                Logger.getLogger(FrameIHM.class.getName()).log(Level.SEVERE, null, ex);
            }
 });        
        gererProduits.addActionListener(e ->   { try {
            refGerer("Produits");
            } catch (SQLException ex) {
                Logger.getLogger(FrameIHM.class.getName()).log(Level.SEVERE, null, ex);
            }
 });
        gererCommandes.addActionListener(e ->  { try {
            refGerer("Commandes");
            } catch (SQLException ex) {
                Logger.getLogger(FrameIHM.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        
        /*gererCommandes.addActionListener(e ->  { try {
            refGererCommandes();
            } catch (IOException ex) {
                Logger.getLogger(FrameIHM.class.getName()).log(Level.SEVERE, null, ex);
            }
});*/
        
        // affichage
        listerClients.addActionListener(e ->   { refAfficher("Clients");   });        
        listerProduits.addActionListener(e ->  { refAfficher("Produits");  });
        listerCommandes.addActionListener(e -> { refAfficher("Commandes"); });
                
        // affichages particuliers sur les produits        
        produitsPlusVendus.addActionListener(e ->   { refAffParticuliersProd("V_produits_plus_vendus");   });
        produitsMoinsVendus.addActionListener(e ->  { refAffParticuliersProd("V_produits_moins_vendus");  });
        produitsJamaisVendus.addActionListener(e -> { refAffParticuliersProd("V_produits_jamais_vendus"); });
                
        // statistiques et fermeture (on ferme également la connexion à TYM)
        statCA.addActionListener(e -> { refStat();    });
        quit.addActionListener(e ->   { sqlConnecteur.closeDB(); jf.dispose(); });
        
        
        // Paramètres sur JFrame visible et fermeture
        jf.getContentPane().setBackground(Color.WHITE);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    
    // gestion
    
    public void refGerer(String nomTable) throws SQLException {

            JDialogGestion ecranGestion = null;
            try {
                    ecranGestion = new JDialogGestion(this.connTakeYourMoney, nomTable);

            } catch (HeadlessException e) {
            } catch (IOException e) {
                    JDialogError ecranErreur = new JDialogError();
                    ecranErreur.setVisible(true);
            }
            ecranGestion.setVisible(true);
    }


    /*public void refGererCommandes() throws IOException {

            JDialogGestion ecranGestion = null;
            try {
                    ecranGestion = new JDialogGestion(this.connTakeYourMoney, "Commandes");

            } catch (HeadlessException e) {
            } catch (IOException e) {
                    JDialogError ecranErreur = new JDialogError();
                    ecranErreur.setVisible(true);
            }
            ecranGestion.setVisible(true);
    }*/
    
    // affichage
    public void refAfficher(String nomTable){
        ListIHM lst = new ListIHM(this.connTakeYourMoney, nomTable);
    }   
    
    // méthodes concernant les affichages particuliers sur les produits
    public void refAffParticuliersProd(String nomTable){       
        SQLRequete rq = new SQLRequete(this.connTakeYourMoney);
        
        // actualisation des vues (à (dé)commenter selon les besoins)
        /*
        // liste des produits les moins vendus
        String reqProdPlusVendus = "CREATE OR REPLACE VIEW V_produits_plus_vendus AS" + 
                                        "SELECT p.produit_ID AS produit_ID, produit_designation, qte_produit" +
                                        "FROM Produits AS p" +
                                        "JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID" +
                                        "WHERE commande_ID IS NOT NULL" +
                                            "GROUP BY p.produit_ID ORDER BY qte_produit DESC;";
                                           
        // liste des produits les moins vendus  
        String reqProdMoinsVendus = "CREATE OR REPLACE VIEW V_produits_moins_vendus AS" +
                                        "SELECT p.produit_ID AS produit_ID, produit_designation, qte_produit" + 
                                        "FROM Produits AS p" + 
                                        "JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID" + 
                                        "WHERE commande_ID IS NOT NULL" + 
                                            "GROUP BY p.produit_ID ORDER BY qte_produit;";

        // liste des produits jamais vendus
        String reqProdJamaisVendus = "CREATE OR REPLACE VIEW V_produits_jamais_vendus AS" + 
                                        "SELECT p.produit_ID AS produit_ID, produit_designation, qte_produit" +  
                                        "FROM Produits AS p" + 
                                        "LEFT JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID" + 
                                        "WHERE commande_ID IS NULL;";
        
        
        rq.pullRequest(reqProdPlusVendus);
        rq.pullRequest(reqProdMoinsVendus);        
        rq.pullRequest(reqProdJamaisVendus); */       
        
        // à ce stade, les vues sont actualisées
        ListIHM lst = new ListIHM(this.connTakeYourMoney, nomTable);
    }
    
    // statistiques
    public void refStat(){
        StatistiquesIHM stat = new StatistiquesIHM();
    }
}
