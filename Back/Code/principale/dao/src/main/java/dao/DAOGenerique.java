package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public abstract class DAOGenerique<ElementBase> implements IDAOGenerique<ElementBase>
{
	private DAOConnect connect;
	private String driver;
	private String base;
	private String user;
	private String mdp;
	/**
	 * 
	 * La - méthode DAOGenerique(String driver, String base, String user, String mdp) est le constructeur de la classe DAO Generique
	 *
	 */
	public DAOGenerique(String driver, String base, String user, String mdp)
	{
		this.connect = new DAOConnect();
		this.driver = driver;
		this.base = base;
		this.user = user;
		this.mdp = mdp;
	}
	/**
	 * 
	 * La - méthode etablirConnection() établie la connexion avec la base
	 *
	 */
	private void etablirConnection()
	{
		this.connect.etablirConnection(this.driver, this.base, this.user, this.mdp);
	}
	/**
	 * 
	 * La - méthode fermerConnection() permet de fermer la connection avec la base
	 *
	 */
	private void fermerConnection()
	{
		this.connect.fermerConnection();
	}
	/**
	 * 
	 * La - méthode executeUpdate(String requete) permet de procéder aux mises à jour de la table attendue
	 *
	 */
	protected void executeUpdate(String requete)
	{
		this.etablirConnection();
		this.connect.executeUpdate(requete);
		this.fermerConnection();
	}
	/**
	 * 
	 * La - méthode executeQuery(String requete) permet d'executer la requete demandée
	 *
	 */
	protected ResultSet executeQuery(String requete)
	{
		this.etablirConnection();
		ResultSet rs = this.connect.executeQuery(requete);
		
		return rs;
	}
	/**
	 * 
	 * La - méthode creerElement(ElementBase element) permet de manière générique de créer un nouvel élément
	 *
	 */
	public void creerElement(ElementBase element)
	{
		String requete = "INSERT INTO " + this.getNomTable() + " " + this.getAttributs() + " VALUES " + this.getValeurs(element) + ";";
		this.executeUpdate(requete);
	}
	/**
	 * 
	 * La - méthode lireElementById(String id) permet de manière générique de lire un élément et retourne un élement
	 *
	 */
	public ElementBase lireElementById(String id)
	{
		String requete = "SELECT * FROM " + this.getNomTable() +" WHERE " + this.getNomIdentifiant() +  " = '" + id + "';";
		
		ResultSet rs = this.executeQuery(requete);
		
		ElementBase element = null;
		
		try
		{
			rs.next();
			element = this.traitementLectureElement(rs);
			this.fermerConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
				
		return element;
	}
	/**
	 * 
	 * La - méthode toutLireElement() permet de manière générique de lire une liste d'éléments et retourne une liste
	 *
	 */
	public ArrayList<ElementBase> toutLireElement()
	{
		String requete = "SELECT * FROM " + this.getNomTable() + ";";
		ResultSet rs = this.executeQuery(requete);
		
		ArrayList<ElementBase> elements = new ArrayList<ElementBase>();
		
		try
		{
			while(rs.next())
			{
				elements.add(this.traitementLectureElement(rs));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		this.fermerConnection();
		
		return elements;
	}
	/**
	 * 
	 * La - méthode toutLireClefsEtrangeres() permet de manière générique de lire la liste des clés étrangères des bases contenues dans la base de données
	 *
	 */
	public ArrayList<String> toutLireClefsEtrangeres()
	{
		String requete = "SELECT * FROM " + this.getNomTable() + ";";
		ResultSet rs = this.executeQuery(requete);
		
		ArrayList<String> clefs = new ArrayList<String>();
		
		try
		{
			while(rs.next())
			{
				clefs.add(""+ this.traitementLectureClefEtrangere(rs));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		this.fermerConnection();
		
		return clefs;
	}
	/**
	 * 
	 * 
	 *
	 */
	public void modifierElementById(int id, ElementBase element)
	{
		String requete = "UPDATE " + this.getNomTable() +" SET "+ this.getUpdate(element) + " WHERE " + this.getNomIdentifiant() +  "=" + id + ";";
		this.executeUpdate(requete);
	}
	/**
	 * 
	 * La - méthode modifierElementById(int id, ElementBase element) est une méthode générique qui permet de modifier une élement en l'identifiant par son Id
	 *
	 */
	public void supprimerElementById(int id)
	{
		String requete = "DELETE FROM " + this.getNomTable() + " WHERE " + this.getNomIdentifiant() +  "=" + id + ";";
		this.executeUpdate(requete);
	}
	
	public abstract String getNomIdentifiant();
	public abstract String getNomTable();
	public abstract String getAttributs();
	public abstract String getValeurs(ElementBase element);
	public abstract String getUpdate(ElementBase element);
	public abstract ElementBase traitementLectureElement(ResultSet rs);
	public abstract String traitementLectureClefEtrangere(ResultSet rs);
}
