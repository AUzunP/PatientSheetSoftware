package weekSheet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import converter.CodeLabel;
import converter.ICDCode;
import customComponents.CustomButton;

public class PatientPanel extends JPanel{

	private JTextField mondayNote;
	private JTextField tuesdayNote;
	private JTextField wednesdayNote;
	private JTextField thursdayNote;
	private JTextField fridayNote;
	private JTextField saturdayNote;
	private JTextField sundayNote;
	private JTextField patientName;
	private CustomButton diagnoses;
	
	// Components for diagnosesFrame
	
	private DiagnosesFrame diagnosesFrame;
	
	public PatientPanel() {
		
		setLayout(new GridBagLayout());
		
		Dimension tabDimension = new Dimension(200, 25);
		Dimension dayDimension = new Dimension(50, 25);
		
		diagnoses = new CustomButton();
		patientName = new JTextField();
		
		mondayNote = new JTextField();
		tuesdayNote = new JTextField();
		wednesdayNote = new JTextField();
		thursdayNote = new JTextField();
		fridayNote = new JTextField();
		saturdayNote = new JTextField();
		sundayNote = new JTextField();
		
		mondayNote.setHorizontalAlignment(JTextField.CENTER);
		tuesdayNote.setHorizontalAlignment(JTextField.CENTER);
		wednesdayNote.setHorizontalAlignment(JTextField.CENTER);
		thursdayNote.setHorizontalAlignment(JTextField.CENTER);
		fridayNote.setHorizontalAlignment(JTextField.CENTER);
		saturdayNote.setHorizontalAlignment(JTextField.CENTER);
		sundayNote.setHorizontalAlignment(JTextField.CENTER);
		
		// What a mess this stuff is VVVV
		
		diagnoses.setPreferredSize(tabDimension);
		patientName.setPreferredSize(tabDimension);
		
		mondayNote.setPreferredSize(dayDimension);
		tuesdayNote.setPreferredSize(dayDimension);
		wednesdayNote.setPreferredSize(dayDimension);
		thursdayNote.setPreferredSize(dayDimension);
		fridayNote.setPreferredSize(dayDimension);
		saturdayNote.setPreferredSize(dayDimension);
		sundayNote.setPreferredSize(dayDimension);
		
		diagnoses.setMinimumSize(tabDimension);
		patientName.setMinimumSize(tabDimension);
		
		mondayNote.setMinimumSize(dayDimension);
		tuesdayNote.setMinimumSize(dayDimension);
		wednesdayNote.setMinimumSize(dayDimension);
		thursdayNote.setMinimumSize(dayDimension);
		fridayNote.setMinimumSize(dayDimension);
		saturdayNote.setMinimumSize(dayDimension);
		sundayNote.setMinimumSize(dayDimension);
		
		diagnoses.setBorder(BorderFactory.createEtchedBorder(1));		
		patientName.setBorder(BorderFactory.createEtchedBorder(1));
		
		mondayNote.setBorder(BorderFactory.createEtchedBorder(1));
		tuesdayNote.setBorder(BorderFactory.createEtchedBorder(1));
		wednesdayNote.setBorder(BorderFactory.createEtchedBorder(1));
		thursdayNote.setBorder(BorderFactory.createEtchedBorder(1));
		fridayNote.setBorder(BorderFactory.createEtchedBorder(1));
		saturdayNote.setBorder(BorderFactory.createEtchedBorder(1));
		sundayNote.setBorder(BorderFactory.createEtchedBorder(1));
		
		diagnoses.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				createDiagnosesFrame();
			}
			
		});
		
		layoutPatientPanel();
		
	}
	
	private void createDiagnosesFrame() {
		
		diagnosesFrame = new DiagnosesFrame(this.patientName.getText());
		
		diagnosesFrame.setLocationRelativeTo(this);
		diagnosesFrame.setVisible(true);
		
		repaint();
		revalidate();
		
	}
	
	private void layoutPatientPanel() {
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		
		add(patientName, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 0;
		
		add(mondayNote, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		c.gridy = 0;
		
		add(tuesdayNote, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 3;
		c.gridy = 0;
		
		add(wednesdayNote, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 4;
		c.gridy = 0;
		
		add(thursdayNote, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 5;
		c.gridy = 0;
		
		add(fridayNote, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 6;
		c.gridy = 0;
		
		add(saturdayNote, c);
		
		c.weightx = 0.05;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 7;
		c.gridy = 0;
		
		add(sundayNote, c);
		
		c.weightx = 0.33;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 8;
		c.gridy = 0;
		
		add(diagnoses, c);			
	}

}

