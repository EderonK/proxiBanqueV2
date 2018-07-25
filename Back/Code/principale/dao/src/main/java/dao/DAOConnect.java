package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOConnect
{
	java.sql.Connection con;
	java.sql.Statement stmt;
	
	public DAOConnect()
	{
		this.con = null;
		this.stmt = null;
	}
	
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
