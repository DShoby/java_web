##  PROJET JAVA - WEB  ##

### SUJET 

**But : développer en Java une application qui intègre une base de données et qui est accessible via le
Web.**

Travail en binôme.

Sujet : libre mais architecture imposée

**Architecture :**

-  Une base de données (NoSQL de préférence à SQL)
- Une couche domain composée de classes métiers (structure de données)
- Une couche service composée de classes (là ou sont codés les algorithmes qui
manipulent les données de la couche domain
- Une couche Web (un web service Rest)
- La couche présentation est optionnelle :
	-  Elle pourra être programmée avec des technologies comme Angular, React
	- Une utilisation de l’application via un plug-in comme Rest client est possible


**Découpage en itérations :**

- Jalon 1 : la couche domain :
	-  Un diagramme de classes UML
	-  Le code
- Jalon 2 : la couche service
- Jalon 3 : la couche de sauvegarde dans la base de données
- Jalon 4 : la couche Web et démonstration finale


**Calendrier :**

- Séances encadrées :
	- 31/1
	- 28/2
	- Deux autres séances à planifier jusque la fin de l’année
- Il y a des séances en autonomie

### LANCEMENT DU PROJET


- Installer maven via l'adresse  : https://maven.apache.org/download.cgi


- Installer MongoDB :

		Pour windows : https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/
		Pour linux : https://docs.mongodb.com/manual/administration/install-on-linux/
Lancer le service MongoDB

- Récupérer le projet sur la branche MASTER et l'importer sous INTELLIJ (l'importer sous le modèle externe MAVEN). 

- Une fois sous intellij effectuer un maven CLEAN INSTALL sur le module ECOM(root)
	- Si sous invite de commandes, en se positionnant dans le répertoire *ecom-maven*, effectuer la commande suivante :
		
			mvn clean install 
- Dans le module ecom-rest, sous le package *app*, lancer Application.java. (Le controller rest se trouve dans le même module sous le package éponyme.)

- Installer le plugin **POSTMAN** sous Google Chrome, puis effectuer les différents appels suivants : 

	- Récupérer tous les articles de la BDD (METHOD GET)
	
			http://localhost:8080/getAllArticles

	- Ajouter un article (METHOD POST)

			http://localhost:8080/addArticle

	Sous POSTMAN, sélectionner l'onglet BODY, choisir l'option RAW et remplacer la sélection *Text* par *Application/JSON*. Utiliser le fichier **jsonData.txt** pour saisir les données JSON correspondantes. 

	- Supprimer un article (METHOD DELETE) 

			http://localhost:8080/delArticle

	Sous POSTMAN, sélectionner l'onglet BODY, choisir l'option form-data et saisir la clé valeur "nameArt" - "labelDeL'Article" (ex : nameArt - montre). Utiliser le fichier **jsonData.txt** pour saisir les données JSON correspondantes. 

	- Update d'un article (METHOD POST) 

			http://localhost:8080/updateArticle

	Sous POSTMAN, sélectionner l'onglet BODY, choisir l'option RAW et remplacer la sélection *Text* par *Application/JSON*. Utiliser le fichier **jsonData.txt** pour saisir les données JSON correspondantes. 

Le fonctionnement est le même pour les catalogues, il suffit de remplacer les données et les urls ( ex : addArticle -> addCatalogue ; getAllArticles -> getAllCatalogues). 