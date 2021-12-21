package converter;

import java.util.ArrayList;

public class ICDCode {

	private String code;
	private ArrayList<String> diagnosesList;

	public ICDCode(String code, ArrayList<String> diagnosesList) {

		// When entering a new ICD Code from scratch
		
		this.code = code.toUpperCase();
		
		this.diagnosesList = diagnosesList;
		// Make all diagnosis upper case
		this.diagnosesList.replaceAll(String::toUpperCase);

	}

	
	//test
	ICDCode(String entry) {
		
		// When building a dictionary from previously entered ICD codes that are entered
		// with the format already in place
		
		entry = entry.toUpperCase();
		this.diagnosesList = new ArrayList<String>();

		ArrayList<String> diagnosesArray = new ArrayList<String>();

		diagnosesArray = format(entry);

		for (int i = 0; i < diagnosesArray.size(); i++) {
			this.diagnosesList.add(diagnosesArray.get(i));
		}

	}

	public String getCode() {
		return this.code;
	}

	public ArrayList<String> getDiagnosesList() {
		return this.diagnosesList;
	}

	public void setCode(String newCode) {
		this.code = newCode;
	}

	public void setDiagnosesList(ArrayList<String> newDiagnosesList) {
		this.diagnosesList = newDiagnosesList;
	}

	public void readDiagnoses() {
		// Reads out all diagnoses associated with the code object
		System.out.println("-----------------------------------------------------");
		System.out.println("The diagnoses associated with " + this.code + " are: ");
		for (int i = 0; i < this.diagnosesList.size(); i++) {
			System.out.println(this.diagnosesList.get(i));
		}
	}

	public void addDiagnoses(String diagnosisToAdd) {

		diagnosisToAdd = diagnosisToAdd.toUpperCase();
		this.diagnosesList.add(diagnosisToAdd);

	}

	public void deleteDiagnosis(String diagnosisToDelete) {

		try {

			for (int i = 0; i < this.diagnosesList.size(); i++) {
				if (this.diagnosesList.get(i).equals(diagnosisToDelete)) {
					System.out.println("Diagnosis [" + this.diagnosesList.get(i) + "] deleted.");
					this.diagnosesList.remove(i);
				}
			}

		} catch (Exception e) {
			System.out.println("Removal of [" + diagnosisToDelete + "] failed.");
			return;
		}

		return;

	}

	public String diagnosisSearch(String diagnosisToSearch) {
		// Searches associated code object for given diagnosis
		diagnosisToSearch = diagnosisToSearch.toUpperCase();

		for (int i = 0; i < this.diagnosesList.size(); i++) {
			if (this.diagnosesList.get(i).equals(diagnosisToSearch)) {
				System.out.println(diagnosisToSearch + " exists for the code " + this.code);
				return this.code;
			}
		}

		System.out.println(diagnosisToSearch + " is not an existing key for the code" + this.code);
		return null;
	}

	public String getFormattedCode() {

		// Follows I10{Hypertension, HTN, High blood pressure} format

		String formattedCode = "";

		formattedCode = (this.getCode() + this.getFormattedDiagnosesOnly());

		return formattedCode;

	}
	
	public String getFormattedDiagnosesOnly() {
		
		String formattedDiagnoses = "{";

		for (int i = 0; i < this.diagnosesList.size(); i++) {
			formattedDiagnoses += (this.diagnosesList.get(i) + ", ");
		}

		// removing last comma
		formattedDiagnoses = formattedDiagnoses.substring(0, formattedDiagnoses.length() - 2);
		formattedDiagnoses = (formattedDiagnoses + "}");
		
		return formattedDiagnoses;
	}

	private ArrayList<String> format(String entry) {
		// Entry should be as follows: I10{Hypertension, HTN, High blood pressure}
		entry = entry.toUpperCase();

		ArrayList<String> codes = new ArrayList<String>();

		// grab ICD code from entry
		this.code = formatCode(entry);

		String tempCode = "";
		// Get string in between { and } which are the diagnoses
		System.out.println("ENTRY " + entry);
		entry = entry.substring(entry.indexOf('{') + 1, entry.indexOf('}'));

		// Separate every string of diagnoses
		for (int i = 0; i < entry.length(); i++) {

			// do not include commas in diagnoses
			if (entry.charAt(i) != ',') {
				tempCode += entry.charAt(i);
			}

			if (entry.charAt(i) == ',' || i + 1 == entry.length()) {
				// remove start and end spaces
				tempCode = tempCode.trim();
				codes.add(tempCode);
				tempCode = "";
			}
		}

		return codes;
	}

	private String formatCode(String entry) {
		// Goes through string until it hits { and enters the previous string as ICD code
		entry = entry.toUpperCase();

		String code = "";

		for (int i = 0; i < entry.length(); i++) {
			if (entry.charAt(i) != '{') {
				code += entry.charAt(i);
			} else {
				return code;
			}
		}

		return code;
	}

}
