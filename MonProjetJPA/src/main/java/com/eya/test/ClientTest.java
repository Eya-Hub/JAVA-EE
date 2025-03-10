package com.eya.test;

import com.eya.dao.ClientDao;
import com.eya.entities.Client;

public class ClientTest {

	public static void main(String[] args) {
		
		// créer un objet client
		Client c = new Client();
		c.setNom("Garali Eya");
		c.setVille("Nabeul");
		
		Client c1 = new Client();
		c1.setNom("Garali Achraf");
		c1.setVille("Nabeul");
		
		// ajouter l'objet client à la BD
		ClientDao cltDao = new ClientDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c1);
		
		System.out.println("Appel de la méthode listerTous");
		for (Client cl : cltDao.listerTous())
			System.out.println(cl);
		
		System.out.println("Appel de la méthode listerParNom");
		for (Client cl : cltDao.listerParNom("nadh"))
			System.out.println(cl);
		
		// tester les autres méthodes de la classe ClientDao

	}

}
