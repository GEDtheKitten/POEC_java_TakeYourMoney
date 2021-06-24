package ProjetTakeYourMoney;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class JDialogModifAjoutSuppr extends JDialog {

	public JDialogModifAjoutSuppr(String type) throws IOException {
		super();
		constructJDialog(type);
	}

	private JPanel constructPanel(String type) throws IOException {

		// PANEL PRINCIPAL : panel avec l'image de fond (800*200)
		JPanelWithBackground panelTitle = new JPanelWithBackground();

		panelTitle.setLayout(null);
		panelTitle.setBackground(Color.white);
		this.setContentPane(panelTitle);
		panelTitle.setSize(800, 600);

		// Ajout du titre
		JLabel title = new JLabel("<html><body> ------------------------------- <br> " + type + "<body></html>");
		title.setFont(new Font("Calibri", Font.BOLD, 20));
		panelTitle.add(title);

		// PANEL CONTENT (2 colonnes)
		JPanel panelContent = new JPanel();
		panelContent.setLayout(new GridLayout(1, 2));
		panelContent.setBounds(0, 100, 800, 500); // x = 0, y = 50
		panelContent.setBackground(Color.white);

		// Rattachement du layoutCONTENT de 2 colonnes dans le layout principal
		panelTitle.add(panelContent);

		// PANEL n°3 (sous panel gauche du PANEL n°2)
		JPanel panelSelection = new JPanel();
		panelSelection.setLayout(null);
		panelSelection.setBounds(0, 100, 400, 500);
		panelSelection.setBackground(Color.white);
		// Mettre image !!! ***********************************

		// PANEL n°4 (sous panel gauche du PANEL n°2)
		JPanel panelListeDeroulante = new JPanel();
		panelSelection.setLayout(new GridLayout(3, 1)); // !!!!!!!!!!!!!!!
		panelListeDeroulante.setBackground(Color.white);

		// Ajout de la liste déroulante dans le PANEL n°3
		Object[] liste;

		if (type.equals("CLIENTS")) {
			liste = new String[] { "Texte", "Texte"// IMPORTER NOMS CLIENTS PAR ORDRE ALPHABETIQUE
			};
		} else if (type.equals("PRODUITS")) {
			liste = new Object[] { "Texte", "Texte"// IMPORTER DESIGNATIONS PRODUITS PAR ORDRE ALPHABETIQUE
			};
		} else {
			liste = new Object[] { "Texte", "Texte"// IMPORTER NUM COMMANDE ?
			};
		}

		JComboBox listeDeroulante = new JComboBox(liste);
		// ComboBoxClass listeDeroulante = new ComboBoxClass(liste);
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

		// Ajout du bouton Modifier

		JPanel panelBtnModifier = new JPanel();
		panelBtnModifier.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnModifier.setBackground(Color.white);

		JButton btnModifier = new JButton("Modifier");

		if (type.equals("COMMANDES")) {
			btnModifier.setVisible(false);
		} else {
			btnModifier.setVisible(true);
		}

		panelBtnModifier.add(btnModifier);

		panelActions.add(panelBtnModifier);

		// Ajout du bouton Supprimer

		JPanel panelBtnSupprimer = new JPanel();
		panelBtnSupprimer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtnSupprimer.setBackground(Color.white);

		JButton btnSupprimer = new JButton("Supprimer");

		if (type.equals("COMMANDES")) {
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

		// PANEL n°6 (sous panel droit du PANEL n°2)
		JPanel panelDisplay = new JPanel();
		panelDisplay.setBackground(Color.white);
		panelActions.setBounds(400, 100, 400, 300);
		String text = "Il faut importer les données";

		panelSelection.add(panelActions);

		panelContent.add(panelSelection);

		// Importer les éléments à afficher ********************************
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
			ajouterData(type);
		});
		btnModifier.addActionListener(e -> {
			String valeurSelectionnee = objetListeDeroulante(listeDeroulante);
			modifierData(valeurSelectionnee, type);
		});
		btnSupprimer.addActionListener(e -> {
			// JDialog validation UTILISATEUR ***************
			String valeurSupprimee = objetListeDeroulante(listeDeroulante);
			modifierData(valeurSupprimee, type);
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

	public void modifierData(String valeur, String type) {
		System.out.println("Appel de la méthode modifierData()");
		// JDialog modif selon type
	}

	public void ajouterData(String type) {
		System.out.println("Appel de la méthode ajouterData()");
		// JDialog modif selon type
	}

	public void supprimerData(String valeur, String type) {
		System.out.println("Appel de la méthode supprimerData()");
		// JDialog validation UTILISATEUR SUPPRESSION *************** (renvoie à une
		// fonction de test si inclus dans commande)
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

}
