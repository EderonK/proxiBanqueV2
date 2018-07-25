package domaine.main;

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
}
