package domaine.main;

import java.util.ArrayList;

public class Conseiller
{
	//Attributs
	private String nom;
	private String prenom;
	private ArrayList<Client> listClients;
	
	//Constructeurs
	public Conseiller(String nom, String prenom, ArrayList<Client> listClients)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.listClients = listClients;
	}

	//Gets and Sets
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<Client> getListClients() {
		return listClients;
	}

	public void setListClients(ArrayList<Client> listClients) {
		this.listClients = listClients;
	}
}
	