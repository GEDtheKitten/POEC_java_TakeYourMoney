
USE take_your_money;
SET SQL_SAFE_UPDATES=0;

-- test de la procedure P_ajouter_client
CALL P_ajouter_client ('FREYA', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);

-- test de la procedure P_ajouter_produit
CALL P_ajouter_produit ('le carton magique', false);

-- test de la procedure P_supprimer_client
CALL P_supprimer_client ('FREYA', 'Le chat');

-- test de la procedure P_supprimer_produit
CALL P_supprimer_produit ('le carton magique');

-- test de la procedure P_lister_client
CALL P_lister_client ();

-- test de la procedure P_lister_client
CALL P_lister_produits ();