package domaine.main;

import java.util.ArrayList;

public class Conseiller extends Utilisateur
{
	//Attributs
	private ArrayList<Client> listClients;
	
	//Constructeurs
	public Conseiller(String identifiant, String motDePasse, String prenom, String nom, ArrayList<Client> listClients)
	{
		super(identifiant, motDePasse, prenom, nom);
		this.listClients = listClients;
	}

	public Conseiller()
	{
		this("identifiant", "motDePasse", "prenom", "nom", new ArrayList<Client>());
	}

	//Gets and Sets
	public ArrayList<Client> getListClients() {
		return listClients;
	}

	public void setListClients(ArrayList<Client> listClients) {
		this.listClients = listClients;
	}

	@Override
	public String toString() {
		return "Conseiller [listClients=" + listClients + ", getIdentifiant()=" + getIdentifiant()
				+ ", getMotDePasse()=" + getMotDePasse() + ", getPrenom()=" + getPrenom() + ", getNom()=" + getNom()
				+ "]";
	}
}
	