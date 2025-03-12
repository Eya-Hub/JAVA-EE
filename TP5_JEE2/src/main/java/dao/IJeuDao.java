package dao;

import java.util.List;
import metier.entities.Jeu;

public interface IJeuDao {
	public Jeu save(Jeu j);

	public List<Jeu> jeuxParMC(String mc);

	public Jeu getJeu(Long id);

	public Jeu updateJeu(Jeu j);

	public void deleteJeu(Long id);
}
