package domaine.main;

import java.util.ArrayList;

public class Client
{	
	//Attributs
	private String idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private ArrayList<Compte> listComptes;
	
	//Constructeurs
	public Client(String idClient, String nom, String prenom, String adresse, String email,
			ArrayList<Compte> listComptes)
	{
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.listComptes = listComptes;
	}

	//Gets and Sets
	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Compte> getListComptes() {
		return listComptes;
	}

	public void setListComptes(ArrayList<Compte> listComptes) {
		this.listComptes = listComptes;
	}
}
