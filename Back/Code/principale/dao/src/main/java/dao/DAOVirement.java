package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.CompteCourant;
import domaine.main.CompteEpargne;
import domaine.main.Virement;

public class DAOVirement extends DAOGenerique<Virement>
{	
	public DAOVirement()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "virement";
	}
	
	@Override
	public String getAttributs()
	{
		return "(idVirement, montant, numCompte, numCompteReceveur)";
	}

	@Override
	public Virement traitementLectureElement(ResultSet rs)
	{

		Virement virement = new Virement();
		try
		{
			virement.setIdVirement(rs.getInt("idVirement"));
			virement.setMontant(rs.getDouble("montant"));
			
			String numCompteDonneur =rs.getString("numCompte");
			String numCompteReceveur = rs.getString("numCompteReceveur");
			
			DAOCompteCourant daoCompteCourant = new DAOCompteCourant();
			for(CompteCourant compteCourant : daoCompteCourant.toutLireElement())
			{
				if(numCompteDonneur.equals(compteCourant.getNumCompte()))
				{
					virement.setNumCompte(compteCourant);
				}
				
				if(numCompteReceveur.equals(compteCourant.getNumCompte()))
				{
					virement.setNumCompteReceveur(compteCourant);
				}
			}
			
			DAOCompteEpargne daoCompteEpargne = new DAOCompteEpargne();
			for(CompteEpargne compteEpargne : daoCompteEpargne.toutLireElement())
			{
				if(numCompteDonneur.equals(compteEpargne.getNumCompte()))
				{
					virement.setNumCompte(compteEpargne);
				}
				
				if(numCompteReceveur.equals(compteEpargne.getNumCompte()))
				{
					virement.setNumCompteReceveur(compteEpargne);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return virement;	
	}
	
	@Override
	public String traitementLectureClefEtrangere(ResultSet rs)
	{
		return null;	
	}
	
	@Override
	public String getValeurs(Virement virement)
	{
		return "('" + virement.getIdVirement() + "', '" + virement.getMontant() + "', '" + virement.getNumCompte() +  "', '" + virement.getNumCompteReceveur() +")";
	}

	@Override
	public String getUpdate(Virement virement)
	{
		return "idVirement = '" + virement.getIdVirement() +"montant = '" + virement.getMontant() + "', numCompte =  '" + virement.getNumCompte() + "', numCompteReceveur =  '" + virement.getNumCompteReceveur();
	}

	@Override
	public String getNomIdentifiant()
	{
		return "idVirement";
	}
}
