package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.CompteEpargne;

public class DAOCompteEpargne extends DAOGenerique<CompteEpargne>
{	
	public DAOCompteEpargne()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "compteEpargne";
	}
	
	@Override
	public String getAttributs()
	{
		return "(numCompte, solde, dateOuverture, carteBancaire, tauxRemuneration, idClient)";
	}

	@Override
	public CompteEpargne traitementLectureElement(ResultSet rs)
	{

		CompteEpargne compteEpargne = new CompteEpargne();
		try
		{
			compteEpargne.setNumCompte(rs.getString("numCompte"));
			compteEpargne.setSolde(rs.getDouble("solde"));
			compteEpargne.setDateOuverture(rs.getString("dateOuverture"));
			compteEpargne.setCarteBancaire(rs.getString("carteBancaire"));
			compteEpargne.setTauxRemuneration(rs.getFloat("tauxRemuneration"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return compteEpargne;	
	}
	
	@Override
	public String traitementLectureClefEtrangere(ResultSet rs)
	{
		try
		{
			return rs.getString("idClient");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;	
	}
	
	@Override
	public String getValeurs(CompteEpargne compteEpargne)
	{
		return "('" + compteEpargne.getNumCompte() + "', '" + compteEpargne.getSolde() +  "', '" + compteEpargne.getDateOuverture() + "', " + compteEpargne.getCarteBancaire() + "', " + compteEpargne.getTauxRemuneration() +")";
	}

	@Override
	public String getUpdate(CompteEpargne compteEpargne)
	{
		return "nom = '" + compteEpargne.getNumCompte() + "', prenom =  '" + compteEpargne.getSolde() + "', clan =  '" + compteEpargne.getDateOuverture() + "', etreinte =  " + compteEpargne.getCarteBancaire() + "', etreinte =  " + compteEpargne.getTauxRemuneration();		
	}
}
