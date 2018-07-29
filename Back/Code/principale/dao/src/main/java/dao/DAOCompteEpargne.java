package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.CompteEpargne;

/**
 * @author Groupe 1
 * @version 0.1
 *
 */

public class DAOCompteEpargne extends DAOGenerique<CompteEpargne>
{	
	public DAOCompteEpargne()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}
	/**
	 *  
	 * La - méthode getNomTable retourne la table des compte épargne
	 * 
	 */
	@Override
	public String getNomTable()
	{
		return "compteepargne";
	}
	/**
	 *  
	 * La - méthode getAttributs() retourne des paramètres d'un compte épargne et l'association à son compte client
	 * 
	 */
	@Override
	public String getAttributs()
	{
		return "(numCompte, solde, dateOuverture, carteBancaire, tauxRemuneration, idClient)";
	}
	/**
	 *  
	 * La - méthode traitementLectureElement(ResultSet rs) retourne les informations d'un compte épargne
	 * 
	 */
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
	/**
	 *  
	 * La - méthode traitementLectureClefEtrangere(ResultSet rs) cherche en base de données le compte épargne d'un client particulier
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
	 * La - méthode getValeurs(CompteEpargne compteEpargne) renvoie les valeurs d'un compte épargne
	 * 
	 */
	@Override
	public String getValeurs(CompteEpargne compteEpargne)
	{
		return "('" + compteEpargne.getNumCompte() + "', '" + compteEpargne.getSolde() +  "', '" + compteEpargne.getDateOuverture() + "', " + compteEpargne.getCarteBancaire() + "', " + compteEpargne.getTauxRemuneration() +")";
	}
	/**
	 *  
	 * La - méthode getUpdate(CompteCourant compteCourant) renvoie les valeurs actualisées d'un compte épargne
	 * 
	 */
	@Override
	public String getUpdate(CompteEpargne compteEpargne)
	{
		return "numCompte = '" + compteEpargne.getNumCompte() + "', solde =  '" + compteEpargne.getSolde() + "', dateOuverture =  '" + compteEpargne.getDateOuverture() + "', carteBancaire =  " + compteEpargne.getCarteBancaire() + "', tauxRemuneration =  " + compteEpargne.getTauxRemuneration();		
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
