/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;


/**
 *
 * @author Pascal
 */
public class ListIHM {    
    
    private final int PAGINATION = 10;    
    private Pagination pag;
    
    // nom de la table
    private final String nomTable;
    
    // la JTable a reactualiser
    private final JTable jtab;
    
    // La classe gestion de données
    private final DataTables dat;

    
    // constructeur de la JDIALOG Liste    
    ListIHM(Connection cn, String nomTab){
        
        this.nomTable = nomTab;        
        
        // initialisation d'une DataTables : connecteur, nomTable
        // => calcul auto de sizeTable (utile pour la pagination), recuperable par getSizeTable            
        this.dat = new DataTables(cn, this.nomTable);

        // la premiere requete se fait à l'offset 0
        String rq = "SELECT * FROM " + this.nomTable + " LIMIT " + this.PAGINATION + " OFFSET 0;";
        
        // lancement de la requete rq et insertion des résultats dans dat
        this.dat.getDataFromRequest(rq);
         
        // on instancie l'objet pagination
        int sizeTab = dat.getSizeTable();
        pag = new Pagination(sizeTab, this.PAGINATION);
        
        // creation de jtab
        this.jtab = new JTable(dat.getData(), dat.getEntete());
        this.jtab.setEnabled(false);    //  JTable non editable

        
        // construction graphique
        // fenetre principale
        JDialog listerDialog = new JDialog();
            listerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            listerDialog.setModal(true);
            listerDialog.setSize(800, 20*this.PAGINATION + 200);
            listerDialog.setTitle("Affichage des " + this.nomTable);

        // label presentation        
        String banName = "banniereTYM.jpg";
        JLabel banLabel = new JLabel("", new ImageIcon(banName), JLabel.CENTER);

            
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
            rampePan.setBackground(Color.WHITE);
            
            
        // creation du bouton fermer
        JButton fermerJButton = new JButton("Fermer");
        JPanel fermerPan = new JPanel();
            fermerPan.add(fermerJButton);
            fermerPan.setBackground(Color.WHITE);
                     
        
        // assemblage
        JPanel jtablePan = new JPanel(new BorderLayout());
            jtablePan.add(this.jtab.getTableHeader(), BorderLayout.NORTH);
            jtablePan.add(this.jtab, BorderLayout.CENTER);
            
            // Scroll vertical peut être inutile avec la pagination
            JScrollPane scroll = new JScrollPane(jtablePan);
            //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            JPanel blocPan = new JPanel(new BorderLayout());
                blocPan.add(scroll, BorderLayout.NORTH);
                blocPan.add(rampePan, BorderLayout.SOUTH);
                blocPan.setBackground(Color.WHITE);
            
            listerDialog.add(banLabel, BorderLayout.NORTH);
            listerDialog.add(blocPan, BorderLayout.CENTER);
            listerDialog.add(fermerPan, BorderLayout.SOUTH);
            listerDialog.getContentPane().setBackground(Color.WHITE);

    
        // reflexes de la rampe de bouton gerant le defilement des ecrans
        // on ne fait l'actualisation que si la page a changé pour éviter des requêtes inutiles
        topJButton.addActionListener(e ->       { if (pag.pageTOP())    updateJTable(pag.getOffset()); });
        pageUPJButton.addActionListener(e ->    { if (pag.pageUP())     updateJTable(pag.getOffset()); });
        pageDOWNJButton.addActionListener(e ->  { if (pag.pageDOWN())   updateJTable(pag.getOffset()); });
        bottomJButton.addActionListener(e ->    { if (pag.pageBOTTOM()) updateJTable(pag.getOffset()); });
        
        // reflexe de fermeture de la fenetre
        fermerJButton.addActionListener(e -> { listerDialog.dispose(); });
        
        // affichage de la fenetre
        listerDialog.setVisible(true);
    }    
           
    private void updateJTable(int offset){
        
        // requete réactualisée avec l'offset
        String rq = "SELECT * FROM " + this.nomTable + " LIMIT " + this.PAGINATION + " OFFSET " + offset + ";";

        // lancement de la requete rq et insertion des résultats dans dat (mise à jour après avancée d'une page par ex.)
        this.dat.getDataFromRequest(rq);
                
        // mise à jour de la JTable
        DefaultTableModel defTab = new DefaultTableModel(dat.getData(), dat.getEntete());
        this.jtab.setModel(defTab);
    }
}
