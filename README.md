# Modifications

## Python

* ### 1

`
if (texte == None or texte.strip() == ""):
        return None
`  
Correspond à l'exigence : *Une chaîne vide ou ne contenant que des espaces -> None*

Ensuite on sépare les minutes des secondes et millisecondes :
`texte_unites = texte.split(":")`  

Enfin, on retourne la somme des minutes convertient en secondes et des secondes et millisecondes :  
`return  round((float(texte_unites[0]) * 60) + float(texte_unites[1] ), 3)`

* ### 2

On ouvre le fichier en lecture, on stocke le contenu du fichier sous forme d'un DictReader en utilisant le point virgule pour séparer les éléments.  
On va ensuite parcourir ligne par ligne Pour chaque ligne, on assigne O et None à position et temps si le statut est abandon :  
*position : l'entier du CSV, ou 0 si le statut est ABANDON  
temps_tour : converti avec temps_en_secondes (None si absent)*  
On va assigner les valeurs pour toutes les autres catégories et les ajouter en tant que dictionnaire dans la liste

* ### 3

On ouvre le fichier en écriture  et on fixe le newline à vide car la methode writerow ajoute un \n.  
On initialise ensuite le writer et on lui met le delimiter comme demander.
On écrit la ligne d'intitulé puis on va parcourir chaque dictionnaires de la liste et recuperer les valeurs pour les écrire dans le fichier.

## Java

* ### 1

On utilise un switch pour assigner les points en fonction des positions

* ### 2

On crée une hashmap pour faire correspondre les resultats aux pilotes.
On commence par parcourir chaque ligne, si on a pas encore ajouté un pilote à la hashmap, on l'ajoute avec son nom et celui de son écurie.  
On ajoute ensuite les points correspondants à la position de la ligne au resultat du pilote, on peut ensuite incrémenter le compteur de victoire ou de deuxieme si il a une de ces deux positions.
On copie ensuite le contenue de la hashmap dans une liste pour pouvoir la trier. On doit comparer sur plusieurs criteres comme demandé dans l'enoncé, enfin on retourne la liste.

* ### 3

Extremement similaire à la precedente.

* ### 4

On initialise deux variable une somme pour la moyenne et le nombre de courses prises en comte.
On parcourt chaque course en ne prenant en compte que celle ou le nom du pilote correspond à celui qu'on veut et il a finit la course, on ajoute sa position à la somme et on incrémente le comteur.
On va ensuite renvoyer la moyenne arrondi à deux decimales ou un 0 pour eviter une erreur si aucune course n'a ete prise en compte.

## JavaScript

* ### 1

On trie la liste en se basant sur le nombre de points et si le nombre de point est equivalent, sur les victoires. On utilise toSorted pour ne pas affecter la liste d'origine.

* ### 2

On vide le corps pour reinitialiser, ensuite on parcourt la liste, pour chaque ligne, on crée un nouveau tr, on met le dataset, on recupere les valeurs depuis la liste. On va ensuite parcourir les valeurs qu'on vient de recupérer et les assigner a des td qu'on crée puis les ajouter aux tr.
Enfin on ajoute chaque ligne au corps.

* ### 3