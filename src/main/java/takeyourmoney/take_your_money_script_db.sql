DROP DATABASE IF EXISTS take_your_money;

CREATE DATABASE take_your_money;
USE take_your_money;


	-- Creation des tables --

CREATE TABLE Clients(
   client_ID INT PRIMARY KEY AUTO_INCREMENT,
   client_nom VARCHAR(50),
   client_prenom VARCHAR(50),
   client_adresse1 VARCHAR(50),
   client_adresse2 VARCHAR(50),
   client_cp VARCHAR(5),
   client_ville VARCHAR(30),
   client_tel INT,
   client_anonymise BOOLEAN DEFAULT FALSE 
)ENGINE=InnoDB;

CREATE TABLE Produits(
   produit_ID INT PRIMARY KEY AUTO_INCREMENT,
   produit_designation VARCHAR(50),
   produit_desactive BOOLEAN
)ENGINE=InnoDB;

CREATE TABLE Commandes(
   commande_ID INT PRIMARY KEY AUTO_INCREMENT,
   -- commande_montant VARCHAR(50),
   commande_date DATE,
   client_ID INT,
   FOREIGN KEY FK_Commandes_Clients (client_ID) REFERENCES Clients (client_ID)
)ENGINE=InnoDB;

CREATE TABLE Prix(
   prix_ID INT PRIMARY KEY AUTO_INCREMENT,
   prix_date_debut DATE,
   prix_date_fin DATE DEFAULT NULL,
   prix_HT DECIMAL(15,2),
   produit_ID INT,
   FOREIGN KEY FK_Prix_Produits (produit_ID) REFERENCES Produits (produit_ID)
)ENGINE=InnoDB;

CREATE TABLE Produits_Commandes(
   produit_ID INT,
   commande_ID INT,
   qte_produit INT,
   PRIMARY KEY(produit_ID, commande_ID),
   FOREIGN KEY FK_Produit_Commande (commande_ID) REFERENCES Commandes (commande_ID),
   FOREIGN KEY FK_Commande_Produit (produit_ID) REFERENCES Produits (produit_ID)   
)ENGINE=InnoDB;


	-- Reemplissage des table --

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKININ', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FREYA', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKI', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FREY', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAK', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FRE', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BA', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FR', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('B', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('F', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKININ', 'Mikh', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FREYA', 'chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKININ', 'Mik', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FREYA', 'Le', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKININ', 'Mi', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FREYA', 'L', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKININ', 'M', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FREYA', 'L', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAKIN', 'M', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FRE', 'L', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('BAK', 'Mikha', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('FRE', 'Le ch', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('B', 'Mik', 'rue anar', '', 33000, 'Bordeaux', 0504030201);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
VALUES ('F', 'Le', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);

INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Croquette pour chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Collier antispuce', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Arbre a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Voiture', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Peluche de chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Peluche de rat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Brosse a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Litiere', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pannier', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Balle rebondissante', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Croq pour chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Coll antispuce', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Arb a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Voit', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pelu de chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pelu de rat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Bros a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Lit', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pan', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Balle', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Cro pour chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Co antispuce', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Ar a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Vo', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pe de chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pe de rat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Br a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Li', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pa', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Ba rebondissante', false);


INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 25.5, 1);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/02/2018', '%d/%m/%Y'), 17, 2);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/03/2018', '%d/%m/%Y'), 15900, 3);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/04/2018', '%d/%m/%Y'), 55.9, 4);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('23/05/2018', '%d/%m/%Y'), 20, 5);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 15, 6);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 14.9, 7);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 25.5, 8);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 20.5, 9);
INSERT INTO Prix(prix_date_debut, prix_HT, produit_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 5.99, 10);

INSERT INTO Commandes(commande_date, client_ID) VALUES (STR_TO_DATE('1/01/2018', '%d/%m/%Y'), 1);
INSERT INTO Commandes(commande_date, client_ID) VALUES (CURRENT_DATE(), 2);

INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (1, 1, 1);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (2, 1, 1);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (5, 1, 3);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (6, 1, 1);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (2, 2, 1);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (10, 2, 1);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (9, 2, 2);
INSERT INTO Produits_Commandes(produit_ID, commande_ID, qte_produit) VALUES (3, 2, 1);



    -- creation des procedures --

DROP PROCEDURE IF EXISTS P_lister_client;
DROP PROCEDURE IF EXISTS P_lister_produits;
DROP PROCEDURE IF EXISTS P_lister_commandes;
DROP PROCEDURE IF EXISTS P_num_commande;
DROP PROCEDURE IF EXISTS P_lister_produits_and_price;
DROP PROCEDURE IF EXISTS P_get_client;
DROP PROCEDURE IF EXISTS P_get_produit;
DROP PROCEDURE IF EXISTS P_ajouter_client;
DROP PROCEDURE IF EXISTS P_ajouter_produit;
DROP PROCEDURE IF EXISTS P_modifier_client;
DROP PROCEDURE IF EXISTS P_modifier_produit;
DROP PROCEDURE IF EXISTS P_desactiver_produit;
DROP PROCEDURE IF EXISTS P_modifier_prix_produit;
DROP PROCEDURE IF EXISTS P_supprimer_client;
DROP PROCEDURE IF EXISTS P_supprimer_client_par_nom;
DROP PROCEDURE IF EXISTS P_ID_produit;
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
-- CREATE PROCEDURE P_lister_client (OUT clients VARCHAR(50))
CREATE PROCEDURE P_lister_client ()
BEGIN
--     SELECT CONCAT(client_nom, ' ', client_prenom) AS clients
    SELECT client_nom AS clients
    FROM Clients
    ORDER BY client_nom;
