package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Jeu;

public class JeuDaoImpl implements IJeuDao {
	@Override
	public Jeu save(Jeu j) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO jeux(nom,prix) VALUES(?,?)");
			ps.setString(1, j.getNomJeu());
			ps.setDouble(2, j.getPrix());
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM jeux");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				j.setIdJeu(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}

	@Override
	public List<Jeu> jeuxParMC(String mc) {
		List<Jeu> games = new ArrayList<Jeu>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from jeux where nom LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Jeu j = new Jeu();
				j.setIdJeu(rs.getLong("id"));
				j.setNomJeu(rs.getString("nom"));
				j.setPrix(rs.getDouble("prix"));
				games.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public Jeu getJeu(Long id) {
		Connection conn = SingletonConnection.getConnection();
		Jeu j = new Jeu();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from jeux where id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				j.setIdJeu(rs.getLong("id"));
				j.setNomJeu(rs.getString("nom"));
				j.setPrix(rs.getDouble("prix"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}

	@Override
	public Jeu updateJeu(Jeu j) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE jeux SET nom=?,prix=? WHERE id=?");
			ps.setString(1, j.getNomJeu());
			ps.setDouble(2, j.getPrix());
			ps.setLong(3, j.getIdJeu());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}

	@Override
	public void deleteJeu(Long id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM jeux WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
