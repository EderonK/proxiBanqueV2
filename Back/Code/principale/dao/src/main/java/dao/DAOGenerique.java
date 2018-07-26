package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAOGenerique<ElementBase> implements IDAOGenerique<ElementBase>
{
	private DAOConnect connect;
	private String driver;
	private String base;
	private String user;
	private String mdp;
	
	public DAOGenerique(String driver, String base, String user, String mdp)
	{
		this.connect = new DAOConnect();
		this.driver = driver;
		this.base = base;
		this.user = user;
		this.mdp = mdp;
	}
	
	private void etablirConnection()
	{
		this.connect.etablirConnection(this.driver, this.base, this.user, this.mdp);
	}
	
	private void fermerConnection()
	{
		this.connect.fermerConnection();
	}
	
	protected void executeUpdate(String requete)
	{
		this.etablirConnection();
		this.connect.executeUpdate(requete);
		this.fermerConnection();
	}
	
	protected ResultSet executeQuery(String requete)
	{
		this.etablirConnection();
		ResultSet rs = this.connect.executeQuery(requete);
		
		return rs;
	}
	
	public void creerElement(ElementBase element)
	{
		String requete = "INSERT INTO " + this.getNomTable() + " " + this.getAttributs() + " VALUES " + this.getValeurs(element) + ";";
		this.executeUpdate(requete);
	}
	
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
	
	public void modifierElementById(int id, ElementBase element)
	{
		String requete = "UPDATE " + this.getNomTable() +" SET "+ this.getUpdate(element) + " WHERE id=" + id + ";";
		this.executeUpdate(requete);
	}
	
	public void supprimerElementById(int id)
	{
		String requete = "DELETE FROM " + this.getNomTable() + " WHERE id=" + id + ";";
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
