package metier.entities;

import java.io.Serializable;

public class Jeu implements Serializable {
	private Long idJeu;
	private String nomJeu;
	private double prix;

	public Jeu() {
		super();
	}

	public Jeu(String nomJeu, double prix) {
		super();
		this.nomJeu = nomJeu;
		this.prix = prix;
	}

	public Long getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(Long idJeu) {
		this.idJeu = idJeu;
	}

	public String getNomJeu() {
		return nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Jeu [idJeu=" + idJeu + ", nomJeu=" + nomJeu + ", prix=" + prix + "]";
	}
	
	
}