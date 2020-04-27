package com.xworkz.project2.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.entity.RegisterEntity;

@Component
public class LoginDaImpl implements LoginDao {

	@Autowired
	SessionFactory factory;
	Session session = null;

	int count;

	public LoginDaImpl() {
		super();
		System.out.println("Object created \t" + this.getClass().getSimpleName());
	}

	@Override
	public int countOnEmail(String email) {
		RegisterEntity entity;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("select ent from RegisterEntity ent where ent.email=:email");
			query.setParameter("email", email);
			Object object = query.uniqueResult();
			entity = (RegisterEntity) object;
			if (Objects.nonNull(object)) {
				count = 1;
			} else {
				count = 0;
			}

			System.out.println(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public RegisterEntity readPasswordByEmail(String email) {
		System.out.println("Inside the read password method");
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("select ent from RegisterEntity ent where ent.email=:email");
			query.setParameter("email", email);
			Object object = query.uniqueResult();
			entity = (RegisterEntity) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public void updatePasswordCount(int count, String email) {

		System.out.println("Inside the update password count");
		System.out.println(count);
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("update  RegisterEntity ent set ent.login_count=:count where ent.email=:email");
			query.setParameter("email", email);
			query.setParameter("count", count);
			int update = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println(update);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
