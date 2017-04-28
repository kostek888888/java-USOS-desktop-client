import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import database.Test;
import usos.LoginInvalidCredentialsException;
import usos.UsosManager;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		
		//LoginWindow loginObj = new LoginWindow();
		
		//Test test = new Test();
		//test.test();
		
		/*
		Connection conn;
		
		String dbUrl = "jdbc:derby:database;create=true";
	    conn = DriverManager.getConnection(dbUrl);
		
	    Statement stmt = conn.createStatement();
	    stmt.executeUpdate("Create table users (id int primary key, name varchar(30))");
		
	    // insert 2 rows
	    stmt.executeUpdate("insert into users values (1,'tom')");
	    stmt.executeUpdate("insert into users values (2,'peter')");
	 
	    // query
	    ResultSet rs = stmt.executeQuery("SELECT * FROM users");
		 
	    while (rs.next()) { 
	        System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
	    }
		*/
		
		
		
		
		
		/*
		UsosManager usosManager = new UsosManager();

		try {
			usosManager.login("94070910750", "qwertyqwerty");
			System.out.println("Zalogowano");
		} catch (LoginInvalidCredentialsException e) {
			System.out.println("Niepoprawne dane logowania");
		}
		*/

		
		
		
		
	}

}
