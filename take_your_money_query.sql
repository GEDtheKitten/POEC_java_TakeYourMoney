
USE take_your_money;

-- a implementer 
-- rajouter un parametre de sortie pour tester le resultat 
-- rajouter une pajination pour les resultats de sorties 


DROP PROCEDURE IF EXISTS P_ajouter_client;
DROP PROCEDURE IF EXISTS P_ajouter_produit;
DROP PROCEDURE IF EXISTS P_supprimer_client;
DROP PROCEDURE IF EXISTS P_supprimer_produit;
DROP PROCEDURE IF EXISTS P_lister_client;
DROP PROCEDURE IF EXISTS P_lister_produits;


DELIMITER //


-- Procedure - ajouter un client
CREATE PROCEDURE P_ajouter_client (IN client_nom VARCHAR(50), IN client_prenom VARCHAR(50), IN client_adresse1 VARCHAR(50),
								   IN client_adresse2 VARCHAR(50), IN client_cp VARCHAR(5), IN client_ville VARCHAR(30),IN client_anonymise BOOLEAN)
BEGIN
    INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
	VALUES (client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise);
END //


-- Procedure - ajouter un produit
CREATE PROCEDURE P_ajouter_produit (IN produit_designation VARCHAR(50), IN produit_desactive BOOLEAN)
BEGIN
    INSERT INTO Produits(produit_designation, produit_desactive) VALUES (produit_designation, produit_desactive);
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
	SELECT produit_designation AS Produits
	FROM Produits;
END //


DELIMITER ;



