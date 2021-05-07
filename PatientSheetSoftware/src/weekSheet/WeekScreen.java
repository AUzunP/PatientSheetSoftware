package weekSheet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WeekScreen extends JPanel {

	WeekTopPanel topPanel;
	WeekMainPanel mainPanel;

	public WeekScreen() {

		setLayout(new BorderLayout());

		topPanel = new WeekTopPanel();
		mainPanel = new WeekMainPanel();
		
		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);

	}

	public class WeekMainPanel extends JPanel {
		
		private PatientPanel patientPanel;
		private JLabel tempLabel;
		
		WeekMainPanel() {
			
			setLayout(new GridBagLayout());
			this.setBackground(Color.BLUE);
			
			GridBagConstraints c = new GridBagConstraints();
			
			patientPanel = new PatientPanel();
			tempLabel = new JLabel();
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;
			
			addNewPatientPanel(c);
			addNewPatientPanel(c);
			addNewPatientPanel(c);
			
		}
		
		private void addNewPatientPanel(GridBagConstraints c) {
			
			// tempLabel is just here to fill up bottom space so patient labels
			// are added from top to bottom
			
			// Remove and then add back at the end
			remove(tempLabel);
			
			// Set weighty back to default
			c.weighty = 0;
			patientPanel = new PatientPanel();
			add(patientPanel, c);
			c.gridy++;
			
			// Set weighty to 1 so that it fills the remaining space
			c.weighty = 1;
			add(tempLabel, c);
			
		}
		
	}
	
	public class WeekTopPanel extends JPanel {

		JLabel monday, tuesday, wednesday, thursday, friday, saturday, sunday;
		JLabel patientName;
		JLabel diagnoses;
		PatientPanel patientPanel, patientPanel2;

		WeekTopPanel() {

			this.setBackground(Color.RED);
			
			setLayout(new GridBagLayout());

			diagnoses = new JLabel("Diagnoses");
			patientName = new JLabel("Patient Name");
			
			monday = new JLabel("MON", SwingConstants.CENTER);
			tuesday = new JLabel("TUE", SwingConstants.CENTER);
			wednesday = new JLabel("WED", SwingConstants.CENTER);
			thursday = new JLabel("THU", SwingConstants.CENTER);
			friday = new JLabel("FRI", SwingConstants.CENTER);
			saturday = new JLabel("SAT", SwingConstants.CENTER);
			sunday = new JLabel("SUN", SwingConstants.CENTER);

			diagnoses.setPreferredSize(new Dimension(200, 25));
			patientName.setPreferredSize(new Dimension(200, 25));
			
			monday.setPreferredSize(new Dimension(50, 25));
			tuesday.setPreferredSize(new Dimension(50, 25));
			wednesday.setPreferredSize(new Dimension(50, 25));
			thursday.setPreferredSize(new Dimension(50, 25));
			friday.setPreferredSize(new Dimension(50, 25));
			saturday.setPreferredSize(new Dimension(50, 25));
			sunday.setPreferredSize(new Dimension(50, 25));
			
//			patientPanel = new PatientPanel();
//			patientPanel2 = new PatientPanel();
			
			diagnoses.setBorder(BorderFactory.createEtchedBorder(1));		
			patientName.setBorder(BorderFactory.createEtchedBorder(1));
			
			monday.setBorder(BorderFactory.createEtchedBorder(1));
			tuesday.setBorder(BorderFactory.createEtchedBorder(1));
			wednesday.setBorder(BorderFactory.createEtchedBorder(1));
			thursday.setBorder(BorderFactory.createEtchedBorder(1));
			friday.setBorder(BorderFactory.createEtchedBorder(1));
			saturday.setBorder(BorderFactory.createEtchedBorder(1));
			sunday.setBorder(BorderFactory.createEtchedBorder(1));
			
			layoutTopPanel();
			
		}

		private void layoutTopPanel() {
			
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

			add(monday, c);

			c.weightx = 0.05;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 2;
			c.gridy = 0;

			add(tuesday, c);

			c.weightx = 0.05;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 3;
			c.gridy = 0;

			add(wednesday, c);

			c.weightx = 0.05;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 4;
			c.gridy = 0;

			add(thursday, c);

			c.weightx = 0.05;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 5;
			c.gridy = 0;

			add(friday, c);

			c.weightx = 0.05;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 6;
			c.gridy = 0;

			add(saturday, c);

			c.weightx = 0.05;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 7;
			c.gridy = 0;

			add(sunday, c);

			c.weightx = 0.3;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 8;
			c.gridy = 0;
			
			add(diagnoses, c);

			//c.weightx = 1;
//			c.gridwidth = 9;
//			c.gridheight = 1;
//			c.gridx = 0;
//			c.gridy = 1;
//			
//			add(patientPanel, c);
			
		}
		
	}

}
