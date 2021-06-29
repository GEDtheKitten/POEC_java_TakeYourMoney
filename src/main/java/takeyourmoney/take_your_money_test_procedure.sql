
USE take_your_money;
SET SQL_SAFE_UPDATES=0;

CALL P_ajouter_client ('FREYA 1', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);
CALL P_ajouter_produit ('le carton magique', false, STR_TO_DATE('03/04/2018', '%d/%m/%Y'), 50);
CALL P_ajouter_client ('FREYA 2', 'Le chat', 'rue du chat noir', 'Miaou', 33000, 'Bordeaux', 0504030201);
CALL P_ajouter_produit ('le carton magique', false, STR_TO_DATE('1/04/2018', '%d/%m/%Y'), 55.9);

CALL P_lister_client ();
CALL P_lister_produits ();

CALL P_supprimer_client ('4');
CALL P_supprimer_produit ('12');

CALL P_lister_client ();
CALL P_lister_produits ();

CALL P_modifier_client ('2', 'FREYA', 'Le chat', 'rue du chat blanc', '', 33300, 'Bordeaux', false);
CALL P_modifier_produit ('11', 'le super carton magique', false);
CALL P_modifier_prix_produit ('11', STR_TO_DATE('1/1/2020', '%d/%m/%Y'), 40);

CALL P_get_client ('FREYA', 'Le chat');
CALL P_get_produit ('le super carton magique');

CALL P_lister_produits ();

-- CALL P_produits_deja_achete (1);
-- CALL P_produits_deja_achete (7);

CALL P_produits_plus_vendus ();
CALL P_produits_moins_vendus ();
CALL P_produits_jamais_vendus ();