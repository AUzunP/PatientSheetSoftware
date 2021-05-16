package weekSheet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import customComponents.CustomButton;

public class WeekScreen extends JPanel {

	private JScrollPane scrollPane;
	private WeekTopPanel topPanel;
	private WeekLabelsPanel labelsPanel;
	private WeekMainPanel mainPanel;
	private WeekBottomPanel bottomPanel;

	// TODO Add top line for file and settings drop down menu that has
	// import and export options as well as save, etc.
	public WeekScreen() {

		// Must change layout to accommodate for fourth line
		setLayout(new GridBagLayout());

		labelsPanel = new WeekLabelsPanel();
		mainPanel = new WeekMainPanel();
		bottomPanel = new WeekBottomPanel();
		topPanel = new WeekTopPanel();

		bottomPanel.addNewPatientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.addNewPatientPanel(mainPanel.c);
				System.out.println("add new patient button");
			}

		});

		bottomPanel.tempButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("temp button");
			}

		});

		// TODO Add functionality here
		bottomPanel.removeLastPatientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("remove last patient button");
			}

		});

		// Wrap main panel in scroll pane and add it instead of adding main panel
		scrollPane = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.weightx = 1;

		c.gridy = 0;
		c.weighty = 0.01;
		
		add(topPanel, c);
		
		c.weighty = 0;
		c.gridy = 1;

		add(labelsPanel, c);

		c.gridy = 2;
		c.weighty = .8;
		c.anchor = GridBagConstraints.CENTER;

		add(scrollPane, c);

		c.gridy = 3;
		c.weighty = 0.005;

		add(bottomPanel, c);

	}

	private class WeekTopPanel extends JPanel {

		private CustomButton selectWeekButton;
		
		WeekTopPanel() {
			
			setLayout(new GridBagLayout());
			
			selectWeekButton = new CustomButton("Week: XX/XX/XX");
			
			GridBagConstraints c = new GridBagConstraints();
			
			c.gridx = 0;
			c.gridy = 0;
			
			add(selectWeekButton, c);
			
		}
		
	}

	private class WeekLabelsPanel extends JPanel {

		private JLabel monday, tuesday, wednesday, thursday, friday, saturday, sunday;
		private JLabel patientName;
		private JLabel diagnoses;

		WeekLabelsPanel() {

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

		}

	}

	private class WeekMainPanel extends JPanel {

		private PatientPanel patientPanel;
		private JLabel tempLabel;
		private GridBagConstraints c;

		WeekMainPanel() {

			setLayout(new GridBagLayout());

			c = new GridBagConstraints();

			patientPanel = new PatientPanel();
			tempLabel = new JLabel();

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;

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

			repaint();
			revalidate();

		}

	}
	
	private class WeekBottomPanel extends JPanel {

		private CustomButton addNewPatientButton;
		private CustomButton removeLastPatientButton;
		private CustomButton tempButton;

		WeekBottomPanel() {

			setPreferredSize(new Dimension(100, 25));
			setLayout(new BorderLayout());

			tempButton = new CustomButton();
			addNewPatientButton = new CustomButton();
			removeLastPatientButton = new CustomButton();

			tempButton.setText("temp");
			addNewPatientButton.setText("add");
			removeLastPatientButton.setText("remove");

			add(tempButton, BorderLayout.CENTER);
			add(addNewPatientButton, BorderLayout.WEST);
			add(removeLastPatientButton, BorderLayout.EAST);

		}

	}


}
