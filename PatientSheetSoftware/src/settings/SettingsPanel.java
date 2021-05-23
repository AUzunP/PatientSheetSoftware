package settings;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import customComponents.CustomButton;

public class SettingsPanel extends JPanel{

	private CustomButton fileButton, settingsButton;
	private JPanel dummyPanel;
	
	public SettingsPanel() {
		
		setLayout(new GridBagLayout());
		
		setBorder(BorderFactory.createEtchedBorder(1));
		
		Dimension d = new Dimension(100, 20);
		
		fileButton = new CustomButton("File");
		settingsButton = new CustomButton("Settings");
		
		// Dummy panel to fill up remaining space
		dummyPanel = new JPanel();
		
		fileButton.setPreferredSize(d);
		settingsButton.setPreferredSize(d);
		
		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 0
				;
		c.gridx = 0;
		c.gridy = 0;
		
		add(fileButton, c);
		
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
	
		add(settingsButton, c);
	
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 0;
		
		add(dummyPanel, c);
		
	}
	
}
