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

public class JDialogSaisieAjouterClient extends JDialog {

	public JDialogSaisieAjouterClient(String nomTable) throws IOException {
		super();
		constructJDialog(nomTable);
	}

	private JPanel construirePanelClient() {
		JPanel panelClient = new JPanel();
		panelClient.setLayout(new GridLayout(9, 2));
		panelClient.setBackground(Color.WHITE);

		JLabel titreNom = new JLabel("Nom :", SwingConstants.RIGHT);
		panelClient.add(titreNom);
		JTextField champNom = new JTextField();
		panelClient.add(champNom);

		JLabel titrePrenom = new JLabel("Prénom :", SwingConstants.RIGHT);
		panelClient.add(titrePrenom);
		JTextField champPrenom = new JTextField();
		panelClient.add(champPrenom);

		JLabel titreAdress1 = new JLabel("Adresse 1 :", SwingConstants.RIGHT);
		panelClient.add(titreAdress1);
		JTextField champAdress1 = new JTextField();
		panelClient.add(champAdress1);

		JLabel titreAdress2 = new JLabel("Adresse 2 :", SwingConstants.RIGHT);
		panelClient.add(titreAdress2);
		JTextField champAdress2 = new JTextField();
		panelClient.add(champAdress2);

		JLabel titreCodePostal = new JLabel("Code postal :", SwingConstants.RIGHT);
		panelClient.add(titreCodePostal);
		JTextField champCodePostal = new JTextField();
		panelClient.add(champCodePostal);

		JLabel titreVille = new JLabel("Ville :", SwingConstants.RIGHT);
		panelClient.add(titreVille);
		JTextField champVille = new JTextField();
		panelClient.add(champVille);

		JLabel titreTelephone = new JLabel("Telephone :", SwingConstants.RIGHT);
		panelClient.add(titreTelephone);
		JTextField champTelephone = new JTextField();
		panelClient.add(champTelephone);

		// Ajout du bouton Modifier

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
		panelClient.add(panelBtnActions);

		btnAjouter.addActionListener(e -> {

			int confirmation = JOptionPane.showOptionDialog(null, "Êtes-vous sûr(e) de vouloir  ajouter un client ?",
					"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirmation == JOptionPane.YES_OPTION) {

				String nouveauNom = champNom.getText();
				String nouveauPrenom = champPrenom.getText();
				String nouveauAdress1 = champAdress1.getText();
				String nouveauAdress2 = champAdress2.getText();
				String nouveauCP = champCodePostal.getText();
				String nouveauVille = champVille.getText();
				String nouveauTelephone = champTelephone.getText();

				ajouterClient(nouveauNom, nouveauPrenom, nouveauAdress1, nouveauAdress2, nouveauCP, nouveauVille,
						nouveauTelephone);
				dispose();
			} else {

			}
		});

		btnAnnuler.addActionListener(e -> {
			dispose();
		});

		return panelClient;
	}

	private void constructJDialog(String nomTable) throws IOException {
		setSize(400, 400);
		setTitle("Ajouter un client");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // A REVERIFIER
		setModal(true);

		setContentPane(construirePanelClient());
		getContentPane().setBackground(Color.WHITE);

	}

	public void ajouterClient(String nouveauNom, String nouveauPrenom, String nouveauAdress1, String nouveauAdress2,
			String nouveauCP, String nouveauVille, String nouveauTelephone) {
		// APPELER PROCEDURE D'AJOUT CLIENT
	}

}
