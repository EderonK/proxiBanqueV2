package domaine.main;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public class CompteEpargne extends Compte
{
	//Attributs
	private float tauxRemuneration;
	
	//Constructeurs
	public CompteEpargne(String numCompte, double solde, String dateOuverture, String carteBancaire, float tauxRemuneration)
	{
		super(numCompte, solde, dateOuverture, carteBancaire);
		this.tauxRemuneration = tauxRemuneration;
	}
	
	public CompteEpargne()
	{
		this("numCompte", 0.0, "dateOuverture", "carteBancaire", 0);
	}

	//Gets and Sets
	public float getTauxRemuneration()
	{
		return tauxRemuneration;
	}

	public void setTauxRemuneration(float tauxRemuneration)
	{
		this.tauxRemuneration = tauxRemuneration;
	}

	@Override
	public String toString() {
		return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + ", getNumCompte()=" + getNumCompte()
				+ ", getSolde()=" + getSolde() + ", getDateOuverture()=" + getDateOuverture() + ", getCarteBancaire()="
				+ getCarteBancaire()+ "]";
	}
}
