package dao;

import domaine.main.Client;
import domaine.main.CompteCourant;
import domaine.main.CompteEpargne;
import domaine.main.Gerant;
import domaine.main.Virement;
import domaine.main.Conseiller;;

public class test
{
	public static void main(String[] args)
	{
		DAOGerant daoGerant = new DAOGerant();
		for(Gerant gerant : daoGerant.toutLireElement())
		{
			System.out.println(gerant);
		}
		System.out.println("--------------------------------------------------------------------------------");
		DAOCompteEpargne daoCompteEpargne = new DAOCompteEpargne();
		for(CompteEpargne compteEpargne : daoCompteEpargne.toutLireElement())
		{
			System.out.println(compteEpargne);
		}
		System.out.println("--------------------------------------------------------------------------------");
		DAOCompteCourant daoCompteCourant = new DAOCompteCourant();
		for(CompteCourant compteCourant : daoCompteCourant.toutLireElement())
		{
			System.out.println(compteCourant);
		}
		System.out.println("--------------------------------------------------------------------------------");
		DAOClient daoClient = new DAOClient();
		for(Client client : daoClient.toutLireElement())
		{
			System.out.println(client);
		}
		System.out.println("--------------------------------------------------------------------------------");
		DAOConseiller daoConseiller = new DAOConseiller();
		for(Conseiller conseiller : daoConseiller.toutLireElement())
		{
			System.out.println(conseiller);
		}
		System.out.println("--------------------------------------------------------------------------------");
		DAOVirement daoVirement = new DAOVirement();
		for(Virement virement : daoVirement.toutLireElement())
		{
			System.out.println(virement);
		}
	}	
}
