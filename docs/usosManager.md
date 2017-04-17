
# ============== przykład pobierania ocen z usosManager

```java
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import gui.LoginWindow;
import usos.LoginInvalidCredentialsException;
import usos.UsosManager;
import usos.helper.Semester;
import usos.helper.Subject;
import usos.helper.TypeOfClass;
import usos.helper.TypeOfClass.type;

public class Main {

	public static void main(String[] args) throws IOException {

		UsosManager usosManager = new UsosManager();

		try {
			usosManager.login("94070910750", "qwertyqwerty");
			System.out.println("Zalogowano"); 
			
			Semester lastSemester = usosManager.getMarksForLastSemester();
			System.out.println("semestr: "+lastSemester.getName()); 
			
			
			List<Subject> subjects = lastSemester.getSubjects();
			
			//wyświetlenie ocen z pierwszego przedmiotu:
			Subject firstSubject = subjects.get(0);
			System.out.println("semestr: "+firstSubject.getName()); 
			Map<type, TypeOfClass> typesOfClass = firstSubject.getTypesOfClass();
			for(Map.Entry<type, TypeOfClass> entry : typesOfClass.entrySet()) {
				
				//wyswietlanie po kolei ocen z każdych zajęć (ćwiczeń, labolatoriów itp)
				System.out.println(entry.getValue().getName()+" : "+entry.getValue().getMainMark().getStringMark()); 
				
			}
			
		} catch (LoginInvalidCredentialsException e) {
			System.out.println("Niepoprawne dane logowania");
		}

	}

}
```