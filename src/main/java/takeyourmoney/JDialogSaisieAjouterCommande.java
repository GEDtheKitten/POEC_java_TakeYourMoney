package ProjetTakeYourMoney;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class JDialogSaisieAjouterCommande extends JDialog {

	public JDialogSaisieAjouterCommande(String nomClient) throws IOException {
		super();
		constructJDialog(nomClient);
	}

	private JPanel construirePanelCommande(String nomClient) {
		
		JPanel panelCommande = new JPanel();
		panelCommande.setLayout(new GridLayout(5, 1));
		panelCommande.setBackground(Color.WHITE);
		panelCommande.setPreferredSize(new Dimension(380, 500));


		JLabel titre = new JLabel("Création d'une nouvelle commande");
		panelCommande.add(titre);


		JPanel panelZoneTexte = new JPanel();
		panelZoneTexte.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelZoneTexte.setPreferredSize(new Dimension(350, 80));
		panelZoneTexte.setBackground(Color.WHITE);

		// Zone de texte affichant les produits déjà enregistrés dans la commande (a minima désignation et quantité)

		String text = "Il faudra afficher les produits + les quantités associées déjà saisies de la commande" + "\n"
				+ "Ceci est un test ; test " + "\n" + "Ceci est un test ; test " + "\n" + "Ceci est un test ; test "
				+ "\n" + "Ceci est un test ; test " + "\n";

		// Importer les éléments à afficher ********************************
		JTextArea display = new JTextArea(text);
		display.setEditable(false); // textArea non éditable

		display.setPreferredSize(new Dimension(350, 80));
		display.setLineWrap(true);
		display.setWrapStyleWord(true);

		JScrollPane scroll = new JScrollPane(display);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panelZoneTexte.add(scroll);
		panelCommande.add(panelZoneTexte);

		// LISTE DEROULANTE PRODUIT

		JPanel panelListeDeroulanteProduits = new JPanel();
		panelListeDeroulanteProduits.setPreferredSize(new Dimension(300, 50));
		panelListeDeroulanteProduits.setBackground(Color.white);

		Object[] liste;

		liste = new String[] { "Texte", "Texte"// IMPORTER NOMS PRODUITS PAR ORDRE ALPHABETIQUE -- Utiliser le nom de la
												// table "Produits" !!! ************************************
		};

		JComboBox listeDeroulanteProduits = new JComboBox(liste);
		listeDeroulanteProduits.setPreferredSize(new Dimension(300, 30));
		panelListeDeroulanteProduits.add(listeDeroulanteProduits);
		panelCommande.add(panelListeDeroulanteProduits);

		// Demander Quantité

		JPanel panelQuantite = new JPanel();
		panelQuantite.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelQuantite.setPreferredSize(new Dimension(350, 100));
		panelQuantite.setBackground(Color.white);

		JLabel titreQuantite = new JLabel("quantité :", SwingConstants.RIGHT);
		titreQuantite.setPreferredSize(new Dimension(100, 30));
		panelQuantite.add(titreQuantite);

		JTextField champQuantite = new JTextField();
		champQuantite.setPreferredSize(new Dimension(100, 30));
		panelQuantite.add(champQuantite);

		panelCommande.add(panelQuantite);

		// Ajout du bouton Ajouter et Terminer
		// La fenêtre ne doit pas se fermer après l'ajout d'un produit car une commande peut être composée de plusieurs produits

		JPanel panelBtnActions = new JPanel();
		panelBtnActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnActions.setBackground(Color.WHITE);

		JPanel panelBtnAjouter = new JPanel();
		panelBtnAjouter.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnAjouter.setBackground(Color.WHITE);

		JButton btnAjouter = new JButton("Ajouter");
		panelBtnAjouter.add(btnAjouter);

		JPanel panelBtnTerminer = new JPanel();
		panelBtnTerminer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnTerminer.setBackground(Color.WHITE);

		JButton btnTerminer = new JButton("Terminer");
		panelBtnTerminer.add(btnTerminer);

		panelBtnActions.add(panelBtnTerminer);
		panelBtnActions.add(panelBtnAjouter);
		panelCommande.add(panelBtnActions);

		
		// DEFINIR LES ACTIONS
		
		btnAjouter.addActionListener(e -> {

				String produitSelectionne = (listeDeroulanteProduits.getSelectedItem()).toString();
				String quantiteSaisie = champQuantite.getText();

				ajouterProduitDansCommande(produitSelectionne, quantiteSaisie);

				// Réactualiser la JTextArea display
				mettreAJourTextArea(display);
			}
		});

		btnTerminer.addActionListener(e -> {
			dispose();
		});

		return panelCommande;
	}

	private void constructJDialog(String nomClient) throws IOException {
		setSize(400, 500);
		setTitle("Créer une commande");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);

		setContentPane(construirePanelCommande(nomClient));
		getContentPane().setBackground(Color.WHITE);

	}

	public void ajouterProduitDansCommande(String produitSelectionne, String quantiteSaisie) {
		// APPELER PROCEDURE D'AJOUT PRODUIT DANS LA COMMANDE ***********************************
	}

	public void mettreAJourTextArea(JTextArea display) {
		String texte = "Il faudra réimporter la liste à nouveau !";
		// Réimport de la liste produits + quantite **********************************************
		display.setText(texte);
		display.repaint();
	}

}
