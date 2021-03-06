package usos;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import usos.helper.Semester;
import usos.helper.Subject;
import usos.helper.TypeOfClass;

public class UsosMarksManagerTest {
	
	static private UsosLoginManager usosLoginManager;
	static private UsosMarksManager usosMarksManager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usosLoginManager = new UsosLoginManager();
		usosLoginManager.turnOnTestMode("http://31.178.72.165:8080/javaUSOSpskMock");
		
		usosLoginManager.login("test", "qwerty");
		
		usosMarksManager = new UsosMarksManager();
		usosMarksManager.turnOnTestMode("http://31.178.72.165:8080/javaUSOSpskMock");
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		usosLoginManager.logout();
	}

	@Test
	public void testGetMarksForLastSemester() throws IOException {
		
		Semester semester = usosMarksManager.getMarksForLastSemester(usosLoginManager.getSessionId());
		
		assertEquals(semester.getName(), "Semestr zimowy 2016/17");
		
		List<Subject> subjects = semester.getSubjects();
		
		
		
		// amia test
		Subject amia = subjects.get(0);
		Map<TypeOfClass.type, TypeOfClass> typesOfClassAmia = amia.getTypesOfClass();
		
		TypeOfClass amiaLecture = typesOfClassAmia.get(TypeOfClass.type.LECTURE);
		assertEquals(amiaLecture.getName(), "Wykłady");
		assertEquals(amiaLecture.getMainMark().getValueMark(), new BigDecimal("2"));
		assertEquals(amiaLecture.getOldMarks().get(0).getValueMark(), new BigDecimal("2"));
		assertEquals(amiaLecture.getOldMarks().size(), 1);
		
		TypeOfClass amiaClasses = typesOfClassAmia.get(TypeOfClass.type.CLASSES);
		assertEquals(amiaClasses.getName(), "Ćwiczenia");
		//assertEquals(amiaClasses.getMainMark().getValueMark(), new BigDecimal("3"));
		assertEquals(amiaClasses.getOldMarks().size(), 0);

		
		// SD test
		Subject sd = subjects.get(7);
		Map<TypeOfClass.type, TypeOfClass> typesOfClassDs = sd.getTypesOfClass();
		 
		TypeOfClass sdLecture = typesOfClassDs.get(TypeOfClass.type.LECTURE);
		assertEquals(sdLecture.getMainMark().getValueMark(), new BigDecimal("2")); 
		assertEquals(sdLecture.getOldMarks().size(), 2);
		assertEquals(sdLecture.getOldMarks().get(0).getValueMark(), new BigDecimal("2"));
		assertEquals(sdLecture.getOldMarks().get(1).getValueMark(), new BigDecimal("2"));
		
		TypeOfClass sdLlaboratory = typesOfClassDs.get(TypeOfClass.type.LABOLATORY);
		assertEquals(sdLlaboratory.getOldMarks().size(), 0);
		assertEquals(sdLlaboratory.getMainMark().getValueMark(), new BigDecimal("3.5")); 
	}

}
