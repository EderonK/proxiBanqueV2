package domaine.main;

import java.util.Date;

public abstract class Compte
{
	//Attributs
	private String numCompte;
	private double solde;
	private Date dateOuverture;
	private String carteBancaire;
	
	//Constructeurs
	public Compte(String numCompte, double solde, Date dateOuverture, String carteBancaire)
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

	public Date getDateOuverture()
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

	public void setDateOuverture(Date dateOuverture)
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
