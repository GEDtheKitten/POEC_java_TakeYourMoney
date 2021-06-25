package ProjetTakeYourMoney;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class VerificationSaisie {

	// Vérifier si non vide
	public static boolean testerSiVide(String saisie) {
		if (saisie.length() >= 1) {
			return true;
		} else {
			return false;
		}
	}

	// Vérifier si 10 chiffres (téléphone)

	public static boolean testerNumeroTel(String saisie) {
		Pattern pattern = Pattern.compile(
				"\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(saisie);
		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	// Vérifier si 5 chiffres (CP) (regex)

	public static boolean testerCodePostal(String saisie) {
		Pattern pattern = Pattern.compile("^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(saisie);
		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}

	}

	// Vérifier si pas de chiffres dans la chaine de caractères (nom, prénom, ville)

	public static boolean testerSiCaracteres(String saisie) {
		for (int i = 0; i < saisie.length(); i++) {
			if (Character.isDigit(saisie.charAt(i)) == true) {
				return false;
			}
		}
		return true;
	}

	// Vérifier si toutes les JTextField ont été renseignés

	public static boolean testerSiLesSixJTextFieldsSontRemplis(JTextField field1, JTextField field2, JTextField field3,
			JTextField field4, JTextField field5, JTextField field6) {
		if (field1.getText().length() < 1) {
			return false;
		} else if (field2.getText().length() < 1) {
			return false;
		} else if (field3.getText().length() < 1) {
			return false;
		} else if (field4.getText().length() < 1) {
			return false;
		} else if (field5.getText().length() < 1) {
			return false;
		} else if (field6.getText().length() < 1) {
			return false;
		}
		return true;
	}
}
