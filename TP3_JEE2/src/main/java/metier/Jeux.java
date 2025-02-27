package metier;

import java.io.Serializable;

public class Jeux implements Serializable {
	private Long idJeux;
	private String nomJeux;
	private double prix;

	public Jeux() {
		super();
	}

	public Jeux(String nomJeux, double prix) {
		super();
		this.nomJeux = nomJeux;
		this.prix = prix;
	}

	public Long getIdJeux() {
		return idJeux;
	}

	public void setIdJeux(Long idJeux) {
		this.idJeux = idJeux;
	}

	public String getNomJeux() {
		return nomJeux;
	}

	public void setNomJeux(String nomJeux) {
		this.nomJeux = nomJeux;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Jeux [idJeu=" + idJeux + ", nomJeu=" + nomJeux + ", prix=" + prix + "]";
	}
	
	
}