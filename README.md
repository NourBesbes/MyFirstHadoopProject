# MyFirstHadoopProject
# MapReduce en JAVA

Les champs du fichier log à traiter sont séparés par des tabulations et ont la forme suivante:
date   temps	magasin   produit   coût	paiement


# Activité 4
Le but de cette activite est de déterminer le total des ventes par magasin pour cela on développe :
 un Mapper afin d'extraire les couples (magasin,coût) 
 Un Reducer pour calculer le total des ventes pour chaque magasin  

# Activité 5
Le but de cette activite est de donner la liste des ventes par catégorie de produits pour cela on développe :
 un Mapper afin d'extraire les couples (produit,coût) 
 Un Reducer pour calculer le total des ventes pour chaque produit
# Activité 6
Le but de cette activite est de donner le montant de la vente le plus élevé pour chaque magasin pour cela on utilise :
 Le Mapper implémenté à l'activité 4
 Un Reducer pour déterminer le montant de la vente le plus élevé pour chaque magasin
# Activité 7
Le but de cette activite est de déterminer le nombre total des ventes et la valeur totale des ventes de tous magasins
confondus pour cela on utilise :
 Le Mapper qui aura pour résultat les couples ("Total",cout)
 Un Reducer pour calculer le nombre total des ventes et la somme des couts de tous les magasins le resultat est un couple ("Total",NombreVentes__TotalVente)


# Teste

##Tester en local 

1. Ajouter les jar suivants au projets : slf4j-nop httpclient jackson-core-asl jackson-mapper-asl

2. Dans l'onglet Arguments de la fenetre Run configuration spécifier les arguments (le fichier log et le repertoire du résultat) à utiliser lors de l'execution     

3. Aprés l'execution du programme le resultat sera stocké dans le fichier part-r-00000 sous le répertoire du résultat



##Tester sur HDFS 

1. Exporter le jar du projet JAVA 

2. Créer un répertoire pour stocker le fichier des données : hadoop fs -mkdir /input

3. Mettre le fichier en entrée sous le répertoire crée sur HDFS : hadoop fs –put [fichier des données] /input

hadoop fs -put purchases.txt input/

4. Executer la commande suivante: hadoop jar [jar du projet] [Nom du point d'entrée main dans le jar] [fichier des données] [répertoire du résultat]
hadoop jar Tp1-A5.jar StubDriver input/purchases.txt output

5. Visualiser le résulat dans le ficher part-r-00000 sous le répertoire du résultat
hadoop fs -cat output/part-r-00000
