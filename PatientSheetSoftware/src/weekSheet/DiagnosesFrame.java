package weekSheet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
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
	private CodeLabelPanel codeLabel;
	private JPanel diagPanelArea;
	private JScrollPane codeLabelScrollPane;
	private CustomButton clearButton;

	private void layoutComponents() {

		diagPanelArea = new JPanel();

		// ====================Diagnosis Panel Area===============================\\

		diagPanel = new DiagnosisPanel();

		add(diagPanelArea, BorderLayout.NORTH);

		diagPanelArea.setLayout(new BorderLayout());
		diagPanelArea.add(diagPanel);

		// ===================Code Label Area=================================\\

		codeLabel = new CodeLabelPanel();

		codeLabelScrollPane = new JScrollPane(codeLabel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(codeLabelScrollPane, BorderLayout.CENTER);

		// ===================Code Label Area=================================\\

		clearButton = new CustomButton("Clear");
		add(clearButton, BorderLayout.SOUTH);
		
		clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				getContentPane().removeAll();
				layoutComponents();
				repaint();
				revalidate();
				
			}
			
		});

	}

	private class CodeLabelPanel extends JPanel {

		CodeLabelPanel() {

			setLayout(new GridBagLayout());

			GridBagConstraints gc = new GridBagConstraints();

			diagPanel.enterButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					remove(diagPanel);

					gc.fill = GridBagConstraints.BOTH;
					gc.weightx = 1;
					gc.gridy++;

					String code = ICDDictionary.searchListDiagnosis(diagPanel.diagnosisEntry.getText());

					ICDCode returnedCode = ICDDictionary.returnCodeObject(code);

					add(new CodeLabel(returnedCode), gc);

					ICDDictionary.readList();
					ICDDictionary.searchListDiagnosis("htn");
					
					revalidate();
					repaint();
					
				}

			});

		}

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