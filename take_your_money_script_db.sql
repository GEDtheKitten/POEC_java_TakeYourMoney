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
   client_anonymise BOOLEAN  
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
   qte_produit DOUBLE,
   PRIMARY KEY(produit_ID, commande_ID),
   FOREIGN KEY FK_Produit_Commande (commande_ID) REFERENCES Commandes (commande_ID),
   FOREIGN KEY FK_Commande_Produit (produit_ID) REFERENCES Produits (produit_ID)   
)ENGINE=InnoDB;


	-- Reemplissage des table --

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKININ', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FREYA', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKI', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FREY', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAK', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FRE', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BA', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FR', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('B', 'Mikhail', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('F', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKININ', 'Mikh', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FREYA', 'chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKININ', 'Mik', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FREYA', 'Le', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKININ', 'Mi', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FREYA', 'L', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKININ', 'M', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FREYA', 'L', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAKIN', 'M', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FRE', 'L', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('BAK', 'Mikha', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('FRE', 'Le ch', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('B', 'Mik', 'rue anar', '', 33000, 'Bordeaux', false);
INSERT INTO Clients(client_nom, client_prenom, client_adresse1, client_adresse2, client_cp, client_ville, client_anonymise)
VALUES ('F', 'Le', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

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

