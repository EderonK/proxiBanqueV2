package group1.service;

import dao.DAOConseiller;
import dao.DAOGerant;
import domaine.main.Conseiller;
import domaine.main.Gerant;
import domaine.main.Utilisateur;

public class IdentificationService
{
	DAOConseiller daoConseiller;
	DAOGerant daoGerant;	
	
	IdentificationService()
	{
		this.daoConseiller = new DAOConseiller();
		//this.daoGerant = new DAOGerant();
	}
	
	Utilisateur verficationMotDePasse(String id, String mdp)
	{
		for(Gerant gerant : this.daoGerant.toutLireElement())
		{
			if(gerant.getIdentifiant().equals(id) && gerant.getMotDePasse().equals(mdp))
			{
				return gerant;
			}		
		}
		
		for(Conseiller conseiller : this.daoConseiller.toutLireElement())
		{
			if(conseiller.getIdentifiant().equals(id) && conseiller.getMotDePasse().equals(mdp))
			{
				return conseiller;
			}
		}
		
		return null;
	}	
}
