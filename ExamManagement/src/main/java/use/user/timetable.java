package use.user;

public class timetable {
	private int ttID;
	private String faculty;
	private String year;
	private String timetable;

	
	public timetable(int ttID, String faculty, String year, String timetable) {
		
		this.ttID = ttID;
		this.faculty = faculty;
		this.year = year;
		this.timetable = timetable;

	}


	public int getTtID() {
		return ttID;
	}


	public String getFaculty() {
		return faculty;
	}


	public String getYear() {
		return year;
	}


	public String getTimetable() {
		return timetable;
	}


}
