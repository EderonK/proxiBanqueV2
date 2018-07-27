package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.Gerant;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class DAOGerant extends DAOUtilisateur<Gerant>
{
	
	/**
	 * 
	 * La - méthode getNomTable retourne la table qui contient le gérant
	 *
	 */
	@Override
	public String getNomTable()
	{
		return "gerant";
	}
	/**
	 * 
	 * La - méthode traitementLectureElement(ResultSet rs) retourne les informations d'un gerant
	 *
	 */
	@Override
	public Gerant traitementLectureElement(ResultSet rs)
	{

		Gerant gerant = new Gerant();
		try
		{
			gerant.setIdentifiant(rs.getString("identifiant"));
			gerant.setMotDePasse(rs.getString("motDePasse"));
			gerant.setPrenom(rs.getString("prenom"));
			gerant.setNom(rs.getString("nom"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return gerant;	
	}
}
