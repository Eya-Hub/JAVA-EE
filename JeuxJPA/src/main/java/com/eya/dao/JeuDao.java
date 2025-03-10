package com.eya.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.eya.entities.Jeu;
import com.eya.util.JPAutil;

public class JeuDao {
	private EntityManager entityManager = JPAutil.getEntityManager("JeuxJPA");

	// méthode ajouter d'une entité à la bd
	public void ajouter(Jeu j) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(j);
		tx.commit();
	}

	// méthode modifier d'une entité à partir de la bd
	public void modifier(Jeu j) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(j);
		tx.commit();
	}

	// méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Jeu j) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		j = entityManager.merge(j); // important
		entityManager.remove(j);
		tx.commit();
	}

	// méthode Consulter d'une entité à partir de la bd

	public Jeu consulter(Jeu j, Object id) {
		return entityManager.find(j.getClass(), id);
	}

	// méthode pour lister tous les objets à partir de la bd
	public List<Jeu> listerTous() {
		List<Jeu> games = entityManager.createQuery("select j from Jeu j").getResultList();
		return games;
	}

	// méthode pour lister tous les client dont le nom contient un
	// texte donné en paramètre (pnom)
	public List<Jeu> listerParNom(String nom) {
		List<Jeu> games = entityManager.createQuery("select j from Jeu j where j.nom like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();
		return games;
	}
}
