package group1.service;

import dao.DAOConseiller;
import domaine.main.Conseiller;

public class ConseillerService {
	
	
	DAOConseiller daoConseiller = new DAOConseiller();
	
	public Conseiller recupererConseillerParId(String id) {
		return daoConseiller.lireElementById(id);
	}

}
