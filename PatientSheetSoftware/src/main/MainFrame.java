package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import customComponents.CustomMenuBar;
import weekSheet.WeekScreen;
import weekSheet.WeekSheet;

public class MainFrame extends JFrame{

	WeekScreen weekScreen;
	
	public MainFrame() {
		
		super("Patient Sheet Software");
		
		setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());
		
		// (x, y)
		setMinimumSize(new Dimension(1000, 1000));
		setPreferredSize(new Dimension(1000, 1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.revalidate();
		this.pack();
		this.repaint();
		this.setLocationRelativeTo(null);
		
		weekScreen = new WeekScreen();

		add(weekScreen, BorderLayout.CENTER);
		
		setVisible(true);
		
//		ArrayList<DayNote> testPatientnotes = new ArrayList<DayNote>();
//		ArrayList<String> testPatientDiagnoses = new ArrayList<String>();
//		testPatientDiagnoses.add("hypertension");
//		testPatientDiagnoses.add("hyperlipidemia");
//		testPatientDiagnoses.add("UTI");
//		
//		ArrayList<String> testPatientCodes = new ArrayList<String>();
//		testPatientCodes.add("I10");
//		testPatientCodes.add("E78.5");
//		testPatientCodes.add("N39.0");
//		
//		Patient testPatient = new Patient("testPatient", testPatientnotes, testPatientDiagnoses, testPatientCodes);
//		testPatient.addNote("12/1/21", 32);
//		testPatient.addNote("12/2/21", 33);
//		testPatient.addNote("12/3/21", 39);
//		
//		System.out.println("Before: " + testPatient.getNotes());
//		
//		testPatient.removeNote("12/3/21");
//		
//		System.out.println("After: " + testPatient.getNotes());
//		
//		testPatient.printCodes();
//		testPatient.printDiagnoses();
		
		WeekSheet.weekNumber(3, 2021);
		WeekSheet.getCurrentWeek();
		
		// FOR TESTING WEEKSHEET
		
//		for (int i = 1; i < 53; i++) {
//			
//			String date = WeekSheet.weekNumber(i, 2021);
//			
//			String month = date.substring(0, 2);
//			String day = date.substring(3, date.length());
//			
//			int[] test = WeekSheet.getNumberedDays(Integer.valueOf(month), Integer.valueOf(day));
//			
//			System.out.println(test[0] + " " + test[1] + " " + test[2] + " " + test[3] + " " + test[4] + " " + test[5] + " " + test[6]);			
//		}
		
	}
	
	private JMenuBar createMenuBar() {
		
		CustomMenuBar menuBar = new CustomMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu settingsMenu = new JMenu("Settings");
		JMenuItem tempSetting = new JMenuItem("Temp Setting...");
		
		settingsMenu.add(tempSetting);
		
		menuBar.add(fileMenu);
		menuBar.add(settingsMenu);
		
		return menuBar;
		
	}
	
}
