package weekSheet;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import customComponents.CustomButton;

public class DiagnosesFrame extends JFrame{
	
	private JTextField diagnosesEntry;
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
		
		diagnosesEntry = new JTextField();
		enterButton = new CustomButton();
		
		diagnosesEntry.setPreferredSize(new Dimension(200, 25));
		enterButton.setPreferredSize(new Dimension(25, 25));
	
		c.gridx = 0;
		c.gridy = 0;
		
		c.fill = GridBagConstraints.BOTH;
		
		this.add(diagnosesEntry, c);
		
		c.gridx = 1;
		c.gridy = 0;
		
		this.add(enterButton, c);
		
	}
	
}
