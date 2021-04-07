package patient;

public class DayNote {

	private String day;
	private int note;
	
	public DayNote(String day, int note) {
		
		this.day = day;
		this.note = note;
		
	}
	
	// Override in order to make getNotes method in Patient work as intended
	@Override
	public String toString() {
		
		String dayNoteString = day + ":" + note;
		return dayNoteString;
		
	}
	
	public String getDay() {
		return this.day;
	}
	
	public int getNote() {
		return this.note;
	}
	
}