END //


-- Procedure - lister les produits
CREATE PROCEDURE P_lister_produits ()
BEGIN
    SELECT produit_designation AS produits
    FROM Produits 
    ORDER BY produit_designation;
END //


-- Procedure - lister les produits
CREATE PROCEDURE P_lister_commandes ()
BEGIN
    SELECT commande_ID AS commandes
    FROM Commandes 
    ORDER BY commande_ID;
END //


-- Procedure - lister les commandes par ID / num commande
CREATE PROCEDURE P_num_commande (OUT num_commande INT)
BEGIN
    SELECT commande_ID AS num_commande
    FROM Commandes 
    ORDER BY commande_ID;
END //


-- Procedure - lister les produits avec le prix
CREATE PROCEDURE P_lister_produits_and_price ()
BEGIN
    SELECT produit_designation AS Produit, prix_HT, prix_date_debut 
--     SELECT *
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
                                   IN client_adresse2 VARCHAR(50), IN client_cp VARCHAR(5), IN client_ville VARCHAR(30),
                                   IN client_tel INT)
BEGIN
    INSERT INTO Clients (client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel)
	VALUES (client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_tel);
END //


-- Procedure - ajouter un produit
CREATE PROCEDURE P_ajouter_produit (IN produit_designation VARCHAR(50), IN produit_desactive BOOLEAN, 
                                    prix_HT DECIMAL(15,2))
BEGIN
    INSERT INTO Produits (produit_designation, produit_desactive) VALUES (produit_designation, produit_desactive);
    INSERT INTO Prix (prix_date_debut, prix_HT, produit_ID) VALUES (CURRENT_DATE(), prix_HT, LAST_INSERT_ID());
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


-- Procedure - modifier un produit
CREATE PROCEDURE P_desactiver_produit (IN p_designation VARCHAR(50))
BEGIN
    UPDATE Produits
	SET produit_desactive = true
    WHERE produit_designation = p_designation;
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


-- Procedure - supprimer un client
CREATE PROCEDURE P_supprimer_client_par_nom (IN c_nom INT)
BEGIN
    DELETE FROM Clients	WHERE client_nom = c_nom;
END //


-- Procedure - retourne ID du produit 
CREATE PROCEDURE P_ID_produit ( IN p_designation VARCHAR(50), OUT produit_ID INT)
BEGIN
    SELECT produit_ID AS produit_ID
    FROM Produits 
    WHERE produit_designation = p_designation;
END //


-- Procedure - supprimer un produit
CREATE PROCEDURE P_supprimer_produit (IN p_ID INT)
BEGIN
    DELETE FROM Prix WHERE produit_ID = p_ID;
    DELETE FROM Produits WHERE produit_ID = p_ID;
END //


-- Procedure - verifier si un porduit appartient a une commande 
-- CREATE PROCEDURE P_produits_deja_achete (IN p_ID INT)
CREATE PROCEDURE P_produits_deja_achete (IN produit_designation INT, OUT produit_designation VARCHAR(50))
BEGIN
    SELECT produit_designation FROM Produits AS p
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



    -- creation des Views --

-- View - liste des produits les plus vendus  
CREATE OR REPLACE VIEW V_produits_plus_vendus AS 
	SELECT p.produit_ID AS produit_ID, produit_designation, qte_produit
    FROM Produits AS p
    JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NOT NULL
	GROUP BY p.produit_ID ORDER BY qte_produit DESC;

-- View - liste des produits les moins vendus  
CREATE OR REPLACE VIEW V_produits_moins_vendus AS
    SELECT p.produit_ID AS produit_ID, produit_designation, qte_produit 
    FROM Produits AS p
    JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NOT NULL
	GROUP BY p.produit_ID ORDER BY qte_produit;

-- View - liste des produits jamais vendus  
CREATE OR REPLACE VIEW V_produits_jamais_vendus AS
    SELECT p.produit_ID AS produit_ID, produit_designation, qte_produit 
    FROM Produits AS p
    LEFT JOIN Produits_Commandes AS pc ON p.produit_ID = pc.produit_ID
    WHERE commande_ID IS NULL;



    -- creation de l'utilisateur --

DROP USER IF EXISTS 'atelierJava'@HOSTNAME;
CREATE USER 'atelierJava'@'localhost' IDENTIFIED BY 'atelierJava';
-- attribution des autorisations
GRANT ALL PRIVILEGES ON take_your_money.* To 'atelierJava'@'localhost';
GRANT SELECT ON mysql.proc TO 'atelierJava'@'localhost';
FLUSH PRIVILEGES;