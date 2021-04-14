package patient;

import java.util.ArrayList;

public class Patient {

	private String name;
	private ArrayList<DayNote> notes;
	private ArrayList<String> diagnoses;
	private ArrayList<String> codes;

	public Patient(String name, ArrayList<DayNote> notes, ArrayList<String> diagnoses, ArrayList<String> codes) {

		this.name = name;
		this.notes = notes;
		this.diagnoses = diagnoses;
		this.codes = codes;

	}

	// Uses override toString method to return list of notes in desired format
	public ArrayList<DayNote> getNotes() {
		return this.notes;

	}

	// Add new note to notes array
	// TODO: Check for duplicate days
	public boolean addNote(String day, int note) {

		// Format date before adding new DayNote
		day = formatDate(day);
		
		if (day.equals("")) {
			System.out.println("Addition failed...");
			return false;
		}		

		// Check for duplicates
		DayNote noteToAdd = new DayNote(day, note);			
		this.notes.add(noteToAdd);
		
		System.out.println("Addition successful!");
		return true;
		
	}

	// Remove note from notes given date
	public boolean removeNote(String dayToRemove) {

		dayToRemove = formatDate(dayToRemove);
		
		if (dayToRemove.equals("")) {
			System.out.println("Removal failed...");
			return false;
		}
		
		for (int i = 0; i < this.notes.size(); i++) {
			
			if (notes.get(i).getDay().equals(dayToRemove)) {
				
				notes.remove(i);
				
				System.out.println("Removal succesful!");
				return true;
			}

		}

		System.out.println("Removal failed...");
		return false;
		
	}

	public boolean replaceNote(String dayToChange, int note) {

		if(removeNote(dayToChange)) {
			
			addNote(dayToChange, note);
			System.out.println("Replacement successful!");
			
			return true;
		}
		
		System.out.println("Replacement failed...");
		return false;
		
	}

	private String formatDate(String dateToFormat) {
		// Format dateToRemove
		
		// Make sure year is added, proper date format has second / at position of at least 4
		if (dateToFormat.lastIndexOf('/') < 3) {
			
			System.out.println("ERROR: NO YEAR ADDED");
			dateToFormat = "";
			
		} else {
			
			// Remove year to add on later after formatting month and day
			String addedYear = dateToFormat.substring(dateToFormat.lastIndexOf('/'), dateToFormat.length());
			
			dateToFormat = dateToFormat.substring(0, dateToFormat.lastIndexOf('/'));
			
			// Format year
			if (addedYear.length() != 3) {
				System.out.println("ERROR: YEAR NOT LONG ENOUGH");
				dateToFormat = "";
				return dateToFormat;
			}
			
			// Given 2/24 or 2/2 -> 02/24 or 02/2
			if (dateToFormat.charAt(1) == '/') {
				dateToFormat = "0" + dateToFormat;
			}

			// Given 02/1 -> 02/01
			if (dateToFormat.length() != 5) {
				dateToFormat = dateToFormat.substring(0, 3) + "0" + dateToFormat.substring(3, 4);
			}
			
			// Add year
			dateToFormat = dateToFormat + addedYear;

		}
		
		return dateToFormat;

	}

	// TODO: Format diagnosis (refer to ICD10 app)
	public void addDiagnosis(String diagnosisToAdd) {
		this.diagnoses.add(diagnosisToAdd);
	}
	
	// TODO: Format diagnosis
	public void removeDiagnosis(String diagnosisToRemove) {
		
	}
	
	public void printDiagnoses() {
		System.out.println(this.diagnoses.toString());
	}
	
	// TODO: Format codeToAdd (refer to ICD10 app)
	public void addCode(String codeToAdd) {
		this.codes.add(codeToAdd);
	}
	
	// TODO: Format codeToRemove
	public void removeCode(String codeToRemove) {
		
	}
	
	public void printCodes() {
		System.out.println(this.codes.toString());
	}
	
	// Set name in case of typo
	public void setName(String newName) {

		this.name = newName;

	}

	public String getName() {

		return this.name;

	}

}
