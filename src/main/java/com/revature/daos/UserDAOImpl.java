package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getByUserName(String username) {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, username);
		return user;
	}

	@Override
	public void createUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();

	}

	@Override
	public void updateUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(user);
		tx.commit();

	}

	@Override
	public void deleteUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

}
