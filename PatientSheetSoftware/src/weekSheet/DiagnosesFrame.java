package weekSheet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import converter.CodeLabel;
import converter.ICDCode;
import converter.ICDDictionary;
import customComponents.CustomButton;

public class DiagnosesFrame extends JFrame {

	public DiagnosesFrame(String patientName) {

		super("Diagnoses for " + patientName);

		setResizable(false);
		
		Dimension d = new Dimension(300, 500);
		setPreferredSize(d);
		setLayout(new BorderLayout());
		pack();

		layoutComponents();

	}

	private DiagnosisPanel diagPanel;
	private JPanel codeLabelArea;
	private JPanel diagPanelArea;
	private JScrollPane codeLabelScrollPane;

	private void layoutComponents() {

		diagPanelArea = new JPanel();
		codeLabelArea = new JPanel();

		codeLabelScrollPane = new JScrollPane(codeLabelArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// ====================Diagnosis Panel Area===============================\\

		diagPanel = new DiagnosisPanel();

		add(diagPanelArea, BorderLayout.NORTH);

		diagPanelArea.setLayout(new BorderLayout());
		diagPanelArea.add(diagPanel);
		
		// ===================Code Label Area=================================\\

		codeLabelArea.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		ArrayList<String> test = new ArrayList<String>();
		test.add("htn");
		test.add("hypertension");
		
		diagPanel.enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("here");
				codeLabelArea.remove(diagPanel);
				
				gc.fill = GridBagConstraints.BOTH;
				gc.weightx = 1;
				gc.gridy++;
				
				String code = ICDDictionary.searchListDiagnosis(diagPanel.diagnosisEntry.getText());
				
				ICDCode returnedCode = ICDDictionary.returnCodeObject(code);
				
				codeLabelArea.add(new CodeLabel(returnedCode), gc);
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

		add(codeLabelScrollPane, BorderLayout.CENTER);
		
	}

	private class DiagnosisPanel extends JPanel {

		private JTextField diagnosisEntry;
		private CustomButton enterButton;

		DiagnosisPanel() {

			setLayout(new GridBagLayout());

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
			
			c.insets = new Insets(15, 0, 15, 0);

			add(enterButton, c);

		}

	}

}