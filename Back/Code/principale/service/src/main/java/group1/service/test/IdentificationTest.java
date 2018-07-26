package group1.service.test;

import org.junit.Test;

import dao.DAOConseiller;
import dao.DAOGerant;
import group1.service.IdentificationService;
import junit.framework.TestCase;

public class IdentificationTest extends TestCase
{
	IdentificationService identServ = new IdentificationService();
	DAOGerant daoGerant = new DAOGerant();
	DAOConseiller daoConseiller = new DAOConseiller();
	
	@Test public void testIdentificationGerantValide()
	{
		assertEquals(this.identServ.verficationMotDePasse("5", "supermdp").getPrenom(), daoGerant.lireElementById("5").getPrenom());
		assertEquals(this.identServ.verficationMotDePasse("5", "supermdp").getNom(), daoGerant.lireElementById("5").getNom());
		assertEquals(this.identServ.verficationMotDePasse("5", "supermdp").getIdentifiant(), daoGerant.lireElementById("5").getIdentifiant());
		assertEquals(this.identServ.verficationMotDePasse("5", "supermdp").getMotDePasse(), daoGerant.lireElementById("5").getMotDePasse());
		assertEquals(this.identServ.verficationMotDePasse("5", "supermdp").getClass(), daoGerant.lireElementById("5").getClass());
	}
	
	@Test public void testIdentificationConseillerValide()
	{
		assertEquals(this.identServ.verficationMotDePasse("c1", "monmotdepasse"), daoConseiller.lireElementById("c1"));
		
		assertEquals(this.identServ.verficationMotDePasse("c1", "supermdp").getPrenom(), daoGerant.lireElementById("5").getPrenom());
		assertEquals(this.identServ.verficationMotDePasse("c1", "supermdp").getNom(), daoGerant.lireElementById("5").getNom());
		assertEquals(this.identServ.verficationMotDePasse("c1", "supermdp").getIdentifiant(), daoGerant.lireElementById("5").getIdentifiant());
		assertEquals(this.identServ.verficationMotDePasse("c1", "supermdp").getMotDePasse(), daoGerant.lireElementById("5").getMotDePasse());
		assertEquals(this.identServ.verficationMotDePasse("c1", "supermdp").getClass(), daoGerant.lireElementById("5").getClass());
	}
	
	@Test public void testIdentificationNonValide()
	{
		assertEquals(this.identServ.verficationMotDePasse("t874S", "cMoiKeChuiLeMeyer"), null);
	}
}