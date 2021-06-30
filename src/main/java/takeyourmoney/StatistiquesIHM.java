/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Pascal
 */
public class StatistiquesIHM {

    // constructeur de la JDIALOG Liste
    StatistiquesIHM() {
        createStatDialog();
    }

    // creation d'une JTable
    private void createStatDialog() {

        // fenetre principale
        JDialog statDialog = new JDialog();
        statDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        statDialog.setModal(true);
        statDialog.setSize(800, 800);
        statDialog.setTitle("Affichage des statistiques");

        // label presentation        
        String banName = "banniereTYM.jpg";
        JLabel banLabel = new JLabel("", new ImageIcon(banName), JLabel.CENTER);
        
        // creation du canvas pour afficher les statistiques
        GraphicIHM cnv = new GraphicIHM();
        cnv.setSize(800, 800);
        cnv.setBackground(Color.WHITE);

        // création d'un objet bordure
        Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
        cnv.setBorder(lineborder);
        
        // creation du bouton fermer
        JButton fermerJButton = new JButton("Fermer");
        JPanel fermerPan = new JPanel();
        fermerPan.add(fermerJButton);
        fermerPan.setBackground(Color.WHITE);

        // reflexe de fermeture de la fenetre
        fermerJButton.addActionListener(e -> {
            statDialog.dispose();
        });

        // assemblage
        JPanel statPan = new JPanel(new BorderLayout());
            statPan.add(banLabel, BorderLayout.NORTH);
            statPan.add(cnv, BorderLayout.CENTER);
            statPan.add(fermerPan, BorderLayout.SOUTH);
        
        statDialog.add(statPan);

        // affichage de la fenetre
        statDialog.setVisible(true);
    }

}
