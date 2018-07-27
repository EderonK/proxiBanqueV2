package domaine.main;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public abstract class Compte
{
	//Attributs
	private String numCompte;
	private double solde;
	private String dateOuverture;
	private String carteBancaire;
	
	//Constructeurs
	public Compte(String numCompte, double solde, String dateOuverture, String carteBancaire)
	{
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.carteBancaire = carteBancaire;
	}

	//Gets and Sets
	public String getNumCompte()
	{
		return numCompte;
	}

	public double getSolde()
	{
		return solde;
	}

	public String getDateOuverture()
	{
		return dateOuverture;
	}

	public void setNumCompte(String numCompte)
	{
		this.numCompte = numCompte;
	}

	public void setSolde(double solde)
	{
		this.solde = solde;
	}

	public void setDateOuverture(String dateOuverture)
	{
		this.dateOuverture = dateOuverture;
	}

	public String getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(String carteBancaire) {
		this.carteBancaire = carteBancaire;
	}
}
