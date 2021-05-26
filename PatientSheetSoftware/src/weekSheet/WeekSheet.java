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
	private static int[] numDaysMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public WeekSheet() {

		this.setLayout(new GridBagLayout());

	}

	public static String weekNumber(int weekNum, int year) {

		// Return week given week number
		Calendar calendar = Calendar.getInstance();
		calendar.setWeekDate(year, weekNum, 2);
		java.util.Date da = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd");
		String fDate = dateFormat.format(da);

		//System.out.println("Week " + Integer.toString(weekNum) + " of " + year + " corresponds to: " + fDate);
		
		return fDate;
	}

	public static int getCurrentWeek() {
		LocalDate date = LocalDate.now();
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		return date.get(weekFields.weekOfWeekBasedYear());
	}

	public static int[] getNumberedDays(int month, int numDay) {

		int[] numberedDays = new int[7];

		//System.out.println("The month is " + month + " and max days are " + numDaysMonth[month-1]);
		
		for (int i = 0; i < 7; i++) {
			
			if (numDay > numDaysMonth[month-1]) {
				numDay = 1;
			}
			
			numberedDays[i] = numDay;
			numDay++;
			
		}
		
//		// add correct day numbers to array
//		for (int i = 0; i < 7; i++) {
//			numberedDays[i] = numDay;
//			// if day is higher than the maximum amount of days in the given month, reset to 1
//			if (!(numDay > numDaysMonth[month - 1])) {
//				numDay++;
//			} else {
//				numDay = 1;
//			}
//		}

		return numberedDays;
	}

}
