package group1.service;

import dao.DAOConseiller;
import dao.DAOGerant;

public class IdentificationService
{
	DAOConseiller daoConseiller;
	DAOGerant daoGerant;	
	
	IdentificationService()
	{
		this.daoConseiller = new DAOConseiller();
		this.daoGerant = new DAOGerant();
	}
	
	verficationMotDePasse(String id, String mdp)
	{
		for(Gerant gerant : this.daoGerant.toutLireElement())
	}
}
