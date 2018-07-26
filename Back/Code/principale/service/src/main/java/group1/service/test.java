package group1.service;

import java.util.ArrayList;

import domaine.main.Client;
import domaine.main.Conseiller;

public class test {

	public static void main(String[] args) {
	ConseillerService conseillerService = new ConseillerService();	
		
		Conseiller conseiller = conseillerService.recupererConseillerParId("1");
		
		ClientService clientService = new ClientService();
		ArrayList<Client> listeClient = clientService.retournerListeClient(conseiller);
		
		
		for (Client client : listeClient) {
		System.out.println(client);}
		

	}

}
