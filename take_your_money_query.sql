
USE take_your_money;

-- lister les clients 
SELECT CONCAT(client_nom, ' ', client_prenom) AS Clients
FROM Clients;

-- lister les produits 
SELECT produit_designation AS Produits
FROM Produits;

-- lister les commandes  
SELECT CONCAT(client_nom, ' ', client_prenom) AS Commandes
FROM Clients;

