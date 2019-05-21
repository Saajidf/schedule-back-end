import java.time.LocalDateTime;
import java.util.ArrayList;

public class Shift {
	
	private String summ;
	private String loc;
	private String desc;
	private LocalDateTime st;
	private LocalDateTime en;
	private ArrayList<String> emails;
	
	//Tip for LocalDateTime: use LocalDateTime.parse(String) to get the
	//correct date and time from a string
	public Shift(String summary, String location, String description, 
			LocalDateTime start, LocalDateTime end) {
		summ = summary;
		loc = location;
		desc = description;
		st = start;
		en = end;
		
		emails = new ArrayList<String>();
	}
	
	public void addEmployee(String email) {
		emails.add(email);
	}
	
	public String getSummary() {
		return summ;
	}
	
	public String getLocation() {
		return loc;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public LocalDateTime getStart() {
		return st;
	}
	
	public LocalDateTime getEnd() {
		return en;
	}
	
	public ArrayList<String> getEmails(){
		return emails;
	}
}

