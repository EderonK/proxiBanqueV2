package group1.service;

import java.util.ArrayList;

public class ClientService {
	
	DAOClient daoClient = new DAOClient();
	
	
	public ArrayList<Client> retournerListeClient(Conseiller conseiller){
		
		return daoClient.getClientByIdConseiller(conseiller);
		
	}
	
	
	
	public void modifierClient(Client client) {
		daoClient.updateClient(client);
	}

}
