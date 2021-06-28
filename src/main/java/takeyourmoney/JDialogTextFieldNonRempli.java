package takeyourmoney;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JDialogTextFieldNonRempli extends JDialog {

	public JDialogTextFieldNonRempli(String nomTextField) {
		super();
		constructJDialog(nomTextField);
	}

	private JPanel construirePanelTextFieldNonRempli(String nomTextField) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		JPanel panelTitre = new JPanel();
		panelTitre.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel titreConsigne = new JLabel("<html><br><center><b>" + nomTextField + " non renseigné(e)<br></html>");
		panelTitre.add(titreConsigne);
		panel.add(panelTitre);

		// Ajout du bouton OK

		JPanel panelBtnOK = new JPanel();
		panelBtnOK.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btnOK = new JButton("OK");
		btnOK.setHorizontalAlignment(SwingConstants.CENTER);
		panelBtnOK.add(btnOK);

		panel.add(panelBtnOK);

		btnOK.addActionListener(e -> {

			dispose();

		});

		return panel;
	}

	private void constructJDialog(String nomTextField) {
		setSize(300, 200);
		setTitle("Erreur 404");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // A REVERIFIER
		setModal(true);

		setContentPane(construirePanelTextFieldNonRempli(nomTextField));
		getContentPane().setBackground(Color.WHITE);

	}

}
