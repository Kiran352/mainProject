package com.xworkz.project2.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.entity.RegisterEntity;

@Component
public class ResetPasswordDaoImpl implements ResetPasswordDao {

	private static final Logger logger = Logger.getLogger(ResetPasswordDaoImpl.class);
	
	
	@Autowired
	SessionFactory factory;
	Session session = null;

	public ResetPasswordDaoImpl() {
		super();
		logger.info("Object created \t" + this.getClass().getSimpleName());
	}

	@Override
	public boolean checkUserExist(String email) {
		logger.info("inside the user exist method");
		
		try {
			session = factory.openSession();
			Query namedQuery = session.getNamedQuery("fetchByEmail");
			namedQuery.setParameter("email", email);
			Object object = namedQuery.uniqueResult();
			RegisterEntity entity = (RegisterEntity) object;
			logger.info(entity);
			if (entity != null) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return false;
	}

	@Override
	public int updatePassword(String password, String email) {
		logger.info("inside password update method");
		int update = 0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query namedQuery = session.getNamedQuery("updatePassword");
			namedQuery.setParameter("password", password);
			namedQuery.setParameter("email", email);
			update = namedQuery.executeUpdate();
			session.getTransaction().commit();
			logger.info("After password updation"+update);

		} catch (Exception e) {
		   logger.info(e.getMessage());
		}

		return update;
	}

	@Override
	public int updateLoginCount(String email, int count) {
		logger.info("inside the update login count method");
		
		int update = 0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query namedQuery = session.getNamedQuery("updateLoginCount");

			namedQuery.setParameter("email", email);
			namedQuery.setParameter("count",count);
			update = namedQuery.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return update;
	}

}
