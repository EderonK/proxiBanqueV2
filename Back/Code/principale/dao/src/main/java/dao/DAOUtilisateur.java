package dao;

import java.sql.ResultSet;

import domaine.main.Utilisateur;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
@SuppressWarnings("hiding")
public abstract class DAOUtilisateur<Utilisateur> extends DAOGenerique<Utilisateur>
{
	public DAOUtilisateur()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}
	/**
	 * 
	 * La - méthode getNomTable retourne un null
	 *
	 */
	@Override
	public String getNomTable()
	{
		return null;
	}
	/**
	 * 
	 * La - méthode getAttributs() retourne des paramètres d'un utilisateur
	 *
	 */
	@Override
	public String getAttributs()
	{
		return "(identifiant, motDePasse, prenom, nom)";
	}
	/**
	 * 
	 * La - méthode traitementLectureElement(ResultSet rs) retourne un null
	 *
	 */
	@Override
	public Utilisateur traitementLectureElement(ResultSet rs)
	{
		return null;		
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
	 * La - méthode getValeurs(Utilisateur utilisateur) renvoie les valeurs d'un utilisateur
	 *
	 */
	@Override
	public String getValeurs(Utilisateur utilisateur)
	{
		return "('" + ((domaine.main.Utilisateur) utilisateur).getIdentifiant() + "', '" + ((domaine.main.Utilisateur) utilisateur).getMotDePasse() +  "', '" + ((domaine.main.Utilisateur) utilisateur).getPrenom() + "', " + ((domaine.main.Utilisateur) utilisateur).getNom() +")";
	}
	/**
	 * 
	 * La - méthode getUpdate(Utilisateur utilisateur) renvoie les valeurs actualisées d'un utilisateur
	 *
	 */
	@Override
	public String getUpdate(Utilisateur utilisateur)
	{
		return "identifiant = '" + ((domaine.main.Utilisateur) utilisateur).getIdentifiant() + "', motDePasse =  '" + ((domaine.main.Utilisateur) utilisateur).getMotDePasse() + "', prenom =  '" + ((domaine.main.Utilisateur) utilisateur).getPrenom() + "', nom =  " + ((domaine.main.Utilisateur) utilisateur).getNom();		
	}
	/**
	 * 
	 * La - méthode getNomIdentifiant() renvoie un client correspondant à l'identifiant recherché
	 *
	 */
	@Override
	public String getNomIdentifiant()
	{
		return "identifiant";
	}
}
