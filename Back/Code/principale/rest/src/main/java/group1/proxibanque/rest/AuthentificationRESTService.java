package group1.proxibanque.rest;

// import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DAOConseiller;
import dao.DAOGerant;
// import domaine.main.Client;
import domaine.main.Conseiller;
import domaine.main.Gerant;
import domaine.main.Utilisateur;

@Path("/authentification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthentificationRESTService {
  private DAOConseiller daoConseiller = new DAOConseiller();
  private DAOGerant daoGerant = new DAOGerant();

//  // Pour tester sans la BD
//  @GET
//  public Utilisateur authentifier(@HeaderParam("identifiant") String identifiant, @HeaderParam("motDePasse") String motDePasse) {    
//    Utilisateur utilisateur = new Conseiller("zaza.zuzu", "123456789", "Zaza", "ZUZU", new ArrayList<Client>());
//    
//    if (utilisateur != null
//        && identifiant.equals(utilisateur.getIdentifiant())
//        && motDePasse.equals(utilisateur.getMotDePasse())
//    ) {
//      return utilisateur;
//    }
//    
//    return null;
//  }
  
  @GET
  public Utilisateur authentifier(@HeaderParam("identifiant") String identifiant, @HeaderParam("motDePasse") String motDePasse) {
    for(Gerant gerant : daoGerant.toutLireElement()) {
      if(gerant.getIdentifiant().equals(identifiant) && gerant.getMotDePasse().equals(motDePasse)) {
        return gerant;
      }   
    }

    for(Conseiller conseiller : daoConseiller.toutLireElement()) {
      if(conseiller.getIdentifiant().equals(identifiant) && conseiller.getMotDePasse().equals(motDePasse)) {
        return conseiller;
      }
    }
    
    return null;
  }
}