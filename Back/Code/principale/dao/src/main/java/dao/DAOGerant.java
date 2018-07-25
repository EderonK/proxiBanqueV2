package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.Gerant;

public class DAOGerant extends DAOGenerique<Gerant>
{	
	public DAOGerant()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "gerant";
	}
	
	@Override
	public String getAttributs()
	{
		return "(identifiant, motDePasse, prenom, nom)";
	}

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
	
	@Override
	public String getValeurs(Gerant gerant)
	{
		return "('" + gerant.getIdentifiant() + "', '" + gerant.getMotDePasse() +  "', '" + gerant.getPrenom() + "', " + gerant.getNom() +")";
	}

	@Override
	public String getUpdate(Gerant gerant)
	{
		return "nom = '" + gerant.getIdentifiant() + "', prenom =  '" + gerant.getMotDePasse() + "', clan =  '" + gerant.getPrenom() + "', etreinte =  " + gerant.getNom();		
	}
}
