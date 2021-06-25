package ProjetTakeYourMoney;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class ImportSQL {

	/**
	 * Méthodes pour créer un client
	 * 
	 * @param sql
	 * @param connexion
	 * @param nomTable
	 * @throws IOException
	 * @throws SQLException
	 */

	public static void creerClient(String sql, Connection connexion, String nomTable) throws IOException, SQLException {
		// Insérer une ligne dans une table

		String attribut1 = null;
		String attribut2 = null;
		String attribut3 = null;
		String attribut4 = null;
		String attribut5 = null;
		String attribut6 = null;

		String saisie1 = null;
		String saisie2 = null;
		String saisie3 = null;
		String saisie4 = null;
		String saisie5 = null;
		String saisie6 = null;

		System.out.print("Insérer une information dans une table SQL");
		System.in.read();

		String appelTable = "INSERT INTO " + nomTable + " (" + attribut1 + ", " + attribut2 + ", " + attribut3 + ", "
				+ attribut4 + ", " + attribut5 + ", " + attribut6 + ") \").append(\"VALUES (?, ?,?,?,?,?);";
		sql = new StringBuilder().append(appelTable).toString();
		try (PreparedStatement statement = connexion.prepareStatement(sql)) {
			statement.setString(1, saisie1);
			statement.setString(2, saisie2);
			statement.setString(2, saisie3);
			statement.setString(2, saisie4);
			statement.setString(2, saisie5);
			statement.setString(2, saisie6);
			int ligneAjoutee = statement.executeUpdate();
			System.out.println(ligneAjoutee + " item ajouté.");
		}
	}

	/**
	 * Méthode pour mettre à jour les données
	 * 
	 * @param sql
	 * @param connexion
	 * @param nomTable
	 * @throws IOException
	 * @throws SQLException
	 */

	public static void mettreAJourData(String sql, Connection connexion, String nomTable)
			throws IOException, SQLException {
		// MiseAJour DATA
		String valeurAttributRef = null;
		String nomAttributRef = null;
		String nomAttributModifie = null;
		String valeurAttributModifie = null;
		System.out.print("Mise à jour de " + nomAttributModifie + ".");
		System.in.read();
		sql = "UPDATE " + nomTable + " SET " + nomAttributModifie + " = " + valeurAttributModifie + " WHERE  "
				+ nomAttributRef + " = ?";
		try (PreparedStatement statement = connexion.prepareStatement(sql)) {
			statement.setString(1, valeurAttributRef);
			int rowsAffected = statement.executeUpdate();
			System.out.println(rowsAffected + " row(s) updated");
		}
	}

	/**
	 * Méthode pour désactiver un produit s'il a déjà commandé
	 * 
	 * @param sql
	 * @param connexion
	 * @param nomTable
	 * @throws IOException
	 * @throws SQLException
	 */

	public static void desactiverProduit(String sql, Connection connexion, String nomTable)
			throws IOException, SQLException {

		// DESACTIVER - SI produit a déjà été commandé
		String valeurProduitADesactiver = null; // A DEFINIR PAR L'UTILISATEUR
		String attributProduitADesactiver = "Produits";
		String produitAttributDesactivation = "produit_est_desactive"; // METTRE ATTRIBUT BOOLEAN PPRODUIT
		String estDesactive = "True"; // Par défaut False
		System.out.print("Désactivation de " + valeurProduitADesactiver + ".");
		System.in.read();
		sql = "UPDATE " + nomTable + " SET " + produitAttributDesactivation + " = " + estDesactive + " WHERE  "
				+ attributProduitADesactiver + " = ?";
		try (PreparedStatement statement = connexion.prepareStatement(sql)) {
			statement.setString(1, valeurProduitADesactiver);
			int ligneDesactivee = statement.executeUpdate();
			System.out.println(ligneDesactivee + " ligne(s) désactivée(s)");
		}
	}

	/**
	 * Anonymiser un client s'il a déjà commandé
	 * 
	 * @param sql
	 * @param connexion
	 * @param nomTable
	 * @throws IOException
	 * @throws SQLException
	 */

	public static void anonymiserClient(String sql, Connection connexion, String nomTable)
			throws IOException, SQLException {
		// DESACTIVER - SI Client a déjà commandé
		String valeurClientADesactiver = null;
		String attributClientADesactiver = null;

		String clientAttributDesactivation = "client_est_anonymise";
		String estAnonymise = "True"; // Par défaut False

		String clientNom = "client_nom";
		String clientPrenom = "client_prenom";
		String clientAdresse1 = "client_adresse1";
		String clientAdresse2 = "client_adresse2";
		String clientCodePostal = "client_cp";
		String clientVille = "client_ville";
		String clientTelephone = "client_telephone";

		String nom = generateRandomText(10);
		String prenom = generateRandomText(10);
		String adresse1 = generateRandomText(10);
		String adresse2 = generateRandomText(10);
		String codePostal = generateRandomNumber(5);
		String telephone = generateRandomNumber(10);
		String ville = generateRandomText(15);

		System.out.print("Désactivation de " + valeurClientADesactiver + ".");
		System.in.read();
		sql = "UPDATE " + nomTable + " SET " + clientAttributDesactivation + " = " + estAnonymise + ", " + clientNom
				+ " = " + nom + ", " + clientPrenom + " = " + prenom + ", " + clientAdresse1 + " = " + adresse1 + ", "
				+ clientAdresse2 + " = " + adresse2 + ", " + clientCodePostal + " = " + codePostal + ", " + clientVille
				+ " = " + ville + ", " + clientTelephone + " = " + telephone + " WHERE  " + attributClientADesactiver
				+ " = ? ";
		try (PreparedStatement statement = connexion.prepareStatement(sql)) {
			statement.setString(1, valeurClientADesactiver);
			int ligneDesactivee = statement.executeUpdate();
			System.out.println(ligneDesactivee + " ligne(s) anonymisée(s)");
		}

	}

	/**
	 * Supprimer un client ou un produit si pas concerné par une commande
	 * 
	 * @param sql
	 * @param connexion
	 * @param nomTable
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void supprimerData(String sql, Connection connexion, String nomTable)
			throws IOException, SQLException {
		String valeurAttributRefSupprime = null;
		String nomAttributSupprime = null;
		System.out.print("Suppression des données relatives au " + nomAttributSupprime + " appelé "
				+ valeurAttributRefSupprime + ".");
		System.in.read();
		sql = "DELETE FROM " + nomTable + " WHERE " + nomAttributSupprime + " = ?;";
		try (PreparedStatement statement = connexion.prepareStatement(sql)) {
			statement.setString(1, valeurAttributRefSupprime);
			int ligneSupprimee = statement.executeUpdate();
			System.out.println(ligneSupprimee + " ligne(s) supprimées(s)");
		}
	}

	/**
	 * Méthode pour lire une donnée
	 * 
	 * @param sql
	 * @param connexion
	 * @param nomTable
	 * @throws IOException
	 * @throws SQLException
	 */

	public static void lireData(String sql, Connection connexion, String nomTable) throws IOException, SQLException {
		System.out.print("Reading data from table, press ENTER to continue...");
		System.in.read();
		sql = "SELECT Id, Name, Location FROM Employees;";
		try (Statement statement = connexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String url = "addressdelaDB"; // sqlserver://localhost:1433
		String dBName = "nomBaseDonnees";
		String username = "username";
		String password = "password";

		System.out.println("Connexion à la base de données SQL.");

		String connexionUrl = "\"jdbc:" + url + ";databaseName=" + dBName + ";user=" + username + ";password="
				+ password + "\"";

		try {
			// Chargement du SQL Server JDBC driver
			System.out.print("Connexion au SQL Server ... ");
			try (Connection connexion = DriverManager.getConnection(connexionUrl)) {
				System.out.println("Connexion établie.");

				// Créer la base de données
				System.out.print("Suppression et création de la base 'take_your_money' en cours.");
				String sql = "DROP DATABASE IF EXISTS [take_your_money]; CREATE DATABASE [take_your_money]";
				try (Statement statement = connexion.createStatement()) {
					statement.executeUpdate(sql);
					System.out.println("La base 'take_your_money' a été créée.");
				}

				// Saisir nom de la table
				String nomTable = null;

				// APPEL DES FONCTIONS

			}
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
	}

	/**
	 * Méthode pour générer un nombre aléatoire
	 * 
	 * @param numbers
	 * @return
	 */

	private static String generateRandomNumber(int numbers) { // 5 pour le CP, 10 pour le numéro de tel
		String chiffresARandomiser = "123456789";
		Random rand = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < numbers; i++) {
			int randIndex = rand.nextInt(chiffresARandomiser.length());
			res.append(chiffresARandomiser.charAt(randIndex));
		}
		return res.toString();
	}

	/**
	 * Méthode pour générer une chaine de caractères aléatoires
	 * 
	 * @param numbers
	 * @return
	 */

	private static String generateRandomText(int numbers) { // Randomiser un nom
		String lettresARandomiser = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < numbers; i++) {
			int randIndex = rand.nextInt(lettresARandomiser.length());
			res.append(lettresARandomiser.charAt(randIndex));
		}
		return res.toString();
	}
}
