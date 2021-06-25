package ProjetTakeYourMoney;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JDialogSaisieModifierProd extends JDialog {

	public JDialogSaisieModifierProd(String nomTable, String item) throws IOException {
		super();
		constructJDialog(nomTable, item);
	}

	private JPanel construirePanelProduit() {
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(new GridLayout(4, 2));
		panelProduit.setBackground(Color.WHITE);

		JLabel titreDesignation = new JLabel("Désignation:", SwingConstants.RIGHT);
		panelProduit.add(titreDesignation);
		JTextField champDesignation = new JTextField();
		champDesignation.setText("METTRE LA VALEUR SQL");
		panelProduit.add(champDesignation);

		JLabel titrePrixHT = new JLabel("Prix HT :", SwingConstants.RIGHT);
		panelProduit.add(titrePrixHT);
		JTextField champPrixHT = new JTextField();
		champPrixHT.setText("METTRE LA VALEUR SQL");
		panelProduit.add(champPrixHT);

		// Ajout du bouton Modifier

		JPanel panelBtnActions = new JPanel();
		panelBtnActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnActions.setBackground(Color.WHITE);

		JPanel panelBtnModifier = new JPanel();
		panelBtnModifier.setLayout(new FlowLayout(FlowLayout.RIGHT));

		panelBtnModifier.setBackground(Color.WHITE);

		JButton btnModifier = new JButton("Modifier");

		panelBtnModifier.add(btnModifier);

		JPanel panelBtnAnnuler = new JPanel();
		panelBtnAnnuler.setLayout(new FlowLayout(FlowLayout.RIGHT));

		panelBtnAnnuler.setBackground(Color.WHITE);

		JButton btnAnnuler = new JButton("Annuler");

		panelBtnAnnuler.add(btnAnnuler);

		panelBtnActions.add(panelBtnAnnuler);
		panelBtnActions.add(panelBtnModifier);
		panelProduit.add(panelBtnActions);

		btnModifier.addActionListener(e -> {

			int confirmation = JOptionPane.showOptionDialog(null, "Êtes-vous sûr(e) de vouloir modifier cet item ?",
					"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirmation == JOptionPane.YES_OPTION) {

				String nouveauNom = champDesignation.getText();
				String nouveauPrixHT = champPrixHT.getText();
			} else {
			}
		});

		btnAnnuler.addActionListener(e -> {
			dispose();
		});

		return panelProduit;
	}

	private void constructJDialog(String nomTable, String item) throws IOException {
		setSize(400, 200);
		setTitle("Modifier les informations du produit");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // A REVERIFIER
		setModal(true);

		setContentPane(construirePanelProduit());
		getContentPane().setBackground(Color.WHITE);

	}

}
