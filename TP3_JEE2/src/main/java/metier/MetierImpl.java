package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue {
	@Override
	public List<Jeux> getJeuxParMotCle(String mc) {
		List<Jeux> games = new ArrayList<Jeux>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from jeux where nom LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Jeux j = new Jeux();
				j.setIdJeux(rs.getLong("id"));
				j.setNomJeux(rs.getString("nom"));
				j.setPrix(rs.getDouble("prix"));
				games.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public void addJeux(Jeux j) {
		// TODO Auto-generated method stub
	}
}