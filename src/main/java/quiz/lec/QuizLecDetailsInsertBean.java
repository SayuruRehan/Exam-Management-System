package quiz.lec;

public class QuizLecDetailsInsertBean {
	private String faculty;
	private String year;
	private String mcode;
	private String enrollKey;
	private String quizPass;
	
	
	public QuizLecDetailsInsertBean(String faculty, String year, String mcode, String enrollKey, String quizPass) {
		this.faculty = faculty;
		this.year = year;
		this.mcode = mcode;
		this.enrollKey = enrollKey;
		this.quizPass = quizPass;
	}
	
	
	public String getFaculty() {
		return faculty;
	}
	public String getYear() {
		return year;
	}
	public String getMcode() {
		return mcode;
	}
	public String getEnrollKey() {
		return enrollKey;
	}
	public String getQuizPass() {
		return quizPass;
	}
	
	
}
