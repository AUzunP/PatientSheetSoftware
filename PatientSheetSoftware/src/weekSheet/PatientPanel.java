package weekSheet;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	private JFrame diagnosesFrame;
	
	public PatientPanel() {
		
		setLayout(new GridBagLayout());
		
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
		
		diagnoses.setPreferredSize(new Dimension(200, 25));
		patientName.setPreferredSize(new Dimension(200, 25));
		
		mondayNote.setPreferredSize(new Dimension(50, 25));
		tuesdayNote.setPreferredSize(new Dimension(50, 25));
		wednesdayNote.setPreferredSize(new Dimension(50, 25));
		thursdayNote.setPreferredSize(new Dimension(50, 25));
		fridayNote.setPreferredSize(new Dimension(50, 25));
		saturdayNote.setPreferredSize(new Dimension(50, 25));
		sundayNote.setPreferredSize(new Dimension(50, 25));
		
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
		
		diagnosesFrame = new JFrame("Diagnoses for " + this.patientName.getText());
		
		Dimension d = new Dimension(400, 400);
		diagnosesFrame.setPreferredSize(d);
		diagnosesFrame.setMinimumSize(d);
		//diagnosesFrame.setResizable(false);
		diagnosesFrame.setLayout(new GridBagLayout());
		diagnosesFrame.pack();
		diagnosesFrame.setLocationRelativeTo(this);
		
//		revalidate();
//		repaint();
		diagnosesFrame.setVisible(true);
		
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
		
		c.weightx = 0.3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 8;
		c.gridy = 0;
		
		add(diagnoses, c);			
	}

}

