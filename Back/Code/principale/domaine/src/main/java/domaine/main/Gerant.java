package domaine.main;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class Gerant extends Utilisateur
{
	public Gerant(String identifiant, String motDePasse, String prenom, String nom)
	{
		super(identifiant, motDePasse, prenom, nom);
	}

	public Gerant()
	{
		this("0000", "mdp", "prenom", "nom");
	}

	@Override
	public String toString() {
		return "Gerant [getIdentifiant()=" + getIdentifiant() + ", getMotDePasse()=" + getMotDePasse()
				+ ", getPrenom()=" + getPrenom() + ", getNom()=" + getNom() + "]";
	}
}
