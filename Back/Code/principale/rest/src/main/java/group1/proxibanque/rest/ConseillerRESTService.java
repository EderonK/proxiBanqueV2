package group1.proxibanque.rest;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domaine.main.Client;
//import domaine.main.Compte;
import domaine.main.Conseiller;
import domaine.main.Utilisateur;

@Path("/conseiller")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConseillerRESTService {
  AuthentificationRESTService authentificationRESTService = new AuthentificationRESTService();
  
//  // conseiller et listeClients sont définis pour tester.
//  // A supprimer et remplacer par les données retournées de la BD.
//  private ArrayList<Client> listeClients = new ArrayList<Client>();
//  private Conseiller conseiller;
  
  public ConseillerRESTService() {
//    // Créer les clients sans compte pour tester sans la BD.
//    for (int i = 1; i <= 10; i++) {
//      String prenomClient = "Titi " + i;
//      String nomClient = "TOTO " + i;
//      Client client = new Client(i, nomClient, prenomClient, "Toulouse", "client@proxibanque.fr", new ArrayList<Compte>());
//      listeClients.add(client);
//    }
//    
//    conseiller = new Conseiller("zaza.zuzu", "123456789", "Zaza", "ZUZU", listeClients);
  }
  
  // Trouver tous les clients d'un conseiller
  @GET
  @Path("/clients")
  public List<Client> trouverTousClients(@HeaderParam("identifiant") String identifiant, @HeaderParam("motDePasse") String motDePasse) {
//    // Pour tester
//    conseiller.getListClients();
    
    Utilisateur utilisateur = authentificationRESTService.authentifier(identifiant, motDePasse);
    if (utilisateur != null && utilisateur instanceof Conseiller) {
      return ((Conseiller) utilisateur).getListClients();
    }
    
    return null;
  }
}