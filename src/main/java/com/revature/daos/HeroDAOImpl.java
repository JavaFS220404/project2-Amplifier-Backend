package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Hero;
import com.revature.utils.HibernateUtil;

public class HeroDAOImpl implements HeroDAO{

	@Override
	public List<Hero> getAllHeroes() {
		Session session = HibernateUtil.getSession();
		List<Hero> heroes = session.createQuery("FROM Hero").list();
		return heroes;
	}

	@Override
	public Hero getHeroById(int id) {
		Session session = HibernateUtil.getSession();
		Hero hero = session.get(Hero.class, id);
		return hero;
	}

	@Override
	public void addHero(Hero hero) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(hero);
		tx.commit();
	}

	@Override
	public void update(Hero hero) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(hero);
		tx.commit();
	}

	@Override
	public void delte(Hero hero) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(hero);
		tx.commit();	
	}
}
