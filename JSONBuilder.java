import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class JSONBuilder {
	
	//date format used by the JSON
	public static final DateTimeFormatter DATE_FORMAT = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss-'04:00'");
	
	@SuppressWarnings("unchecked")
	public static void writeToJSON(Shift[] shifts) {
		
		JSONArray shiftList = new JSONArray();
		
		//create json array from shifts
		for(Shift s : shifts) {
			JSONObject shiftObject = new JSONObject();
			
			shiftObject.put("summary", s.getSummary());
			shiftObject.put("location", s.getLocation());
			shiftObject.put("description", s.getDescription());
			shiftObject.put("start", s.getStart().format(DATE_FORMAT));
			shiftObject.put("end", s.getEnd().format(DATE_FORMAT));
	
			JSONArray emailList = new JSONArray();
			ArrayList<String> emails = s.getEmails();
			for(String e : emails) {
				emailList.add(e);
			}
			
			shiftObject.put("attendee", emailList);
			
			shiftList.add(shiftObject);
		}
		
		//Write JSON file
		try (FileWriter file = new FileWriter("all_shifts.json")) {

			file.write(shiftList.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		
		
		String summary = "Google I/O 2015";
		String location = "800 Howard St., San Francisco, CA 94103";
		String description = "testing";
		LocalDateTime start = LocalDateTime.parse("2019-05-20T09:00:00");
		LocalDateTime end = LocalDateTime.parse("2019-05-20T17:00:00");
		
		Shift s1 = new Shift(summary, location, description, start, end);
		s1.addEmployee("lpage@example.com");
		s1.addEmployee("sbrin@example.com");
		
		description = "testing2";
		
		Shift s2 = new Shift(summary, location, description, start, end);
		s2.addEmployee("lpage@example.com");
		s2.addEmployee("sbrin@example.com");
		
		Shift[] shifts = {s1, s2};
		
		writeToJSON(shifts);
		
	}
}
