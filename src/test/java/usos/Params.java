package usos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

class Params {
	private static Params instance = null;

	   public static Params getInstance() {
	      if(instance == null) {
	         instance = new Params();
	      }
	      return instance;
	   }
	   
	   private static String parametersPatch = "src\\test\\java\\usos\\usosTests.properties";
	   private  Properties prop;
	   
	   protected Params() {
		   prop = new Properties();
			InputStream input = null;

			try {

				input = new FileInputStream(parametersPatch);

				// load a properties file
				prop.load(input);
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	   }
	   
	   protected String get(String name) {
		   return prop.getProperty(name);
	   }
}
