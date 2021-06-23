
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
   commande_montant VARCHAR(50),
   commande_date DATE
)ENGINE=InnoDB;

CREATE TABLE Prix(
   prix_ID INT PRIMARY KEY AUTO_INCREMENT,
   prix_date DATE,
   prix_HT DECIMAL(15,2),
   produit_ID INT,
   FOREIGN KEY FK_Prix_Produits (produit_ID) REFERENCES Produits (produit_ID)
)ENGINE=InnoDB;

CREATE TABLE Clients_Commandes(
   client_ID INT,
   commande_ID INT,
   PRIMARY KEY(client_ID, commande_ID),
   FOREIGN KEY FK_Clients_Commandes (commande_ID) REFERENCES Commandes (commande_ID),
   FOREIGN KEY FK_Commandes_Clients (client_ID) REFERENCES Clients (client_ID)
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

INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Croquette pour chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Colier antispuce', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Arbre a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Voiture', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Peluche de chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Peluche de rat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Brosse a chat', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Litiere', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Pannier', false);
INSERT INTO Produits(produit_designation, produit_desactive) VALUES ('Balle rebondissante', false);



