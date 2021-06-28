
  

USE take_your_money;

-- a implementer 

	-- rajouter un parametre de sortie pour tester le resultat 
	-- rajouter une pajination pour les resultats de sorties  -- voir limit 

	-- trouver des rejex pour tester les entrees


DROP PROCEDURE IF EXISTS P_lister_client;
DROP PROCEDURE IF EXISTS P_lister_produits;
DROP PROCEDURE IF EXISTS P_get_client;
DROP PROCEDURE IF EXISTS P_get_produit;
DROP PROCEDURE IF EXISTS P_ajouter_client;
DROP PROCEDURE IF EXISTS P_ajouter_produit;
DROP PROCEDURE IF EXISTS P_modifier_client;
DROP PROCEDURE IF EXISTS P_modifier_produit;
DROP PROCEDURE IF EXISTS P_modifier_prix_produit;
DROP PROCEDURE IF EXISTS P_supprimer_client;
DROP PROCEDURE IF EXISTS P_supprimer_produit;
DROP PROCEDURE IF EXISTS P_produits_deja_achete;

DROP PROCEDURE IF EXISTS P_produits_plus_vendus;
DROP PROCEDURE IF EXISTS P_produits_moins_vendus;
DROP PROCEDURE IF EXISTS P_produits_jamais_vendus;

DROP PROCEDURE IF EXISTS P_CA_total;
-- DROP PROCEDURE IF EXISTS P_CA_moyenne_annuelle;
-- DROP PROCEDURE IF EXISTS P_CA_moyenne_mensuelle;
-- DROP PROCEDURE IF EXISTS P_CA_par_ans;
-- DROP PROCEDURE IF EXISTS P_CA_par_mois;


-- DROP PROCEDURE IF EXISTS P_CA_moyenne_mensuelle_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_moyenne_annuelle_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_par_mois_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_par_ans_par_client;
-- DROP PROCEDURE IF EXISTS P_CA_total_par_client;


DELIMITER //

-- Procedure - lister les clients 
CREATE PROCEDURE P_lister_client ()
BEGIN
	SELECT CONCAT(client_nom, ' ', client_prenom) AS Clients
	FROM Clients;
END //


-- Procedure - lister les produits 
CREATE PROCEDURE P_lister_produits ()
BEGIN
	-- SELECT produit_designation AS Produit, prix_HT, prix_date_debut 
    SELECT *
	FROM Produits AS p
    LEFT JOIN Prix AS px on p.produit_ID = px.produit_ID
    WHERE prix_date_fin IS NULL;
END //


-- Procedure - selectionner un client par nom / prenom 
CREATE PROCEDURE P_get_client (IN client_nom VARCHAR(50), IN client_prenom VARCHAR(50))
BEGIN
	SELECT * 
	FROM Clients AS c
    WHERE c.client_nom = client_nom AND c.client_prenom = client_prenom;
END //


-- Procedure - selectionner un produits par designation
CREATE PROCEDURE P_get_produit (IN produit_designation VARCHAR(50))
BEGIN
	SELECT * 
	FROM Produits AS p
    JOIN Prix AS px ON p.produit_ID = px.produit_ID
    WHERE p.produit_designation = produit_designation AND prix_date_fin IS NULL;
END //


-- Procedure - ajouter un client
CREATE PROCEDURE P_ajouter_client (IN client_nom VARCHAR(50), IN client_prenom VARCHAR(50), IN client_adresse1 VARCHAR(50),
								   IN client_adresse2 VARCHAR(50), IN client_cp VARCHAR(5), IN client_ville VARCHAR(30), IN client_anonymise BOOLEAN)
BEGIN
    INSERT INTO Clients (client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
	VALUES (client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise);
END //


-- Procedure - ajouter un produit
CREATE PROCEDURE P_ajouter_produit (IN produit_designation VARCHAR(50), IN produit_desactive BOOLEAN, 
									IN prix_date_debut DATE, prix_HT DECIMAL(15,2))
BEGIN
    INSERT INTO Produits (produit_designation, produit_desactive) VALUES (produit_designation, produit_desactive);
    INSERT INTO Prix (prix_date_debut, prix_HT, produit_ID) VALUES (prix_date_debut, prix_HT, LAST_INSERT_ID());
END //

-- Procedure - modifier un client
CREATE PROCEDURE P_modifier_client (IN c_ID INT, IN c_nom VARCHAR(50), IN c_prenom VARCHAR(50), IN c_adresse1 VARCHAR(50),
								    IN c_adresse2 VARCHAR(50), IN c_cp VARCHAR(5), IN c_ville VARCHAR(30), IN c_anonymise BOOLEAN)
BEGIN
    UPDATE Clients 
	SET client_nom = c_nom, client_prenom = c_prenom, client_adresse1 = c_adresse1, client_adresse2 = c_adresse2,
    client_cp = c_cp, client_ville = c_ville, client_anonymise = c_anonymise
    WHERE client_ID = c_ID;
END //


-- Procedure - modifier un produit
CREATE PROCEDURE P_modifier_produit (IN p_ID INT, IN p_designation VARCHAR(50), IN p_desactive BOOLEAN)
BEGIN
    UPDATE Produits
	SET produit_designation = p_designation, produit_desactive = p_desactive
    WHERE produit_ID = p_ID;
END //


-- Procedure - modifier le prix d'un produit
CREATE PROCEDURE P_modifier_prix_produit (IN p_ID INT, IN prix_date_debut DATE, prix_HT DECIMAL(15,2))
BEGIN
    UPDATE Prix AS p SET prix_date_fin = CURRENT_DATE() WHERE p.produit_ID = p_ID AND prix_date_fin IS NULL;
    INSERT INTO Prix (prix_date_debut, prix_HT, produit_ID) VALUES (CURRENT_DATE(), prix_HT, p_ID);
END //


-- Procedure - supprimer un client
CREATE PROCEDURE P_supprimer_client (IN c_ID INT)
BEGIN
    DELETE FROM Clients	WHERE client_ID = c_ID;
END //


-- Procedure - supprimer un produit
CREATE PROCEDURE P_supprimer_produit (IN p_ID INT)
BEGIN
    DELETE FROM Prix WHERE produit_ID = p_ID;
    DELETE FROM Produits WHERE produit_ID = p_ID;
END //


-- Procedure - verifier si un porduit appartient a une commande 
CREATE PROCEDURE P_produits_deja_achete (IN p_ID INT)
BEGIN
    SELECT * FROM Produits AS p
    JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NOT NULL AND p.produit_ID = p_ID
	ORDER BY commande_ID;
END //


-- Procedure - liste des produits les plus vendus  
CREATE PROCEDURE P_produits_plus_vendus ()
BEGIN
    SELECT * FROM Produits AS p
    JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NOT NULL
	GROUP BY p.produit_ID ORDER BY qte_produit DESC;
END //


-- Procedure - liste des produits les moins vendus  
CREATE PROCEDURE P_produits_moins_vendus ()
BEGIN
    SELECT * FROM Produits AS p
    JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NOT NULL
	GROUP BY p.produit_ID ORDER BY qte_produit;
END //


-- Procedure - liste des produits jamais vendus  
CREATE PROCEDURE P_produits_jamais_vendus ()
BEGIN
    SELECT * FROM Produits AS p
    LEFT JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NULL;
END //


-- Procedure - calcul le chiffre d'affaire total 
CREATE PROCEDURE P_CA_total ()
BEGIN
--     SELECT * FROM Produits AS p
--     LEFT JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
--     WHERE commande_ID IS NULL;
END //


DELIMITER ;

