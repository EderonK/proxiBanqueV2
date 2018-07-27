package domaine.main;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @JsonSubTypes.Type(value = CompteCourant.class), @JsonSubTypes.Type(value = CompteEpargne.class) })

=======
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
>>>>>>> 27ed5ff098d59060d7d297350909af6cd9ec3699
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
