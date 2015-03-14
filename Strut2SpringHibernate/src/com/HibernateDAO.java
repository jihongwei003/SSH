package com;

//import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDAO implements DaoInter {

	// public void addUser(User o) {
	// // 1初始化，读取配置文件hibernate.cfg.xml
	// Configuration config = new Configuration().configure();
	// // 2读取创建sessionFactory
	// SessionFactory sessionFactory = config.buildSessionFactory();
	// // 3打开session
	// Session session = sessionFactory.openSession();
	// Transaction tx = null;
	//
	// try {
	// // 4开始一个事务
	// tx = session.beginTransaction();
	// // 5持久化操作
	// session.save(o);
	// // 6提交事务
	// tx.commit();
	//
	// } catch (Exception e) {
	// if (tx != null) {
	// // 回滚
	// tx.rollback();
	// }
	// e.printStackTrace();
	// } finally {
	// // 7关闭session
	// session.close();
	// }
	// }

	public boolean testLoad(User u) {
		// 1初始化，读取配置文件hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 2读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3打开session
		Session session = sessionFactory.openSession();
		// 4加载数据
		User user = (User) session.get(User.class, new Integer(2));

		System.out.println("this is DAO layer:hibernateDAO");

		if (user.getLoginName().equals(u.getLoginName())) {
			System.out.println("hibernateDAO return true");
			return true;
		} else {
			System.out.println("hibernateDAO return false");
			return false;
		}

		// System.out.println(user.getLoginName() + " " + user.getLoginPwd());
	}

	// private void testDelete() {
	// // 1初始化，读取配置文件hibernate.cfg.xml
	// Configuration config = new Configuration().configure();
	// // 2读取创建sessionFactory
	// SessionFactory sessionFactory = config.buildSessionFactory();
	// // 3打开session
	// Session session = sessionFactory.openSession();
	// Transaction tx = null;
	//
	// Users user = (Users) session.get(Users.class, new Integer(1));
	// try {
	// tx = session.beginTransaction();
	// session.delete(user);
	// tx.commit();
	// } catch (Exception e) {
	// if (tx != null) {
	// tx.rollback();
	// }
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }
	// }

	// private void testUpdate() {
	// // 1初始化，读取配置文件hibernate.cfg.xml
	// Configuration config = new Configuration().configure();
	// // 2读取创建sessionFactory
	// SessionFactory sessionFactory = config.buildSessionFactory();
	// // 3打开session
	// Session session = sessionFactory.openSession();
	// Transaction tx = null;
	//
	// Users user = (Users) session.get(Users.class, new Integer(2));
	// //修改数据
	// user.setLoginName("jihongwei");
	// try {
	// tx = session.beginTransaction();
	// session.update(user);
	// tx.commit();
	// } catch (Exception e) {
	// if (tx != null) {
	// tx.rollback();
	// }
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }
	// }
}
