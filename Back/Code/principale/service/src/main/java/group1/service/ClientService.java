package group1.service;

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
	
	public void modifierClientById(int id, Client client){
		daoClient.modifierElementById(id,client);
	}
	
	
	
	/*public void modifierClient(Client client) {
		daoClient.updateClient(client);
	}
*/
}
