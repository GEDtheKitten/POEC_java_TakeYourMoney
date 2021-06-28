package takeyourmoney;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class JDialogGestion extends JDialog {

	public JDialogGestion(String type) throws IOException {
		super();
		constructJDialog(type);
	}

	private JPanel constructPanel(String type) throws IOException {

		// PANEL PRINCIPAL : panel avec la bannière (800*200)
		JPanelWithBackground panelTitle = new JPanelWithBackground();

		panelTitle.setLayout(null);
		panelTitle.setBackground(Color.white);
		this.setContentPane(panelTitle);
		panelTitle.setSize(800, 600);

		// Ajout du titre
		JLabel title = new JLabel("<html><body> ------------------------------- <br> " + type + "<body></html>");
		title.setFont(new Font("Calibri", Font.BOLD, 20));
		panelTitle.add(title);

		// Content (panel de 2 colonnes)
		JPanel panelContent = new JPanel();
		panelContent.setLayout(new GridLayout(1, 2));
		panelContent.setBounds(0, 100, 800, 500);
		panelContent.setBackground(Color.white);

		// Rattachement du layout Content dans le layout principal
		panelTitle.add(panelContent);

		// Sous panel gauche du panel Content
		JPanel panelSelection = new JPanel();
		panelSelection.setLayout(null);
		panelSelection.setBounds(0, 100, 400, 500);
		panelSelection.setBackground(Color.white);
		// Mettre image !!! ***********************************

		// Sous panel du sous panel gauche
		JPanel panelListeDeroulante = new JPanel();
		panelSelection.setLayout(new GridLayout(3, 1));
		panelListeDeroulante.setBackground(Color.white);

		Object[] liste;

		if (type.equals("CLIENTS")) {
			liste = new String[] { "Texte", "Texte"// IMPORTER NOMS CLIENTS PAR ORDRE ALPHABETIQUE ********************
			};
		} else if (type.equals("PRODUITS")) {
			liste = new Object[] { "Texte", "Texte"// IMPORTER DESIGNATIONS PRODUITS PAR ORDRE ALPHABETIQUE
													// *********************
			};
		} else {
			liste = new Object[] { "Texte", "Texte"// IMPORTER NUM COMMANDE ? ************************
			};
		}

		JComboBox listeDeroulante = new JComboBox(liste);

		listeDeroulante.setPreferredSize(new Dimension(350, 30));
		panelListeDeroulante.add(listeDeroulante);
		panelSelection.add(panelListeDeroulante);

		// PANEL Boutons Actions
		JPanel panelActions = new JPanel();
		panelActions.setBounds(0, 200, 100, 150);
		panelActions.setBackground(Color.white);

		GridLayout gridL = new GridLayout(3, 1);
		gridL.setHgap(10);
		gridL.setVgap(10);

		panelActions.setLayout(gridL);

		// Ajout du bouton Modifier (non visible pour les commandes)

		JPanel panelBtnModifier = new JPanel();
		panelBtnModifier.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnModifier.setBackground(Color.white);

		JButton btnModifier = new JButton("Modifier");

		if (type.equals("Commandes")) {
			btnModifier.setVisible(false);
		} else {
			btnModifier.setVisible(true);
		}

		panelBtnModifier.add(btnModifier);

		panelActions.add(panelBtnModifier);

		// Ajout du bouton Supprimer (non visible pour les Commandes)

		JPanel panelBtnSupprimer = new JPanel();
		panelBtnSupprimer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnSupprimer.setBackground(Color.white);

		JButton btnSupprimer = new JButton("Supprimer");

		if (type.equals("Commandes")) {
			btnSupprimer.setVisible(false);
		} else {
			btnSupprimer.setVisible(true);
		}

		panelBtnSupprimer.add(btnSupprimer);

		panelActions.add(panelBtnSupprimer);

		// Ajout du bouton Ajouter

		JPanel panelBtnAjouter = new JPanel();
		panelBtnAjouter.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnAjouter.setBackground(Color.white);

		JButton btnAjouter = new JButton("Ajouter");
		panelBtnAjouter.add(btnAjouter);

		panelActions.add(panelBtnAjouter);

		// sous panel droit du panel Content
		JPanel panelDisplay = new JPanel();
		panelDisplay.setBackground(Color.white);
		panelActions.setBounds(400, 100, 400, 300);
		String text = "Il faut importer les données";

		panelSelection.add(panelActions);

		panelContent.add(panelSelection);

		// Importer les éléments à afficher ********************************
		// Réimport des infos en fonction du type (Produits, Clients, Commandes)
		// + des infos en fonction de (listeDeroulante.getSelectedItem()).toString()
		// ****************************************************************************************

		JTextArea display = new JTextArea(text);
		display.setEditable(false); // textArea non éditable

		display.setPreferredSize(new Dimension(350, 400));
		display.setLineWrap(true);
		display.setWrapStyleWord(true);

		JScrollPane scroll = new JScrollPane(display);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Ajout de la zone de texte au PANEL n°1
		panelDisplay.add(scroll);

		// Ajout du bouton "Fermer"

		JPanel panelBtnFermer = new JPanel();
		panelBtnFermer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnFermer.setPreferredSize(new Dimension(355, 50));
		panelBtnFermer.setBackground(Color.white);

		JButton btnFermer = new JButton("Fermer");
		panelBtnFermer.add(btnFermer);

		panelDisplay.add(panelBtnFermer);

		panelContent.add(panelDisplay);

		// APPEL LISTENERS

		int iD = 0;
		btnFermer.addActionListener(e -> {
			dispose();
		});

		btnAjouter.addActionListener(e -> {
			String valeurSelectionnee = objetListeDeroulante(listeDeroulante);
			ajouterData(type);
		});

		btnModifier.addActionListener(e -> {
			String valeurSelectionnee = objetListeDeroulante(listeDeroulante);
			modifierData(type, valeurSelectionnee);
		});
		btnSupprimer.addActionListener(e -> {
			int confirmation = JOptionPane.showOptionDialog(null, "Êtes-vous sûr(e) de vouloir supprimer cet item ?",
					"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirmation == JOptionPane.YES_OPTION) {

				String valeurSupprimee = objetListeDeroulante(listeDeroulante);
				supprimerData(type, valeurSupprimee);
				JDialogConfirmationSuppression ecranConfirmationSuppression = new JDialogConfirmationSuppression();
				ecranConfirmationSuppression.setVisible(true);
			}
		});

		listeDeroulante.addActionListener(e -> {
			String valeurSelectionnee = objetListeDeroulante(listeDeroulante);
			mettreAJourTextArea(display, valeurSelectionnee);
		});

		return panelTitle;

	}

	private void constructJDialog(String type) throws IOException {
		setSize(800, 600);
		setTitle(type);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		// Construire le panel supérieur
		setContentPane(constructPanel(type));
		getContentPane().setBackground(Color.WHITE);

	}

	public void modifierData(String type, String valeurSelectionnee) {
		if (type == "Produits") {
			JDialogSaisieModifierProd modifierProduit = null;
			try {
				modifierProduit = new JDialogSaisieModifierProd(valeurSelectionnee);
				
			} catch (IOException e1) {
				JDialogError ecranErreur = new JDialogError();
				ecranErreur.setVisible(true);
			}
			modifierProduit.setModal(true);
			modifierProduit.setVisible(true);
		} else if (type == "Clients") {
			JDialogSaisieModifierClient modifierClient = null;
			try {
				modifierClient = new JDialogSaisieModifierClient(valeurSelectionnee);
			} catch (IOException e1) {
				JDialogError ecranErreur = new JDialogError();
				ecranErreur.setVisible(true);
			}
			modifierClient.setModal(true);
			modifierClient.setVisible(true);

		}
	}

	public void ajouterData(String type) {
		if (type == "Produits") {
			JDialogSaisieAjouterProd ajouterProduit = null;
			try {
				ajouterProduit = new JDialogSaisieAjouterProd();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ajouterProduit.setModal(true);
			ajouterProduit.setVisible(true);
		} else if (type == "Clients") {
			JDialogSaisieAjouterClient ajouterClient = null;
			try {
				ajouterClient = new JDialogSaisieAjouterClient();
			} catch (IOException e1) {
				JDialogError ecranErreur = new JDialogError();
				ecranErreur.setVisible(true);
			}
			ajouterClient.setModal(true);
			ajouterClient.setVisible(true);

		} else if (type == "Commandes") {
			JDialogSaisieAjouterCommandeClient ajouterCommande = null;
			try {
				ajouterCommande = new JDialogSaisieAjouterCommandeClient();
			} catch (IOException e1) {
				JDialogError ecranErreur = new JDialogError();
				ecranErreur.setVisible(true);
			}
			ajouterCommande.setModal(true);
			ajouterCommande.setVisible(true);
		}
	}

	public void supprimerData(String type, String valeurSupprimee) {

		if (type.equals("Produits")) {
			if (!produitDejaCommande(valeurSupprimee)) {
				supprimerClient(valeurSupprimee);
			} else {
				anonymiserClient(valeurSupprimee);
			}
		} else if (type.equals("Clients")) {
			if (!clientADejaCommande(valeurSupprimee)) {
				supprimerClient(valeurSupprimee);
			} else {
				anonymiserClient(valeurSupprimee);
			}
		}
	}

	/**
	 * Méthode pour récupérer la valeur sélectionnée de la liste déroulante
	 * 
	 * @param JComboBox listeDeroulante
	 * @return
	 */

	public String objetListeDeroulante(JComboBox listeDeroulante) {
		// System.out.println("La valeur sélectionnée est " +
		// (listeDeroulante.getSelectedItem()).toString());
		return (listeDeroulante.getSelectedItem()).toString();

	}

	public boolean clientADejaCommande(String nomClient) {
		// APPEL PROCEDURE DE VERIFICATION POUR SAVOIR SI LE CLIENT A DEJA ACHETE
		// ************************************
		return true;
	}

	public boolean produitDejaCommande(String nomProduit) {
		// APPEL PROCEDURE DE VERIFICATION POUR SAVOIR SI LE PRODUIT A DEJA ETE ACHETE
		// ************************************
		return true;
	}

	public void supprimerClient(String nomClient) {
		// APPEL PROCEDURE POUR SUPPRIMER LE CLIENT ************************************
	}

	public void anonymiserClient(String nomClient) {
		// APPEL PROCEDURE POUR ANONYMISER ************************************
	}

	public void supprimerProduit(String nomProduit) {
		// APPEL PROCEDURE POUR SUPPRIMER LE PRODUIT
		// ************************************
	}

	public void desactiverProduit(String nomProduit) {
		// APPEL PROCEDURE POUR DESACTIVER LE PRODUIT
		// ************************************
	}

	public void mettreAJourTextArea(JTextArea display, String valeurSelectionnee) {
		String texte = "Il faudra réimporter la liste à nouveau !";
		// Réimport des infos en fonction du type (Produits, Clients, Commandes)
		// Réimport des infos en fonction de
		// (listeDeroulante.getSelectedItem()).toString() (= valeurSelectionnee)
		// ****************************************************************************************
		display.setText(texte);
		display.repaint();
	}
}
