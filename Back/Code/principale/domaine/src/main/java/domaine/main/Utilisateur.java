package domaine.main;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public abstract class Utilisateur
{
	private String identifiant;
	private String motDePasse;
	private String prenom;
	private String nom;
	
	public Utilisateur(String identifiant, String motDePasse, String prenom, String nom)
	{
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	
}


