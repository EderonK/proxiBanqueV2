package group1.proxibanque.rest;

import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import domaine.main.Client;
import domaine.main.Conseiller;

public class RESTClient {
  public static void main(String[] args) {
    String REST_URI = "http://localhost:8080/proxibanque-rest/rest/";
    javax.ws.rs.client.Client restClient = ClientBuilder.newClient();

//  // Pour tester sans la BD    
//    List<Client> clients = restClient.target(REST_URI).path("conseiller/clients").request(MediaType.APPLICATION_JSON)
//        .header("identifiant", "zaza.zuzu").header("motDePasse", "123456789").get(new GenericType<List<Client>>(){});
//    
//    for (Client client : clients) {
//      System.out.println("----------------------------------------");
//      System.out.println("Id: " + client.getIdClient());
//      System.out.println("Nom: " + client.getNom());
//      System.out.println("Prenom: " + client.getPrenom());
//    }
    
    while (true) {
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Bonjour, vous êtes :");
      System.out.println("(1) Conseiller");
      System.out.println("(2) Gérant");
      System.out.println("Veuillez saisir votre choix (entrez 3 pour quitter) : ");
      
      int numeroCommande = scanner.nextInt();
      
      // L'utilisateur est un conseiller
      if (numeroCommande == 1) {
        System.out.println("Veuillez saisir votre identifiant : ");
        scanner.nextLine();
        String identifiant = scanner.nextLine();
        System.out.println("Veuillez saisir votre mot de passe : ");
        String motDePasse = scanner.nextLine();
        
        Conseiller conseiller = restClient.target(REST_URI).path("authentification").request(MediaType.APPLICATION_JSON)
            .header("identifiant", identifiant).header("motDePasse", motDePasse).get(Conseiller.class);
        
        // Le conseiller existe
        if (conseiller != null) {
          while (true) {
            System.out.println("Bonjour " + conseiller.getPrenom() + " " + conseiller.getNom());
            System.out.println("Veuillez choisir parmi les commandes suivantes :");
            System.out.println("(1) Lister tous vos clients");
            System.out.println("(2) Quitter");
            System.out.print("Veuillez saisir votre commande : ");
            
            numeroCommande = scanner.nextInt();
            
            // Lister tous les clients
            if (numeroCommande == 1) {
              List<Client> clients = restClient.target(REST_URI).path("conseiller/clients").request(MediaType.APPLICATION_JSON)
                  .header("identifiant", identifiant).header("motDePasse", motDePasse).get(new GenericType<List<Client>>(){});
              System.out.println();
              System.out.println("-------------------------------------------------------");
              System.out.println("La liste de tous vos clients");
              System.out.println("-------------------------------------------------------");
              
              for (Client client : clients) {
                System.out.println("Id : " + client.getIdClient() + " Prenom : " + client.getPrenom() + " Nom : "
                    + client.getNom());
              }
              
              System.out.println();
              System.out.println();
              
            } else if (numeroCommande == 2) {
              System.out.println("A bientôt");
              scanner.close();
              System.exit(0);
            }
          }
          
        // Le conseiller n'existe pas
        } else {
          System.out.println("Conseiller n'existe pas!");
        }
      
      } else if (numeroCommande == 3) {
        System.out.println("A bientôt");
        scanner.close();
        System.exit(0);
      }
    }
  }
}