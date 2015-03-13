package com.hibtest1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibtest1.entity.Users;

public class Test {
	public static void main(String[] args) {

		Test test = new Test();

		// test.addUser();
		// test.testLoad();
		// test.testDelete();	
		test.testUpdate();
	}

	private void addUser() {
		// 建立持久化对象
		Users user = new Users();
		user.setLoginName("zhangsan");
		user.setLoginPwd("123");

		// 1初始化，读取配置文件hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 2读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3打开session
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			// 4开始一个事务
			tx = session.beginTransaction();
			// 5持久化操作
			session.save(user);
			// 6提交事务
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				// 回滚
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// 7关闭session
			session.close();
		}
	}

	private void testLoad() {
		// 1初始化，读取配置文件hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 2读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3打开session
		Session session = sessionFactory.openSession();
		// 4加载数据
		Users user = (Users) session.get(Users.class, new Integer(1));

		System.out.println(user.getLoginName() + " " + user.getLoginPwd());
	}

	private void testDelete() {
		// 1初始化，读取配置文件hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 2读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3打开session
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Users user = (Users) session.get(Users.class, new Integer(1));
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void testUpdate() {
		// 1初始化，读取配置文件hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 2读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3打开session
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Users user = (Users) session.get(Users.class, new Integer(2));
		//修改数据
		user.setLoginName("jihongwei");
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
