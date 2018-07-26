package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.CompteCourant;

public abstract class DAOCompte extends DAOGenerique<CompteCourant>
{	
	public DAOCompte()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "compteCourant";
	}
	
	@Override
	public String getAttributs()
	{
		return "(numCompte, solde, dateOuverture, carteBancaire, decouvertMax, idClient)";
	}

	@Override
	public CompteCourant traitementLectureElement(ResultSet rs)
	{

		CompteCourant compteCourant = new CompteCourant();
		try
		{
			compteCourant.setNumCompte(rs.getString("numCompte"));
			compteCourant.setSolde(rs.getDouble("solde"));
			compteCourant.setDateOuverture(rs.getString("dateOuverture"));
			compteCourant.setCarteBancaire(rs.getString("carteBancaire"));
			compteCourant.setDecouvertMax(rs.getDouble("decouvertMax"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return compteCourant;	
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
	public String getValeurs(CompteCourant compteCourant)
	{
		return "('" + compteCourant.getNumCompte() + "', '" + compteCourant.getSolde() +  "', '" + compteCourant.getDateOuverture() + "', " + compteCourant.getCarteBancaire() + "', " + compteCourant.getDecouvertMax() +")";
	}

	@Override
	public String getUpdate(CompteCourant compteCourant)
	{
		return "nom = '" + compteCourant.getNumCompte() + "', prenom =  '" + compteCourant.getSolde() + "', clan =  '" + compteCourant.getDateOuverture() + "', etreinte =  " + compteCourant.getCarteBancaire() + "', etreinte =  " + compteCourant.getDecouvertMax();		
	}
	
	@Override
	public String getNomIdentifiant()
	{
		return "numCompte";
	}
}
