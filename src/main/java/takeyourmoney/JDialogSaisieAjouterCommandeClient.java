package takeyourmoney;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public JDialogSaisieAjouterCommandeClient(Connection connTakeYourMoney) throws SQLException {
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

        Object[] liste;

        CallableStatement cs_clients = this.conTYM.prepareCall("{call P_lister_client(?)}");
        cs_clients.registerOutParameter(1, java.sql.Types.VARCHAR);
        ResultSet rs_clients = cs_clients.executeQuery();
        while (rs_clients.next()) {
            System.out.println(rs_clients.getString("clients"));
        }

        liste = new String[]{"Texte", "Texte"// IMPORTER NOMS CLIENTS PAR ORDRE ALPHABETIQUE -- Utiliser le nom de la
        // table "Clients" !!!
        // ******************************************************

        };

        JComboBox listeDeroulanteClients = new JComboBox(liste);
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
            }
        });

        btnAnnuler.addActionListener(e -> {
            dispose();
        });

        return panel;
    }

    private void constructJDialog() throws SQLException {
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
