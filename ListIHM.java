/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Pascal
 */
public class ListIHM {
    
    // compteur pour la pagination
    // voir methodes privées à la fin du fichier
    int k = 1;
    
    // taille de la table initialisée par requete SQL
    int sizeData;
    
    // constructeur de la JDIALOG Liste    
    ListIHM(String type){
        
        // definition de la requete SQL
        String reqSQL = "SELECT * FROM " + type + ";";
        
        // insertion des resultats dans DataTables;
        DataTables dat = new DataTables();
        dat.getDataFromBDD(CONSTANTS.NAMEDRIVER, CONSTANTS.NAMEBDD, reqSQL);
        dat.extractResult();

        // appel de JTable
        createJTable(type, dat.getData(), dat.getEntete());
    }
    
    // creation d'une JTable
    private void createJTable(String type, Object[][] data, String[] ent){
        
        // fenetre principale
        JDialog listerDialog = new JDialog();
            listerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            listerDialog.setModal(true);
            listerDialog.setSize(800, 400);
            listerDialog.setTitle("Affichage des " + type);
        
        // la table
        JTable tab = new JTable(data, ent);
        JScrollPane scroll = new JScrollPane(tab);
                
        // parametrage de la largeur des colonnes
        tab.getColumnModel().getColumn(0).setPreferredWidth(1);
        
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
        // creation de la rampe de bouton pour defiler page par page
        JButton topJButton = new JButton("<<");
        JButton pageUPJButton = new JButton("<");
        JButton pageDOWNJButton = new JButton(">");
        JButton bottomJButton = new JButton(">>");
        
        JPanel rampePan = new JPanel();
            rampePan.add(topJButton);
            rampePan.add(pageUPJButton);
            rampePan.add(pageDOWNJButton);
            rampePan.add(bottomJButton);
            
            
        // creation du bouton fermer
        JButton fermerJButton = new JButton("Fermer");
        JPanel fermerPan = new JPanel();
            fermerPan.add(fermerJButton);
            
        // bloc boutons = rampe + fermer
        JPanel blocPan = new JPanel(new BorderLayout());
            blocPan.add(rampePan, BorderLayout.NORTH);
            blocPan.add(fermerPan, BorderLayout.CENTER);          
        
        // assemblage
        JPanel listerPan = new JPanel(new BorderLayout());
            listerPan.add(tab.getTableHeader(), BorderLayout.NORTH);
            listerPan.add(tab, BorderLayout.CENTER);
            listerPan.add(blocPan, BorderLayout.SOUTH);
            listerDialog.add(listerPan);
    
        // reflexes de la rampe de bouton
        topJButton.addActionListener(e -> { top(); });
        pageUPJButton.addActionListener(e -> { pageUP(); });
        pageDOWNJButton.addActionListener(e -> { pageDOWN(); });
        bottomJButton.addActionListener(e -> { bottom(); });
        
        // reflexe de fermeture de la fenetre
        fermerJButton.addActionListener(e -> { listerDialog.dispose(); });
        
        // affichage de la fenetre
        listerDialog.setVisible(true);
    }
    
    // reflexes gerant le defilement des ecrans (à implémenter...)
    public void top(){
        System.out.println("ListIHM : Debut de page");
        this.k = 1;
    }
    
    public void pageUP(){
        System.out.println("ListIHM : recule d'une page");
        int var = this.k;
        var -= 1;
        this.k = java.lang.Math.max(1, var);
    }
    
    public void pageDOWN(){
        System.out.println("ListIHM : avance d'une page");
        int var = this.k;
        var += 1;
        this.k = java.lang.Math.min(1 + (this.sizeData/20), var);
    }
    
    public void bottom(){
        System.out.println("ListIHM : Fin de page");
        this.k = this.sizeData/20;
    }
    
    // methodes renvoyant les indices de début et de fin pour la pagination (20 lignes)
    private int id_debut(){ return (this.k - 1)*20 + 1; }
    private int id_fin(){ return java.lang.Math.min(this.k*20, this.sizeData); }
    
}
