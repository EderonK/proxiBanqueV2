package dao;

public class test
{

	public static void main(String[] args)
	{
		DAOGerant daoGerant = new DAOGerant();
		System.out.println(daoGerant.toutLireElement());
		System.out.println("--------------------------------------------------------------------------------");
		DAOCompteEpargne daoCompteEpargne = new DAOCompteEpargne();
		System.out.println(daoCompteEpargne.toutLireElement());
		System.out.println("--------------------------------------------------------------------------------");
		DAOCompteCourant daoCompteCourant = new DAOCompteCourant();
		System.out.println(daoCompteCourant.toutLireElement());
	}	
}
