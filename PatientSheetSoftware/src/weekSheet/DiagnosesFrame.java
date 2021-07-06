package weekSheet;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import converter.CodeLabel;
import converter.ICDCode;
import converter.ICDDictionary;
import customComponents.CustomButton;

public class DiagnosesFrame extends JFrame {
	
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

	private DiagnosisPanel diagPanel;
	private CodeLabel codeLabel;

	private void layoutComponents(GridBagConstraints c) {

		c.gridx = 0;
		c.gridy = 0;

		diagPanel = new DiagnosisPanel();

		add(diagPanel, c);

		ArrayList<String> test = new ArrayList<String>();
		test.add("htn");
		test.add("hypertension");

		diagPanel.enterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("here");
				remove(diagPanel);
				c.gridy++;
				add(new CodeLabel(new ICDCode(diagPanel.diagnosisEntry.getText(), test)), c);
				add(diagPanel);
				repaint();
				revalidate();
				
				try {
					ICDDictionary.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ICDDictionary.readList();
				ICDDictionary.searchListDiagnosis("htn");
				
			}

		});

	}

	private class DiagnosisPanel extends JPanel {

		private JTextField diagnosisEntry;
		private CustomButton enterButton;

		DiagnosisPanel() {

			setLayout(new GridBagLayout());
			setPreferredSize(new Dimension(225, 25));

			diagnosisEntry = new JTextField();
			enterButton = new CustomButton();

			diagnosisEntry.setPreferredSize(new Dimension(200, 25));
			enterButton.setPreferredSize(new Dimension(25, 25));

			GridBagConstraints c = new GridBagConstraints();

			c.gridx = 0;
			c.gridy = 0;

			add(diagnosisEntry, c);

			c.gridx = 1;
			c.gridy = 0;

			add(enterButton, c);

		}

	}

}