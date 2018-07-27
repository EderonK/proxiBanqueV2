package dao;

import java.util.ArrayList;
/**
 * @author Groupe 1
 * @version 0.1
 *
 */
public interface IDAOGenerique<ElementBase>
{
	//CRUD
	/**
	 * 
	 * La - méthode creerElement(ElementBase element) prend en paramètre les éléments d'une base correspondant
	 *
	 */
	public void creerElement(ElementBase element);
	/**
	 * 
	 * La - méthode lireElementById(String id) prend en paramètre un élément sélectionné par son id
	 */
	public ElementBase lireElementById(String id);
	/**
	 * 
	 * La - méthode getNomTable() retourne un null
	 *
	 */
	public ArrayList<ElementBase> toutLireElement();
	/**
	 * 
	 * La - méthode modifierElementById(int id, ElementBase element) permet modifier un élément identifié par son ID dans la base correspondante
	 *
	 */
	public void modifierElementById(int id, ElementBase element);
	/**
	 * 
	 * La - méthode supprimerElementById(int id) supprime un élément identifié par son ID
	 *
	 */
	public void supprimerElementById(int id);
}
