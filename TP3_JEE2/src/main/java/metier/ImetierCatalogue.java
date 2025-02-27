package metier;

import java.util.List;

public interface ImetierCatalogue {
	public List<Jeux> getJeuxParMotCle(String mc);

	public void addJeux(Jeux j);
}