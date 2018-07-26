package domaine.main;

public class Virement
{
	private double montant;
	private Compte numCompte;
	private Compte numCompteReceveur;
	
	public Virement(double montant, Compte numCompte, Compte numCompteReceveur)
	{
		this.montant = montant;
		this.numCompte = numCompte;
		this.numCompteReceveur = numCompteReceveur;
	}
	
	public Virement()
	{
		this.montant = 0;
		this.numCompte = null;
		this.numCompteReceveur = null;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(Compte numCompte) {
		this.numCompte = numCompte;
	}

	public Compte getNumCompteReceveur() {
		return numCompteReceveur;
	}

	public void setNumCompteReceveur(Compte numCompteReceveur) {
		this.numCompteReceveur = numCompteReceveur;
	}

	@Override
	public String toString() {
		return "Virement [montant=" + montant + ", numCompte=" + numCompte + ", numCompteReceveur=" + numCompteReceveur
				+ "]";
	}
}
