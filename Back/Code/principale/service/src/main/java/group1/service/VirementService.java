package group1.service;

import java.util.ArrayList;

import dao.DAOVirement;
import domaine.main.Virement;

public class VirementService
{
	private DAOVirement daoVirement;
	
	public VirementService()
	{
		this.daoVirement = new DAOVirement();
	}
	
	public ArrayList<Virement> recupererListeVirements()
	{
		return daoVirement.toutLireElement();
	}
	
	public void faireVirement(Virement virement)
	{
		daoVirement.creerElement(virement);
	}
	
	public double sommeMontantsVirement(ArrayList<Virement> listeVirement)
	{
		double total = 0;
		
		for (Virement virement : listeVirement)
		{
			total = total + virement.getMontant();
		}
		
		return total;
	}
}
