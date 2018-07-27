package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class DAOConnect
{
	java.sql.Connection con;
	java.sql.Statement stmt;
	
	public DAOConnect()
	{
		this.con = null;
		this.stmt = null;
	}
	/**
	 *  
	 * La - méthode etablirConnection(String driver, String base, String user, String mdp) permet de se connecter au serveur
	 * 
	 */
	public void etablirConnection(String driver, String base, String user, String mdp)
	{
		try
		{
			Class.forName(driver);
			this.con = DriverManager.getConnection(base, user, mdp);
			this.stmt = con.createStatement();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 *  
	 * La - méthode executeUpdate(String requete) execute la mise à jour
	 * 
	 */
	public void executeUpdate(String requete)
	{
		try
		{
			this.stmt.executeUpdate(requete);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 *  
	 * La - méthode executeQuery(String requete) execute la requete
	 * 
	 */
	public ResultSet executeQuery(String requete)
	{
		try
		{
			return this.stmt.executeQuery(requete);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  
	 * La - méthode fermerConnection() cloture la connexion vers la base de données
	 * 
	 */
	public void fermerConnection()
	{
		try
		{
			con.close();
			stmt.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
