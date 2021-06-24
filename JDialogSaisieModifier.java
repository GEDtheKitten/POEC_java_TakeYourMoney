package ProjetTakeYourMoney;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JDialogSaisieModifier extends JDialog {

	public JDialogSaisieModifier(String nomTable, String item) throws IOException {
		super();
		constructJDialog(nomTable, item);
	}

	private JPanel construirePanelClient() {
		JPanel panelClient = new JPanel();
		panelClient.setLayout(new GridLayout(9, 2));
		panelClient.setBackground(Color.WHITE);

		JLabel titreNom = new JLabel("Nom :", SwingConstants.RIGHT);
		panelClient.add(titreNom);
		JTextField champNom = new JTextField();
		champNom.setText("METTRE LA VALEUR SQL");
		panelClient.add(champNom);

		JLabel titrePrenom = new JLabel("Prénom :", SwingConstants.RIGHT);
		panelClient.add(titrePrenom);
		JTextField champPrenom = new JTextField();
		champPrenom.setText("METTRE LA VALEUR SQL");
		panelClient.add(champPrenom);

		JLabel titreAdress1 = new JLabel("Adresse 1 :", SwingConstants.RIGHT);
		panelClient.add(titreAdress1);
		JTextField champAdress1 = new JTextField();
		champAdress1.setText("METTRE LA VALEUR SQL");
		panelClient.add(champAdress1);

		JLabel titreAdress2 = new JLabel("Adresse 2 :", SwingConstants.RIGHT);
		panelClient.add(titreAdress2);
		JTextField champAdress2 = new JTextField();
		champAdress2.setText("METTRE LA VALEUR SQL");
		panelClient.add(champAdress2);

		JLabel titreCodePostal = new JLabel("Code postal :", SwingConstants.RIGHT);
		panelClient.add(titreCodePostal);
		JTextField champCodePostal = new JTextField();
		champCodePostal.setText("METTRE LA VALEUR SQL");
		panelClient.add(champCodePostal);

		JLabel titreVille = new JLabel("Ville :", SwingConstants.RIGHT);
		panelClient.add(titreVille);
		JTextField champVille = new JTextField();
		champVille.setText("METTRE LA VALEUR SQL");
		panelClient.add(champVille);

		JLabel titreTelephone = new JLabel("Telephone :", SwingConstants.RIGHT);
		panelClient.add(titreTelephone);
		JTextField champTelephone = new JTextField();
		champTelephone.setText("METTRE LA VALEUR SQL");
		panelClient.add(champTelephone);

		// Ajout du bouton Modifier

		JPanel panelBtnActions = new JPanel();
		panelBtnActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnActions..setBackground(Color.WHITE);
		
		JPanel panelBtnModifier = new JPanel();
		panelBtnModifier.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnModifier.setBackground(Color.WHITE);

		JButton btnModifier = new JButton("Modifier");
		panelBtnModifier.add(btnModifier);

		JPanel panelBtnAnnuler = new JPanel();
		panelBtnAnnuler.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnAnnuler.setBackground(Color.WHITE);

		JButton btnAnnuler= new JButton("Annuler");
		panelBtnAnnuler.add(btnAnnuler);
		
		panelBtnActions.add(panelBtnAnnuler);
		panelBtnActions.add(panelBtnModifier);
		panelClient.add(panelBtnActions);
		
		btnModifier.addActionListener(e -> {
			String nouveauNom = champNom.getText();
			String nouveauPrenom = champPrenom.getText();
			String nouveauAdress1 = champAdress1.getText();
			String nouveauAdress2 = champAdress2.getText();
			String nouveauCP = champCodePostal.getText();
			String nouveauVille = champVille.getText();
			String nouveauTelephone = champTelephone.getText();
			
			try {
				ImportSQL.mettreAJourData(getWarningString(), null, getName());
			} catch (IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnAnnuler.addActionListener(e -> {
			dispose();
		});
		
		return panelClient;
	}

	private void constructJDialog(String nomTable, String item) throws IOException {
		setSize(400, 400);
		setTitle("Modifier les informations (" + nomTable + ")");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // A REVERIFIER
		setModal(true);

		setContentPane(construirePanelClient());
		getContentPane().setBackground(Color.WHITE);

	}

}
