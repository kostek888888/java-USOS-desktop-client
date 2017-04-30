package usos.database;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	
	public boolean checkChangeInMarks(Semester semester) {
		//@todo  
		return true;
	}
	
	public void saveSemester(Semester semester, String login) {
		Session session = sessionFactory.openSession();
		session.save( new Element(login, gson.toJsonTree(semester).toString() , new Date() ) );
		session.close();
	}
}
