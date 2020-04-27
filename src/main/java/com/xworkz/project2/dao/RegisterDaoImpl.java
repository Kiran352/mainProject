package com.xworkz.project2.dao;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.entity.RegisterEntity;

@Component
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	SessionFactory factory;

	public RegisterDaoImpl() {
		super();
		System.out.println("Object created \t" + this.getClass().getSimpleName());
	}

	@Override
	public boolean readUid(String uId) {
		System.out.println("inside the read uid method");
		Session session;
		boolean status = false;
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("SELECT e from RegisterEntity e where e.usrId=:uId");
			query.setParameter("uId", uId);
			Object result = query.uniqueResult();
			entity = (RegisterEntity) result;
			System.out.println("inside the read id" + entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (Objects.nonNull(entity)) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean readEmail(String email) {
		System.out.println("inside the read mail method");

		Session session;
		boolean status = false;
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("SELECT e from RegisterEntity e where e.email=:email");
			query.setParameter("email", email);
			Object result = query.uniqueResult();
			entity = (RegisterEntity) result;
			System.out.println("inside the read id" + entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (Objects.nonNull(entity)) {
			status = true;
		}
		return status;

	}

	@Override
	public boolean saveRegisterDto(RegisterEntity entity) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Serializable save = session.save(entity);
			System.out.println("added to db" + save);
			session.getTransaction().commit();

		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

}
