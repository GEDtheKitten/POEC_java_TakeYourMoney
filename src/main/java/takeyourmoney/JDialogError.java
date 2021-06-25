package ProjetTakeYourMoney;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JDialogError extends JDialog {

	public JDialogError() throws IOException {
		super();
		constructJDialog();
	}

	private JPanel construirePanelError() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		JPanel panelTitre = new JPanel();
		panelTitre.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel titreConsigne = new JLabel(
				"<html><br><center><b>Ce programme a effectué<br><center>une opération non conforme.<br><center>Veuillez contacter l'équipe support.</html>");
		panelTitre.add(titreConsigne);
		panel.add(panelTitre);

		// Ajout du bouton OK

		JPanel panelBtnOK = new JPanel();
		panelBtnOK.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btnOK = new JButton("OK");
		btnOK.setHorizontalAlignment(SwingConstants.CENTER);
		panelBtnOK.add(btnOK);

		panel.add(panelBtnOK);

		btnOK.addActionListener(e -> {

			dispose();

		});

		return panel;
	}

	private void constructJDialog() throws IOException {
		setSize(300, 200);
		setTitle("Erreur 404");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // A REVERIFIER
		setModal(true);

		setContentPane(construirePanelError());
		getContentPane().setBackground(Color.WHITE);

	}

}
