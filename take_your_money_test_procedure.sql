
USE take_your_money;
SET SQL_SAFE_UPDATES=0;

CALL P_ajouter_client ('FREYA', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', false);
CALL P_ajouter_produit ('le carton magique', false, STR_TO_DATE('1/04/2018', '%d/%m/%Y'), 55.9);

CALL P_get_client ('FREYA', 'Le chat');
CALL P_get_produit ('le carton magique');

-- CALL P_supprimer_client ('FREYA', 'Le chat');
-- CALL P_supprimer_produit ('le carton magique');

CALL P_lister_client ();
CALL P_lister_produits ();