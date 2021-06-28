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
        this.connTakeYourMoney = sqlConnecteur.openDB(CONSTANTS.NAMEBDD, CONSTANTS.USER, CONSTANTS.PASS);

        
        // LES WIDGETS
        // Fenetre principale + widgets associés
        JFrame jf = new JFrame("TakeYourMoney");        
        jf.setPreferredSize(new Dimension(800, 600));
        jf.getContentPane().setBackground(Color.white);
        jf.pack();

        // label gerer
        String gererText = "Gérer";
        JLabel gererLabel = new JLabel(gererText, JLabel.CENTER);
        
         // label lister
        String listerText = "Lister";        
        JLabel listerLabel = new JLabel(listerText, JLabel.CENTER);
        
        // boutons de gestion interface principale
        JButton gererClients = new JButton("Client");
        JButton gererProduits = new JButton("Produits");
        JButton gererCommandes = new JButton("Commandes");
        
        // boutons de gestion interface principale
        JButton listerClients = new JButton("Client");
        JButton listerProduits = new JButton("Produits");
        JButton listerCommandes = new JButton("Commandes");
        
        // boutons de statistiques et fermeture interface principale
        JButton statCA = new JButton("statistiques");
        JButton quit = new JButton("quitter");
        
        // assemblage des boutons de gestion interface principale       
        JPanel gererBoutonPan = new JPanel();
        gererBoutonPan.setBackground(Color.white);
            gererBoutonPan.add(gererLabel);
            gererBoutonPan.add(gererClients);
            gererBoutonPan.add(gererProduits);
            gererBoutonPan.add(gererCommandes);
            
        // assemblage des boutons de listage interface principale       
        JPanel listerBoutonPan = new JPanel();
        listerBoutonPan.setBackground(Color.white);
            listerBoutonPan.add(listerLabel);
            listerBoutonPan.add(listerClients);
            listerBoutonPan.add(listerProduits);
            listerBoutonPan.add(listerCommandes);
            
        // assemblage des boutons de stat et fermeture interface principale
        JPanel statBoutonPan = new JPanel();
        statBoutonPan.setBackground(Color.white);
            statBoutonPan.add(statCA);
            statBoutonPan.add(quit);            
                     
        // label presentation        
        //String banName = "C:\\Users\\Pascal\\epsi\\M5\\TakeYourMoney\\src\\main\\java\\takeyourmoney\\banniereTYM.jpg";
        String banName = "banniereTYM.jpg";
        JLabel banLabel = new JLabel("", new ImageIcon(banName), JLabel.CENTER);
        
        String bienvenueText = "<html><h2>Bienvenue sur Take Your Money!</h2></html>";
        JLabel bienvenueLabel = new JLabel(bienvenueText, JLabel.CENTER);
                                
        // assemblage JLabel et JPanel        
        JPanel globalPan = new JPanel();
        
        JPanel gererPan = new JPanel(new BorderLayout());
            gererPan.add(gererLabel, BorderLayout.NORTH);
            gererPan.add(gererBoutonPan, BorderLayout.SOUTH);
            gererPan.setBackground(Color.white);
        
        JPanel listerPan = new JPanel(new BorderLayout());
            listerPan.add(listerLabel, BorderLayout.NORTH);
            listerPan.add(listerBoutonPan, BorderLayout.SOUTH);
            
            listerPan.setBackground(Color.white);
            
        GridLayout gl = new GridLayout(5,1, 0, 20);
        globalPan.setLayout(gl);
        
            // assemblage du bloc de boutons
            globalPan.add(gererPan);
            globalPan.add(listerPan);
            globalPan.add(statBoutonPan);
      
        //jf.add(bienvenueLabel, BorderLayout.CENTER);
        jf.add(banLabel, BorderLayout.NORTH);
        jf.add(bienvenueLabel, BorderLayout.CENTER);
        jf.add(globalPan, BorderLayout.SOUTH);
        
        // reflexes pour les boutons de l'interface principale
        // "à la lambda"
        
        // gerer
        gererClients.addActionListener(e ->    { refGererClients();   });        
        gererProduits.addActionListener(e ->   { refGererProduits();  });
        gererCommandes.addActionListener(e ->  { try {
            refGererCommandes();
            } catch (IOException ex) {
                Logger.getLogger(FrameIHM.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        
        // lister
        listerClients.addActionListener(e ->   { refListerClients();   });        
        listerProduits.addActionListener(e ->  { refListerProduits();  });
        listerCommandes.addActionListener(e -> { refListerCommandes(); });
                
        // statistiques et fermeture (on ferme également la connexion à TYM)
        statCA.addActionListener(e -> { refStat();    });
        quit.addActionListener(e ->   { sqlConnecteur.closeDB(); jf.dispose(); });
        
        
        // Paramètres sur JFrame visible et fermeture
        jf.getContentPane().setBackground(Color.white);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    
    // reflexe gerer Client
    public void refGererClients() {

            JDialogGestion ecranGestion = null;
            try {
                    ecranGestion = new JDialogGestion("Clients");

            } catch (HeadlessException e) {
            } catch (IOException e) {
                    JDialogError ecranErreur = new JDialogError();
                    ecranErreur.setVisible(true);
            }
            ecranGestion.setVisible(true);
    }

    public void refGererProduits() {

            JDialogGestion ecranGestion = null;
            try {
                    ecranGestion = new JDialogGestion("Produits");

            } catch (HeadlessException e) {
            } catch (IOException e) {
                    JDialogError ecranErreur = new JDialogError();
                    ecranErreur.setVisible(true);
            }
            ecranGestion.setVisible(true);
    }

    public void refGererCommandes() throws IOException {

            JDialogGestion ecranGestion = null;
            try {
                    ecranGestion = new JDialogGestion("Commandes");

            } catch (HeadlessException e) {
            } catch (IOException e) {
                    JDialogError ecranErreur = new JDialogError();
                    ecranErreur.setVisible(true);
            }
            ecranGestion.setVisible(true);
    }
    
    public void refListerClients(){
        ListIHM listerClient = new ListIHM(this.connTakeYourMoney, "Clients");
    }
    
    public void refListerProduits(){       
        ListIHM listerClient = new ListIHM(this.connTakeYourMoney, "Produits");
    }    
    
    public void refListerCommandes(){       
        ListIHM listerClient = new ListIHM(this.connTakeYourMoney, "Commandes");
    }
      
    public void refStat(){
        StatistiquesIHM stat = new StatistiquesIHM();
    }
}
