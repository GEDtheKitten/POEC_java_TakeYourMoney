
USE take_your_money;

-- a implementer 
-- rajouter un parametre de sortie pour tester le resultat 
-- rajouter une pajination pour les resultats de sorties 

-- trouver des rejex pour tester les entrees


DROP PROCEDURE IF EXISTS P_ajouter_client;
DROP PROCEDURE IF EXISTS P_ajouter_produit;
DROP PROCEDURE IF EXISTS P_modifier_client;
-- DROP PROCEDURE IF EXISTS P_modifier_produit;
DROP PROCEDURE IF EXISTS P_supprimer_client;
DROP PROCEDURE IF EXISTS P_supprimer_produit;
DROP PROCEDURE IF EXISTS P_lister_client;
DROP PROCEDURE IF EXISTS P_lister_produits;
-- DROP PROCEDURE IF EXISTS P_produits_plus_vendus;
-- DROP PROCEDURE IF EXISTS P_produits_moins_vendus;
-- DROP PROCEDURE IF EXISTS P_produits_jamais_vendus;

-- DROP PROCEDURE IF EXISTS P_CA_moyenne_mensuelle;
-- DROP PROCEDURE IF EXISTS P_CA_moyenne_annuelle;
-- DROP PROCEDURE IF EXISTS P_CA_par_mois;
-- DROP PROCEDURE IF EXISTS P_CA_par_ans;
-- DROP PROCEDURE IF EXISTS P_CA_total;

-- DROP PROCEDURE IF EXISTS P_CA_moyenne_mensuelle_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_moyenne_annuelle_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_par_mois_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_par_ans_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_total_par_client;


DELIMITER //


-- Procedure - ajouter un client
CREATE PROCEDURE P_ajouter_client (IN client_nom VARCHAR(50), IN client_prenom VARCHAR(50), IN client_adresse1 VARCHAR(50),
								   IN client_adresse2 VARCHAR(50), IN client_cp VARCHAR(5), IN client_ville VARCHAR(30), IN client_anonymise BOOLEAN)
BEGIN
    INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
	VALUES (client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise);
END //


-- Procedure - ajouter un produit
CREATE PROCEDURE P_ajouter_produit (IN produit_designation VARCHAR(50), IN produit_desactive BOOLEAN, 
									IN prix_date DATE, prix_HT DECIMAL(15,2))
BEGIN
    INSERT INTO Produits(produit_designation, produit_desactive) VALUES (produit_designation, produit_desactive);
    INSERT INTO Prix (prix_date, prix_HT, produit_ID) VALUES (prix_date, prix_HT, LAST_INSERT_ID());
END //

-- Procedure - modifier un client
CREATE PROCEDURE P_modifier_client (IN client_ID INT, IN client_nom VARCHAR(50), IN client_prenom VARCHAR(50), IN client_adresse1 VARCHAR(50),
								    IN client_adresse2 VARCHAR(50), IN client_cp VARCHAR(5), IN client_ville VARCHAR(30), IN client_anonymise BOOLEAN)
BEGIN
    UPDATE Clients
	SET client_nom = client_nom, client_prenom = client_prenom, client_adresse1 = client_adresse1, client_adresse2 = client_adresse2,
    client_cp = client_cp, client_ville = client_ville, client_anonymise = client_anonymise
    WHERE client_ID = client_ID;
END //


-- Procedure - supprimer un client
CREATE PROCEDURE P_supprimer_client (IN c_nom VARCHAR(50), IN c_prenom VARCHAR(50))
BEGIN
    DELETE FROM Clients	WHERE client_nom = c_nom AND client_prenom = c_prenom;
END //


-- Procedure - supprimer un produit
CREATE PROCEDURE P_supprimer_produit (IN p_designation VARCHAR(50))
BEGIN
    DELETE FROM Produits WHERE produit_designation = p_designation;
END //


-- Procedure - lister les clients 
CREATE PROCEDURE P_lister_client ()
BEGIN
	SELECT CONCAT(client_nom, ' ', client_prenom) AS Clients
	FROM Clients;
END //


-- Procedure - lister les produits 
CREATE PROCEDURE P_lister_produits ()
BEGIN
	SELECT produit_designation, prix_HT, prix_date 
	FROM Produits AS p
    JOIN Prix AS px on p.produit_ID = px.produit_ID;
END //


DELIMITER ;



