# JEE-Spring-MVC-TP3-Hospital

### Création de l'entité et configuration JPA
* Définition de l'entité Patient

* L'ajout des annotations JPA (@Entity, @Data, @NoArgsConstructor, @AllArgsConstructor, @Builder).
Configuration de JPA et H2

* Configurez la base de données H2 dans le fichier application.yml en spécifiant l'URL.

Accédez à la console H2 via l'URL fournie : http://localhost:8080/h2-console

![db-screen.png](src/main/resources/assets-screen/db-screen.png)

### Création du PatientsController et de la vue patient.html

* Création du contrôleur PatientsController

* Création de la vue patient.html

* Utilisation de Thymeleaf (ou tout autre moteur de template) pour intégrer dynamiquement les données.

Testez l'affichage des patients dans la vue :
![controller-view-screen.png](src/main/resources/assets-screen/controller-view-screen.png)
