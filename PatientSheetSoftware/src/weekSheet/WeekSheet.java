package weekSheet;

import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JPanel;

public class WeekSheet extends JPanel {

	private String[] weeks;
	private int currYear = Calendar.getInstance().get(Calendar.YEAR);
	private int finYear = currYear;
	private ArrayList<String> weeksAList = new ArrayList<String>();

	public WeekSheet() {

		this.setLayout(new GridBagLayout());

	}

	public static String weekNumber(int weekNum, int year) {
    	
		//Return week given week number
      	Calendar calendar = Calendar.getInstance();
      	calendar.setWeekDate(year, weekNum, 2);
      	java.util.Date da = calendar.getTime();
      	DateFormat dateFormat = new SimpleDateFormat("MM/dd");
      	String fDate = dateFormat.format(da);
      	
      	System.out.println("Week " + Integer.toString(weekNum) + " of " + year + " corresponds to: " + fDate);
      	
      	return fDate;
    }
	
//	private void writeWeeks(int yearUse) {
//
//		weeksAList.clear();
//
//		for (int i = 1; i < 54; i++) {
//			weeksAList.add("Week " + Integer.toString(i) + " : " + weekNumber(i, yearUse));
//		}
//		weeks = new String[weeksAList.size()];
//
//		// ArrayList to Array
//		for (int i = 0; i < weeksAList.size(); i++) {
//			weeks[i] = weeksAList.get(i);
//		}
//		
//	}

	public static int getCurrentWeek() {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }
	
}
