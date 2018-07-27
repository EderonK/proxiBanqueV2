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
}
