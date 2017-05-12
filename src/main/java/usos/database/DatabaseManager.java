package usos.database;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.google.gson.Gson;

import usos.helper.Semester;

public class DatabaseManager {

	private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	protected void finalize() {
		close();
	}
	
	public void close() {
		sessionFactory.close();
	}
	
	SessionFactory sessionFactory = buildSessionFactory();
	Gson gson = new Gson();
	
	public void saveSemester(Semester semester, String login) {
		Session session = sessionFactory.openSession();
		
		session.save( new Element(login, gson.toJsonTree(semester).toString() , new Date() ) );
		session.close();
	}
	
	public Element getLastSemester(String login) {
		Session session = sessionFactory.openSession();
		Element element = (Element) session.createQuery("FROM Element WHERE login = :login ORDER BY date DESC")
		.setMaxResults(1)
		.setParameter("login",login)
		.uniqueResult();
		
		session.close();
		return element;
	}
	
	public boolean checkChangesInMarks(Semester semester, String login) {
		
		String dataString = gson.toJsonTree(semester).toString();
		
		Session session = sessionFactory.openSession();
		Element element = this.getLastSemester(login);
		session.close();
		
		if(element == null) {
			return true;
		}
		 
		return (element.getData().compareTo(dataString) != 0); 
	}
}