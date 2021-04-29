package weekSheet;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekScreen extends JPanel {
	
	WeekTopPanel topPanel;

	public WeekScreen() { 
		
		setLayout(new BorderLayout());
		//setBackground(Color.BLUE);

		WeekTopPanel topPanel = new WeekTopPanel();
		
		add(topPanel, BorderLayout.NORTH);
		
	}
	
	public class WeekTopPanel extends JPanel{
		
		JLabel monday, tuesday, wednesday, thursday, friday, saturday, sunday;
		JLabel patientName;

		WeekTopPanel() {
			
			setLayout(new GridBagLayout());
			
			JLabel monday = new JLabel("Monday");
			JLabel tuesday = new JLabel("Tuesday");
			JLabel wednesday = new JLabel("Wednesday");
			JLabel thursday = new JLabel("Thursday");
			JLabel friday = new JLabel("Friday");
			JLabel saturday = new JLabel("Saturday");
			JLabel sunday = new JLabel("Sunday");
			
			JLabel patientName = new JLabel("Patient Name");
			
			GridBagConstraints c = new GridBagConstraints();
			
			//c.anchor = GridBagConstraints.FIRST_LINE_END;
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 0;
			c.gridy = 0;
			
			add(patientName, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 1;
			c.gridy = 0;
			
			add(monday, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 2;
			c.gridy = 0;
			
			add(tuesday, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 3;
			c.gridy = 0;
			
			add(wednesday, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 4;
			c.gridy = 0;
			
			add(thursday, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 5;
			c.gridy = 0;
			
			add(friday, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 6;
			c.gridy = 0;
			
			add(saturday, c);
			
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 7;
			c.gridy = 0;
			
			add(sunday, c);
			
		}
		
	}

}
