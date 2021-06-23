package ProjetTakeYourMoney;

import java.awt.HeadlessException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class GraphicUserInterface {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				JDialogModifAjoutSuppr mainFrame = null;
				try {
					mainFrame = new JDialogModifAjoutSuppr("PRODUITS");
				} catch (HeadlessException e) {

				} catch (IOException e) {

					e.printStackTrace();
				}
				mainFrame.setVisible(true);
			}
		});
	}
}
