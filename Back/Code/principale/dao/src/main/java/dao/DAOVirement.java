package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.CompteCourant;
import domaine.main.CompteEpargne;
import domaine.main.Virement;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class DAOVirement extends DAOGenerique<Virement>
{	
	public DAOVirement()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}
	/**
	 * 
	 * La - méthode getNomTable() retourne un null
	 *
	 */
	@Override
	public String getNomTable()
	{
		return "virement";
	}
	/**
	 * 
	 * La - méthode getAttributs() retourne des paramètres d'un virement
	 *
	 */
	@Override
	public String getAttributs()
	{
		return "(idVirement, montant, numCompte, numCompteReceveur)";
	}
	/**
	 * 
	 * La - méthode traitementLectureElement(ResultSet rs) retourne un virement
	 *
	 */
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
	/**
	 * 
	 * La - méthode traitementLectureElement(ResultSet rs) retourne un null
	 *
	 */
	@Override
	public String traitementLectureClefEtrangere(ResultSet rs)
	{
		return null;	
	}
	/**
	 * 
	 * La - méthode getValeurs(Virement virement) renvoie les valeurs d'un virement
	 *
	 */
	@Override
	public String getValeurs(Virement virement)
	{
		return "('" + virement.getIdVirement() + "', '" + virement.getMontant() + "', '" + virement.getNumCompte().getNumCompte() +  "', '" + virement.getNumCompteReceveur().getNumCompte() +")";
	}
	/**
	 * 
	 * La - méthode getUpdate(Virement virement) renvoie les valeurs actualisées d'un utilisateur
	 *
	 */
	@Override
	public String getUpdate(Virement virement)
	{
		return "idVirement = '" + virement.getIdVirement() +"montant = '" + virement.getMontant() + "', numCompte =  '" + virement.getNumCompte().getNumCompte() + "', numCompteReceveur =  '" + virement.getNumCompteReceveur().getNumCompte();
	}
	/**
	 * 
	 * La - méthode getNomIdentifiant() renvoie un client correspondant à l'identifiant recherché
	 *
	 */
	@Override
	public String getNomIdentifiant()
	{
		return "idVirement";
	}
}
