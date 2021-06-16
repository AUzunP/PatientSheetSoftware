package weekSheet;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import customComponents.CustomButton;

public class DiagnosesFrame extends JFrame{
	
	private JTextField diagnosisEntry;
	private CustomButton enterButton;
	
	public DiagnosesFrame(String patientName) {
		
		super("Diagnoses for " + patientName);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Dimension d = new Dimension(400, 400);
		setPreferredSize(d);
		setMinimumSize(d);
		setLayout(new GridBagLayout());
		pack();
	
		layoutComponents(c);
		
	}
	
	private void layoutComponents(GridBagConstraints c) {
		
		c.gridx = 0;
		c.gridy = 0;

		addNewDiagnosis(c);
		
		c.gridx = 0;
		c.gridy++;
		
		addNewDiagnosis(c);
		
	}
	
	private void addNewDiagnosis(GridBagConstraints c) {
		
		diagnosisEntry = new JTextField();
		enterButton = new CustomButton();
		
		diagnosisEntry.setPreferredSize(new Dimension(200, 25));
		enterButton.setPreferredSize(new Dimension(25, 25));
		
		this.add(diagnosisEntry, c);
		
		c.gridx++;
		
		this.add(enterButton, c);
		
	}
	
}
