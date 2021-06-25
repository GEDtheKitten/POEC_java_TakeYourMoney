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
public class GraphicIHM extends JPanel{
    
    GraphicIHM(){
        System.out.println("APPEL DU CONSTRUCTEUR GraphicIHM");
    }
    
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("APPEL DE paintComponent");
        super.paintComponent(g);

             // On dessine les courbes statistiques ici
             g.setColor(Color.YELLOW);
             g.drawLine(30, 40, 100, 200);
             g.drawOval(150, 180, 10, 10);
             g.drawRect(200, 210, 20, 30);
             
             g.setColor(Color.RED);
             g.fillOval(300, 310, 30, 50);
             g.setColor(Color.BLUE);
             g.fillRect(400, 350, 60, 50);
             
             // texte
             g.setColor(Color.WHITE);
             g.setFont(new Font("Monospaced", Font.PLAIN, 12));
             g.drawString("Graphiques de statistiques à dessiner ...", 10, 20);
    }
}
