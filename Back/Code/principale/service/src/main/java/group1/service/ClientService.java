package group1.service;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
import java.util.ArrayList;

import dao.DAOClient;
import dao.DAOConseiller;
import dao.DAOGenerique;
import domaine.main.Client;
import domaine.main.Conseiller;

public class ClientService {
	
	DAOClient daoClient = new DAOClient();
	DAOConseiller daoConseiller = new DAOConseiller();
	
	public ArrayList<Client> retournerListeClient(Conseiller conseiller){
		
		return conseiller.getListClients();	
	}
	
	
	
	/*public void modifierClient(Client client) {
		daoClient.updateClient(client);
	}
*/
}
