package test;

import java.util.List;

import dao.JeuDaoImpl;
import metier.entities.Jeu;

public class TestMetier {
	public static void main(String[] args) {
		JeuDaoImpl pdao = new JeuDaoImpl();
		Jeu game = pdao.save(new Jeu("resident evil", 800));
		System.out.println(game);
		List<Jeu> games = pdao.jeuxParMC("sil");
		for (Jeu j : games)
			System.out.println(j);
	}
}