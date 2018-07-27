package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.Client;

public class DAOClient extends DAOGenerique<Client>
{	
	public DAOClient()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "client";
	}
	
	@Override
	public String getAttributs()
	{
		return "(idClient, nom, prenom, adresse, email, idConseiller)";
	}

	@Override
	public Client traitementLectureElement(ResultSet rs)
	{

		Client client = new Client();
		try
		{
			client.setIdClient(rs.getInt("idClient"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setAdresse(rs.getString("adresse"));
			client.setEmail(rs.getString("email"));
			
			DAOCompteCourant daoCompteCourant = new DAOCompteCourant();
			int cpt = 0;
			for(String clefEtrangere : daoCompteCourant.toutLireClefsEtrangeres())
			{
				if(clefEtrangere.equals(Integer.toString(client.getIdClient())))
				{
					client.getListComptes().add(daoCompteCourant.toutLireElement().get(cpt));
				}
				cpt++;
			}
			
			DAOCompteEpargne daoCompteEpargne = new DAOCompteEpargne();
			cpt = 0;
			for(String clefEtrangere : daoCompteEpargne.toutLireClefsEtrangeres())
			{
				if(clefEtrangere.equals(Integer.toString(client.getIdClient())))
				{
					client.getListComptes().add(daoCompteEpargne.toutLireElement().get(cpt));
				}
				cpt++;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return client;	
	}
	
	@Override
	public String traitementLectureClefEtrangere(ResultSet rs)
	{
		try
		{
			return rs.getString("idConseiller");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;	
	}
	
	@Override
	public String getValeurs(Client client)
	{
		return "('" + client.getIdClient() + "', '" + client.getNom() +  "', '" + client.getPrenom() + "', " + client.getAdresse() + "', " + client.getEmail() +")";
	}

	@Override
	public String getUpdate(Client client)
	{
		return "idClient = '" + client.getIdClient() + "', nom =  '" + client.getNom() + "', prenom =  '" + client.getPrenom() + "', adresse =  '" + client.getAdresse() + "', email =  '" + client.getEmail()+"'";		
	}

	@Override
	public String getNomIdentifiant()
	{
		return "idClient";
	}
}
