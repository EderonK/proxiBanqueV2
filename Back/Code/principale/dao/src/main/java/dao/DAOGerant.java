package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.Gerant;

public class DAOGerant extends DAOUtilisateur<Gerant>
{
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
