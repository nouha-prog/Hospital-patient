# Gestion Hospitalière des Patients - Application Spring Boot

## Sommaire





- Présentation du projet



- Fonctionnalités principales



- Prérequis et installation



## Organisation du projet



- **Interfaces de l'application**



- **Ressources complémentaires**

## 📖 Présentation du projet

Cette application web, développée avec Spring Boot 3.4.3, offre une solution complète pour la gestion des patients dans un contexte hospitalier. Elle repose sur les technologies suivantes :





- Spring MVC : Gestion des contrôleurs et des vues.



- Thymeleaf : Création de pages HTML dynamiques.



- Spring Data JPA : Interaction simplifiée avec la base de données.



- H2 (en mémoire) ou MySQL : Options de base de données configurables via application.properties.



- Spring Security : Gestion sécurisée des authentifications et des rôles utilisateurs.



- Bootstrap & Webjars : Interface utilisateur moderne et responsive.

## 🚀 Fonctionnalités principales





## Gestion de l'authentification





- Page de connexion personnalisée (/login).



- Rôles utilisateurs : USER (utilisateur standard) et ADMIN (administrateur).



- Accès restreint selon les rôles (/user/** pour les utilisateurs, /admin/** pour les administrateurs).



- Redirection vers une page d'erreur en cas d'accès non autorisé (/notAuthorized).



- Gestion des patients (CRUD)





- Affichage des patients avec pagination.



- Recherche de patients par nom.



- Ajout, modification et suppression de patients.



- Confirmation de suppression via une fenêtre modale.



- Initialisation des données





- Génération automatique des données initiales (patients et utilisateurs) via CommandLineRunner.



- Améliorations de l'interface





- Utilisation de templates partagés avec Thymeleaf Layout Dialect.



- Interface responsive grâce à Bootstrap 5.



- Affichage de messages d'alerte après chaque opération.



- Barre de navigation dynamique affichant l'utilisateur connecté et les options adaptées à son rôle.

## 🔧 Prérequis et installation

- Prérequis





Java 17 ou supérieur.



Maven 3 ou supérieur.



MySQL .
# Étapes d'installation
### Étapes
1. **Cloner le dépôt**
   ```bash
   git clone https://github.com/nouha-prog/Hospital-patient.git
   cd Hospital-patient-main
   ```

2. **Configurer la base de données**
    - Par défaut, l’application utilise MySQL :
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/hopital?createDatabaseIfNotExist=true
      spring.datasource.username=root
      spring.datasource.password=
      ```
    - Pour utiliser H2 en mémoire, décommente :
      ```properties
      spring.datasource.url=jdbc:h2:mem:patients-db
      spring.h2.console.enabled=true
      ```
    - Les scripts `schema.sql` et `data.sql` initialisent les tables `users`, `authorities` et `patients`.

3. **Compiler et lancer**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Accéder à l’application**
    - Login : `http://localhost:8084/login`
    - Liste des patients : `http://localhost:8084/user/index`
    - Consoles :
        - H2 Console (si activé) : `http://localhost:8084/h2-console/`
        - Swagger (si configuré) : `http://localhost:8084/swagger-ui.html`
## Resultats
- base de donnees 
- ![img.png](img.png)
- Login
- ![img_1.png](img_1.png)
- liste des patients
- ![img_2.png](img_2.png)
- Ajouter un patient
- ![img_3.png](img_3.png)
- 