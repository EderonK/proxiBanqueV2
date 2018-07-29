package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.CompteCourant;


/**
 * @author Groupe 1
 * @version 0.1
 *
 */

public class DAOCompteCourant extends DAOGenerique<CompteCourant>
{	
	public DAOCompteCourant()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	/**
	 *  
	 * La - méthode getNomTable retourne la table des comptes courants
	 * 
	 */
	@Override
	public String getNomTable()
	{
		return "comptecourant";
	}
	/**
	 *  
	 * La - méthode getAttributs() retourne des paramètres d'un compte courant et l'association à son compte client
	 * 
	 */
	@Override
	public String getAttributs()
	{
		return "(numCompte, solde, dateOuverture, carteBancaire, decouvertMax, idClient)";
	}
	/**
	 *  
	 * La - méthode traitementLectureElement(ResultSet rs) retourne les informations d'un compte courant
	 * 
	 */
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
	/**
	 *  
	 * La - méthode traitementLectureClefEtrangere(ResultSet rs) cherche en base de données le compte courant d'un client particulier
	 * 
	 */
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
	/**
	 *  
	 * La - méthode getValeurs(CompteCourant compteCourant) renvoie les valeurs d'un compte courant
	 * 
	 */
	@Override
	public String getValeurs(CompteCourant compteCourant)
	{
		return "('" + compteCourant.getNumCompte() + "', '" + compteCourant.getSolde() +  "', '" + compteCourant.getDateOuverture() + "', " + compteCourant.getCarteBancaire() + "', " + compteCourant.getDecouvertMax() +")";
	}
	/**
	 *  
	 * La - méthode getUpdate(CompteCourant compteCourant) renvoie les valeurs actualisées d'un compte courant
	 * 
	 */
	@Override
	public String getUpdate(CompteCourant compteCourant)
	{
		return "numCompte = '" + compteCourant.getNumCompte() + "', solde =  '" + compteCourant.getSolde() + "', dateOuverture =  '" + compteCourant.getDateOuverture() + "', carteBancaire =  " + compteCourant.getCarteBancaire() + "', decouvertMax =  " + compteCourant.getDecouvertMax();		
	}
	/**
	 *  
	 * La - méthode getNomIdentifiant() renvoie un numéro de compte
	 * 
	 */
	@Override
	public String getNomIdentifiant()
	{
		return "numCompte";
	}
}
