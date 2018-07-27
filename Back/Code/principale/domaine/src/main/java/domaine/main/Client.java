package domaine.main;

import java.util.ArrayList;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class Client
{	
	//Attributs
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private ArrayList<Compte> listComptes;
	
	//Constructeurs
	public Client(int idClient, String nom, String prenom, String adresse, String email,
			ArrayList<Compte> listComptes)
	{
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.listComptes = listComptes;
	}

	public Client()
	{
		this(0, "nom", "prenom", "adresse", "email", new ArrayList<Compte>());
	}

	//Gets and Sets
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
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

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", email=" + email + ", listComptes=" + listComptes + "]";
	}
}
