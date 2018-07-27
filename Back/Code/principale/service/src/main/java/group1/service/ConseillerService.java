package group1.service;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
import dao.DAOConseiller;
import domaine.main.Conseiller;

public class ConseillerService {
	
	
	DAOConseiller daoConseiller = new DAOConseiller();
	
	public Conseiller recupererConseillerParId(String id) {
		return daoConseiller.lireElementById(id);
	}

}
