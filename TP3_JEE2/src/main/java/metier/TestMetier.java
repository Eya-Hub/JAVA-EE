package metier;

import java.util.List;

public class TestMetier {
	public static void main(String[] args) {
		MetierImpl metier = new MetierImpl();
		List<Jeux> games = metier.getJeuxParMotCle("Si");
		for (Jeux j : games)
			System.out.println(j);
	}
}