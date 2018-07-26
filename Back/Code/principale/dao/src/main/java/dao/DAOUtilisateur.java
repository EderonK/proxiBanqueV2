package dao;

import java.sql.ResultSet;

import domaine.main.Utilisateur;

@SuppressWarnings("hiding")
public abstract class DAOUtilisateur<Utilisateur> extends DAOGenerique<Utilisateur>
{
	public DAOUtilisateur()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "conseiller";
	}
	
	@Override
	public String getAttributs()
	{
		return "(identifiant, motDePasse, prenom, nom)";
	}

	@Override
	public Utilisateur traitementLectureElement(ResultSet rs)
	{
		return null;		
	}
	
	@Override
	public String traitementLectureClefEtrangere(ResultSet rs)
	{
		return null;
	}
	
	@Override
	public String getValeurs(Utilisateur utilisateur)
	{
		return "('" + ((domaine.main.Utilisateur) utilisateur).getIdentifiant() + "', '" + ((domaine.main.Utilisateur) utilisateur).getMotDePasse() +  "', '" + ((domaine.main.Utilisateur) utilisateur).getPrenom() + "', " + ((domaine.main.Utilisateur) utilisateur).getNom() +")";
	}

	@Override
	public String getUpdate(Utilisateur utilisateur)
	{
		return "nom = '" + ((domaine.main.Utilisateur) utilisateur).getIdentifiant() + "', prenom =  '" + ((domaine.main.Utilisateur) utilisateur).getMotDePasse() + "', clan =  '" + ((domaine.main.Utilisateur) utilisateur).getPrenom() + "', etreinte =  " + ((domaine.main.Utilisateur) utilisateur).getNom();		
	}
	
	@Override
	public String getNomIdentifiant()
	{
		return "identifiant";
	}
}
