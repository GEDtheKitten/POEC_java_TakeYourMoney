/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Pascal
 */
public class FrameIHM {

	// constructeur de l'interface de base
	FrameIHM() {

		// Données provisoires

		// Fenetre principale + widgets associés
		JFrame jf = new JFrame("TakeYourMoney");
		jf.setPreferredSize(new Dimension(600, 600));
		jf.pack();

		// boutons de gestion interface principale
		JButton gererClients = new JButton("Client");
		JButton gererProduits = new JButton("Produits");
		JButton gererCommandes = new JButton("Commandes");

		// boutons de gestion interface principale
		JButton listerClients = new JButton("Client");
		JButton listerProduits = new JButton("Produits");
		JButton listerCommandes = new JButton("Commandes");

		// boutons de statistiques et fermeture interface principale
		JButton statCA = new JButton("statistiques");
		JButton quit = new JButton("quitter");

		// assemblage des boutons de gestion interface principale
		JPanel gererPan = new JPanel();
		gererPan.add(gererClients);
		gererPan.add(gererProduits);
		gererPan.add(gererCommandes);

		// assemblage des boutons de listage interface principale
		JPanel listerPan = new JPanel();
		listerPan.add(listerClients);
		listerPan.add(listerProduits);
		listerPan.add(listerCommandes);

		// assemblage des boutons de stat et fermeture interface principale
		JPanel statPan = new JPanel();
		statPan.add(statCA);
		statPan.add(quit);

		// label presentation
		String bienvenuText = "<html><h2 style=margin-left:165;>Bienvenue sur Take Your Money !</h2></html";
		JLabel bienvenuLabel = new JLabel(bienvenuText);

		// label gerer
		String gererText = "<html><p style=margin-left:125;>Gérer<p></html>";
		;
		JLabel gererLabel = new JLabel(gererText);

		// label lister
		String listerText = "<html><p style=margin-left:125;>Lister<p></html>";
		;
		JLabel listerLabel = new JLabel(listerText);

		// assemblage JLabel et JPanel
		JPanel globalPanel = new JPanel();
		LayoutManager layout = new BoxLayout(globalPanel, BoxLayout.Y_AXIS);
		globalPanel.setLayout(layout);

		globalPanel.add(gererLabel);
		globalPanel.add(gererPan);

		globalPanel.add(listerLabel);
		globalPanel.add(listerPan);

		globalPanel.add(statPan);

		jf.add(bienvenuLabel, BorderLayout.CENTER);
		jf.add(globalPanel, BorderLayout.SOUTH);

		// reflexes pour les boutons de l'interface principale
		// "à la lambda"

		// gerer
		gererClients.addActionListener(e -> {
			refGererClients();
		});
		gererProduits.addActionListener(e -> {
			refGererProduits();
		});
		gererCommandes.addActionListener(e -> {
			refGererCommandes();
		});

		// lister
		listerClients.addActionListener(e -> {
			refListerClients();
		});
		listerProduits.addActionListener(e -> {
			refListerProduits();
		});
		listerCommandes.addActionListener(e -> {
			refListerCommandes();
		});

		// statistiques et fermeture
		statCA.addActionListener(e -> {
			refStat();
		});
		quit.addActionListener(e -> {
			jf.dispose();
		});

		// Paramètres sur JFrame visible et fermeture
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// reflexe gerer Client
	public void refGererClients() {

		JDialogGestion ecranGestion = null;
		try {
			ecranGestion = new JDialogGestion("Clients");

		} catch (HeadlessException e) {
		} catch (IOException e) {
			JDialogError ecranErreur = new JDialogError();
			ecranErreur.setVisible(true);
		}
		ecranGestion.setVisible(true);
	}

	public void refGererProduits() {

		JDialogGestion ecranGestion = null;
		try {
			ecranGestion = new JDialogGestion("Produits");

		} catch (HeadlessException e) {
		} catch (IOException e) {
			JDialogError ecranErreur = new JDialogError();
			ecranErreur.setVisible(true);
		}
		ecranGestion.setVisible(true);
	}

	public void refGererCommandes() {

		JDialogGestion ecranGestion = null;
		try {
			ecranGestion = new JDialogGestion("Commandes");

		} catch (HeadlessException e) {
		} catch (IOException e) {
			JDialogError ecranErreur = new JDialogError();
			ecranErreur.setVisible(true);
		}
		ecranGestion.setVisible(true);
	}

	}

	public void refListerClients() {
		ListIHM listerClient = new ListIHM("Clients");
	}

	public void refListerProduits() {
		ListIHM listerClient = new ListIHM("Produits");
	}

	public void refListerCommandes() {
		ListIHM listerClient = new ListIHM("Commandes");
	}

	public void refStat() {
		StatistiquesIHM stat = new StatistiquesIHM();
	}
}
