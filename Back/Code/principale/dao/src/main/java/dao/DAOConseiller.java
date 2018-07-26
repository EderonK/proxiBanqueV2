package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.main.Conseiller;

public class DAOConseiller extends DAOUtilisateur<Conseiller>
{
	@Override
	public String getNomTable()
	{
		return "conseiller";
	}
	
	@Override
	public Conseiller traitementLectureElement(ResultSet rs)
	{

		Conseiller conseillier= new Conseiller();
		try
		{
			conseillier.setIdentifiant(rs.getString("identifiant"));
			conseillier.setMotDePasse(rs.getString("motDePasse"));
			conseillier.setPrenom(rs.getString("prenom"));
			conseillier.setNom(rs.getString("nom"));
			
			DAOClient daoClient = new DAOClient();
			int cpt = 0;
			for(String clefEtrangere : daoClient.toutLireClefsEtrangeres())
			{
				if(clefEtrangere.equals(conseillier.getIdentifiant()))
				{
					conseillier.getListClients().add(daoClient.toutLireElement().get(cpt));
				}
				cpt++;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return conseillier;
	}
}
