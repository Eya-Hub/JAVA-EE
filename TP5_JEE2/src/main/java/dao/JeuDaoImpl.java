package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Jeu;
import util.JPAutil;

public class JeuDaoImpl implements IJeuDao {
	private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE2");
	
	@Override
	public Jeu save(Jeu j) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(j);
		tx.commit();
		return j;
	}

	@Override
	public List<Jeu> jeuxParMC(String mc) {
		List<Jeu> games =
				entityManager.createQuery("select j from Jeu j where j.nomJeu like :mc").setParameter("mc", "%"+mc+"%")
				.getResultList();
		return games;
	}

	@Override
	public Jeu getJeu(Long id) {
		return entityManager.find(Jeu.class, id);
	}

	@Override
	public Jeu updateJeu(Jeu j) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(j);
		tx.commit();
		return j;
	}

	@Override
	public void deleteJeu(Long id) {
		Jeu game = entityManager.find(Jeu.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(game);
		entityManager.getTransaction().commit();
	}
}
