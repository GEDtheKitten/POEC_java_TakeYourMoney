package takeyourmoney;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JDialogSaisieAjouterCommandeClient extends JDialog {

    private final Connection conTYM;

    public JDialogSaisieAjouterCommandeClient(Connection connTakeYourMoney) throws IOException, SQLException {
        super();
        this.conTYM = connTakeYourMoney;
        constructJDialog();
    }

    private JPanel construirePanelClient() throws SQLException {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(Color.WHITE);

        JLabel titreConsigne = new JLabel("Sélectionner le client :", SwingConstants.LEFT);
        panel.add(titreConsigne);

        JPanel panelListeDeroulanteClients = new JPanel();
        panelListeDeroulanteClients.setBackground(Color.white);

        // exctraction des donnees et insertion dans un ArrayList
        ArrayList<String> liste = new ArrayList();
        DataTables dat = new DataTables(this.conTYM, "Clients");
        dat.getDataFromRequest("call P_lister_client();");

        // insertion des donne dans jcombo
        for (int i = 0; i < dat.nbLignes; i++) {
            liste.add(dat.getData()[i][0].toString());
        }

        JComboBox listeDeroulante = new JComboBox(liste.toArray());

        // parametre jcombo
        JComboBox listeDeroulanteClients = new JComboBox(liste.toArray());
        listeDeroulanteClients.setPreferredSize(new Dimension(350, 30));
        panelListeDeroulanteClients.add(listeDeroulanteClients);
        panel.add(panelListeDeroulanteClients);

        // Ajout des boutons Continuer et Annuler
        JPanel panelBtnActions = new JPanel();
        panelBtnActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBtnActions.setBackground(Color.WHITE);

        JPanel panelBtnContinuer = new JPanel();
        panelBtnContinuer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBtnContinuer.setBackground(Color.WHITE);

        JButton btnContinuer = new JButton("Continuer");
        panelBtnContinuer.add(btnContinuer);

        JPanel panelBtnAnnuler = new JPanel();
        panelBtnAnnuler.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBtnAnnuler.setBackground(Color.WHITE);

        JButton btnAnnuler = new JButton("Annuler");
        panelBtnAnnuler.add(btnAnnuler);

        panelBtnActions.add(panelBtnAnnuler);
        panelBtnActions.add(panelBtnContinuer);
        panel.add(panelBtnActions);

        // DEFINIR LES ACTIONS
        btnContinuer.addActionListener(e -> {

            int confirmation = JOptionPane.showOptionDialog(null,
                    "Êtes-vous sûr(e) de vouloir créer une commande pour ce client ?", "Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirmation == JOptionPane.YES_OPTION) {
                String clientSelectionne = (listeDeroulanteClients.getSelectedItem()).toString();

                JDialogSaisieAjouterCommande ajouterCommande = null;
                try {
                    ajouterCommande = new JDialogSaisieAjouterCommande(this.conTYM, clientSelectionne);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ajouterCommande.setModal(true);
                ajouterCommande.setVisible(true);
            }
        });

        btnAnnuler.addActionListener(e -> {
            dispose();
        });

        return panel;
    }

    private void constructJDialog() throws IOException, SQLException {
        setSize(400, 200);
        setTitle("Selectionner un client");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);

        setContentPane(construirePanelClient());
        getContentPane().setBackground(Color.WHITE);

    }

}
