package domaine.main;

public class Virement
{
	private int idVirement;
	private double montant;
	private Compte numCompte;
	private Compte numCompteReceveur;
	
	public Virement(int id, double montant, Compte numCompte, Compte numCompteReceveur) {
		super();
		this.idVirement = id;
		this.montant = montant;
		this.numCompte = numCompte;
		this.numCompteReceveur = numCompteReceveur;
	}
	
	public Virement()
	{
		this.idVirement = 0;
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

	public int getIdVirement() {
		return idVirement;
	}

	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}

	@Override
	public String toString() {
		return "Virement [idVirement=" + idVirement + ", montant=" + montant + ", numCompte=" + numCompte
				+ ", numCompteReceveur=" + numCompteReceveur + "]";
	}
}
