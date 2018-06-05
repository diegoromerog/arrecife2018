package co.com.sbd.registroeventos.repository;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSession {

	@Autowired
	private SessionFactory sessionFactory;	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
