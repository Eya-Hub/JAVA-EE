package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Jeu;

public class JeuModele {
	private String motCle;
	List<Jeu> jeux = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Jeu> getJeux() {
		return jeux;
	}

	public void setJeux(List<Jeu> jeux) {
		this.jeux = jeux;
	}
}
