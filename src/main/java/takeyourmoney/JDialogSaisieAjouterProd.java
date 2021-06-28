package takeyourmoney;

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

public class JDialogSaisieAjouterProd extends JDialog {

	public JDialogSaisieAjouterProd() throws IOException {
		super();
		constructJDialog();
	}

	private JPanel construirePanelProduit() {
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(new GridLayout(4, 2));
		panelProduit.setBackground(Color.WHITE);

		// Demander la désignation et le PrixHT du produit

		JLabel titreDesignation = new JLabel("Désignation:", SwingConstants.RIGHT);
		panelProduit.add(titreDesignation);
		JTextField champDesignation = new JTextField();
		panelProduit.add(champDesignation);

		JLabel titrePrixHT = new JLabel("Prix HT :", SwingConstants.RIGHT);
		panelProduit.add(titrePrixHT);
		JTextField champPrixHT = new JTextField();
		panelProduit.add(champPrixHT);

		// Ajout des boutons Ajouter et Annuler

		JPanel panelBtnActions = new JPanel();
		panelBtnActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnActions.setBackground(Color.WHITE);

		JPanel panelBtnAjouter = new JPanel();
		panelBtnAjouter.setLayout(new FlowLayout(FlowLayout.RIGHT));

		panelBtnAjouter.setBackground(Color.WHITE);

		JButton btnAjouter = new JButton("Ajouter");

		panelBtnAjouter.add(btnAjouter);

		JPanel panelBtnAnnuler = new JPanel();
		panelBtnAnnuler.setLayout(new FlowLayout(FlowLayout.RIGHT));

		panelBtnAnnuler.setBackground(Color.WHITE);

		JButton btnAnnuler = new JButton("Annuler");

		panelBtnAnnuler.add(btnAnnuler);

		panelBtnActions.add(panelBtnAnnuler);
		panelBtnActions.add(panelBtnAjouter);
		panelProduit.add(panelBtnActions);

		// DEFINIR LES ACTIONS

		btnAjouter.addActionListener(e -> {

			int confirmation = JOptionPane.showOptionDialog(null, "Êtes-vous sûr(e) de vouloir ajouter un produit ?",
					"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirmation == JOptionPane.YES_OPTION) {

				String nouveauNom = champDesignation.getText();
				String nouveauPrixHT = champPrixHT.getText();

				// Vérifier nom (si vide + si caractères)
				if (!VerificationSaisie.testerSiVide(nouveauNom)) {
					JDialogTextFieldNonRempli ecranInfosManquantes = new JDialogTextFieldNonRempli("Prix du produit");
					ecranInfosManquantes.setVisible(true);
				} else if (!VerificationSaisie.testerSiCaracteres(nouveauNom)) {
					JDialogErreurSaisie ecranErreurSaisie = new JDialogErreurSaisie(
							"Le nom du produit n'est pas valide.");
					ecranErreurSaisie.setVisible(true);

					// Vérifier prix
				} else if (!VerificationSaisie.testerSiVide(nouveauPrixHT)) {
					JDialogTextFieldNonRempli ecranInfosManquantes = new JDialogTextFieldNonRempli("Prix du produit");
					ecranInfosManquantes.setVisible(true);
				} else if (!VerificationSaisie.estUnPrix(nouveauPrixHT)) {
					JDialogErreurSaisie ecranErreurSaisie = new JDialogErreurSaisie("Le prix saisi n'est pas valide.");
					ecranErreurSaisie.setVisible(true);
				} else {
					ajouterProduit(nouveauNom, nouveauPrixHT);
                                        // jDialog confirmation
                                        dispose();
				}

			}
		});

		btnAnnuler.addActionListener(e -> {
			dispose();
		});

		return panelProduit;
	}

	private void constructJDialog() throws IOException {
		setSize(400, 200);
		setTitle("Ajouter un produit");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);

		setContentPane(construirePanelProduit());
		getContentPane().setBackground(Color.WHITE);

	}

	public void ajouterProduit(String nouveauNom, String nouveauPrixHT) {
		// APPELER PROCEDURE D'AJOUT PRODUIT **********************
	}

}
