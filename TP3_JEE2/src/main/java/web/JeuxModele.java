package web;

import java.util.ArrayList;
import java.util.List;
import metier.Jeux;

public class JeuxModele {
	private String motCle;
	List<Jeux> jeux = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Jeux> getJeux() {
		return jeux;
	}

	public void setJeux(List<Jeux> jeux) {
		this.jeux = jeux;
	}
}
