package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.Client;

/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class DAOClient extends DAOGenerique<Client>
{	
	public DAOClient()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/proxibanque", "root", "");
	}

	
	/**
	 *  
	 * La  méthode getNomTable retourne un client
	 * 
	 */
	@Override
	public String getNomTable()
	{
		return "client";
	}
	/**
	 *  
	 * La méthode getAttributs() retourne des paramètres d'un client ainsi que le conseiller attitré
	 * 
	 */
	@Override
	public String getAttributs()
	{
		return "(idClient, nom, prenom, adresse, email, idConseiller)";
	}

	/**
	 *  
	 * La - méthode traitementLectureElement(ResultSet rs) retourne les informations d'un client
	 * 
	 */
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
	/**
	 *  
	 * La - méthode traitementLectureClefEtrangere(ResultSet rs) cherche en base de données un conseiller et ne retroune rien
	 * 
	 */
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
	/**
	 *  
	 * La - méthode getValeurs(Client client) renvoie les valeurs d'un client
	 * 
	 */
	@Override
	public String getValeurs(Client client)
	{
		return "('" + client.getIdClient() + "', '" + client.getNom() +  "', '" + client.getPrenom() + "', " + client.getAdresse() + "', " + client.getEmail() +")";
	}
	/**
	 *  
	 * La - méthode getUpdate(Client client) renvoie les valeurs actualisées d'un client
	 * 
	 */
	@Override
	public String getUpdate(Client client)
	{
		return "idClient = '" + client.getIdClient() + "', nom =  '" + client.getNom() + "', prenom =  '" + client.getPrenom() + "', adresse =  '" + client.getAdresse() + "', email =  '" + client.getEmail()+"'";		
	}
	/**
	 *  
	 * La - méthode getNomIdentifiant() renvoie un client correspondant à l'identifiant recherché
	 * 
	 */
	@Override
	public String getNomIdentifiant()
	{
		return "idClient";
	}
}
