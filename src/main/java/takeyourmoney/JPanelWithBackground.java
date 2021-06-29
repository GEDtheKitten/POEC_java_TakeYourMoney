package takeyourmoney;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {

    private final Image backgroundImage;

    public JPanelWithBackground() throws IOException {
        backgroundImage = ImageIO.read(new File("banniereTYM.jpg"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);

        g.setClip(0, 0, 800, 600);

    }
}
