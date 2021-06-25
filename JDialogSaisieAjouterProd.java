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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JDialogSaisieAjouterProd extends JDialog {

	public JDialogSaisieAjouterProd(String nomTable) throws IOException {
		super();
		constructJDialog(nomTable);
	}

	private JPanel construirePanelProduit() {
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(new GridLayout(4, 2));
		panelProduit.setBackground(Color.WHITE);

		JLabel titreDesignation = new JLabel("Désignation:", SwingConstants.RIGHT);
		panelProduit.add(titreDesignation);
		JTextField champDesignation = new JTextField();
		panelProduit.add(champDesignation);

		JLabel titrePrixHT = new JLabel("Prix HT :", SwingConstants.RIGHT);
		panelProduit.add(titrePrixHT);
		JTextField champPrixHT = new JTextField();
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

			// JDialog validation UTILISATEUR ***************

			String nouveauNom = champDesignation.getText();
			String nouveauPrixHT = champPrixHT.getText();
		});

		btnAnnuler.addActionListener(e -> {
			dispose();
		});

		return panelProduit;
	}

	private void constructJDialog(String nomTable) throws IOException {
		setSize(400, 200);
		setTitle("Ajouter un produit");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // A REVERIFIER
		setModal(true);

		setContentPane(construirePanelProduit());
		getContentPane().setBackground(Color.WHITE);

	}

}
