package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import patient.DayNote;
import patient.Patient;
import weekSheet.WeekSheet;

public class MainFrame extends JFrame{

	public MainFrame() {
		
		super("Patient Sheet Software");
		
		setLayout(new BorderLayout());
		
		// (x, y)
		setMinimumSize(new Dimension(1200, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		setVisible(true);
		
		ArrayList<DayNote> testPatientnotes = new ArrayList<DayNote>();
		
		ArrayList<String> testPatientDiagnoses = new ArrayList<String>();
		testPatientDiagnoses.add("hypertension");
		testPatientDiagnoses.add("hyperlipidemia");
		testPatientDiagnoses.add("UTI");
		
		ArrayList<String> testPatientCodes = new ArrayList<String>();
		testPatientCodes.add("I10");
		testPatientCodes.add("E78.5");
		testPatientCodes.add("N39.0");
		
		Patient testPatient = new Patient("testPatient", testPatientnotes, testPatientDiagnoses, testPatientCodes);
		testPatient.addNote("12/1/21", 32);
		testPatient.addNote("12/2/21", 33);
		testPatient.addNote("12/3/21", 39);
		
		System.out.println("Before: " + testPatient.getNotes());
		
		testPatient.removeNote("12/3/21");
		
		System.out.println("After: " + testPatient.getNotes());
		
		testPatient.printCodes();
		testPatient.printDiagnoses();
		
		WeekSheet.weekNumber(4, 2021);
		WeekSheet.getCurrentWeek();
		
	}
	
}
