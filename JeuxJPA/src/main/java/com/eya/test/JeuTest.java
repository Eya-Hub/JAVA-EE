package com.eya.test;

import com.eya.dao.JeuDao;
import com.eya.entities.Jeu;

public class JeuTest {

	public static void main(String[] args) {
		

		Jeu j = new Jeu();
		j.setNom("Resident Evil");
		j.setPublisher("out");
		j.setPrix(299);
		
		Jeu j1 = new Jeu();
		j1.setNom("Crush bandicoot");
		j1.setPublisher("out");
		j1.setPrix(299);
		
		Jeu j2 = new Jeu();
		j2.setNom("Sonic Dash");
		j2.setPublisher("out");
		j2.setPrix(299);
		
		
		JeuDao jeuDao = new JeuDao();
		jeuDao.ajouter(j);
		jeuDao.ajouter(j1);
		jeuDao.ajouter(j2);
		
		
		System.out.println("Appel de la méthode supprimer");
		jeuDao.supprimer(j2);
		
		/*System.out.println("Appel de la méthode consulter");
		jeuDao.consulter(j,1);*/
		
		
		System.out.println("Appel de la méthode modifier");
		jeuDao.modifier(j1);
		
		
		System.out.println("Appel de la méthode listerTous");
		for (Jeu gm : jeuDao.listerTous())
			System.out.println(gm);
		
		System.out.println("Appel de la méthode listerParNom");
		for (Jeu gm : jeuDao.listerParNom("Silent"))
			System.out.println(gm);

	}

}
