package domaine.main;

public class CompteCourant extends Compte
{
	//Attributs
	private double decouvertMax;
	
	//Constructeurs
	public CompteCourant(String numCompte, double solde, String dateOuverture, String carteBancaire, double decouvertMax)
	{
		super(numCompte, solde, dateOuverture, carteBancaire);
		this.decouvertMax = decouvertMax;
	}
	
	public CompteCourant()
	{
		super("numCompte", 0.0, "dateOuverture", "carteBancaire");
		this.decouvertMax = 0.0;
	}

	//Gets and Sets
	public double getDecouvertMax()
	{
		return decouvertMax;
	}
	
	public void setDecouvertMax(double decouvertMax)
	{
		this.decouvertMax = decouvertMax;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvertMax=" + decouvertMax + ", getNumCompte()=" + getNumCompte() + ", getSolde()="
				+ getSolde() + ", getDateOuverture()=" + getDateOuverture() + ", getCarteBancaire()="
				+ getCarteBancaire() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
