package dao;

import java.util.ArrayList;

public interface IDAOGenerique<ElementBase>
{
	//CRUD
	public void creerElement(ElementBase element);
	public ElementBase lireElementById(String id);
	public ArrayList<ElementBase> toutLireElement();
	public void modifierElementById(int id, ElementBase element);
	public void supprimerElementById(int id);
}
