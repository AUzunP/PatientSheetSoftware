package weekSheet;

import java.util.EventObject;

public class WeekScreenEvent extends EventObject {

	private String month;
	private String year;
	
	public WeekScreenEvent(Object source, String month, String year) {
		super(source);
		
		this.month = month;
		this.year = year;
		
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getYear() { 
		return year;
	}
	
}
