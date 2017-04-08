package usos;
import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import usos.helper.Semester;
import usos.helper.Subject;
import usos.helper.TypeOfClass;
import usos.helper.mark.Mark;
import usos.helper.mark.MarkFactory;

public class UsosMarksManager {
	
	static protected String MARKS_URL = "https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index";
	
	protected String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	
	private MarkFactory markFactory;
	
	UsosMarksManager() {
		markFactory = new MarkFactory();
	}
	
	
	public void getMarks(String sessionId) throws IOException {
		Document markDocument = this.getMarksDocument(sessionId);
		this.getLastSemester(markDocument);
	}
	
	private Document getMarksDocument(String sessionId) throws IOException {
		
		Response oceny = Jsoup.connect("https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index")
				.userAgent(this.userAgent)
				.header("Host", "usosweb.tu.kielce.pl")
				.header("Upgrade-Insecure-Requests", "1")
				.cookie("PHPSESSID", sessionId)
				.followRedirects(false) 
				.execute();
		
		return oceny.parse();
	}
	
	private Semester getLastSemester(Document markDocument) {
		//System.out.println(markDocument);
		
		Element tableWithMarks = markDocument.select("#layout-c22a > div > table.grey").first();
		
		Semester semester = new Semester();
		semester.setName(this.getSemesterName(tableWithMarks));
		
		Elements trsWithMarksData = tableWithMarks.select("#tab1 > tr");
		
		for(Element trWithMarkData : trsWithMarksData) {
			this.addDataToSemester(semester, trWithMarkData);
		}
		
		return semester;
	}
	
	private void addDataToSemester(Semester semester, Element trWithMarkData) {
		Subject subject = new Subject();
		
		String nameSubject = trWithMarkData.select("td:nth-child(1) > a").first().html();
		subject.setName(nameSubject);
		
		Elements trsWithMarks = trWithMarkData.select("td:nth-child(3)");
		
		for(Element trWithMarks : trsWithMarks) {
			
			this.addTypeOfClassToSubject(subject, trWithMarks);
		}
		
		semester.addSubject(subject);
		
	}
	
	private void addTypeOfClassToSubject(Subject subject, Element trWithMarks) {

		Elements divsWithMarks = trWithMarks.select("div");
		
		for(Element divWithMarks : divsWithMarks) {			
			TypeOfClass typeOfClass = new TypeOfClass();
			
			String typeOfClassName = divWithMarks.select("a").first().text();
			typeOfClass.setName(typeOfClassName);
			
			this.addMarksToTypeOfClass(typeOfClass, divWithMarks);
			
			subject.addTypeOfClass(typeOfClass);
		}
	}
	
	private void addMarksToTypeOfClass(TypeOfClass typeOfClass, Element divWithMarks) {  
		
		for(Element span : divWithMarks.select("span")) {
			String markStringFromHtml = span.html();
						
			Mark mark = markFactory.createMarkByUsosString(markStringFromHtml);
			
			if(markFactory.markIsMainMark(markStringFromHtml)) {
				typeOfClass.setMainMark(mark);
			}else {
				typeOfClass.addOldMarks(mark);
			}
		}
	}
	
	private String getSemesterName(Element tableWithMarks) {
		Element rowWithNameSemester = tableWithMarks.select("tbody:nth-child(1) > tr > td").first();
		rowWithNameSemester.select("a").remove();
		return rowWithNameSemester.text().replaceAll("-", "").trim(); // w nazwie jest myślnik, wywalamy go
	}
	
}
