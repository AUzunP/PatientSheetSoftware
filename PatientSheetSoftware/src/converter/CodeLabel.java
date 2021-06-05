package converter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class CodeLabel extends JPanel{

	private JLabel code;
	private JTextField diagnoses;

	public CodeLabel(ICDCode icdCode) {
		
		setLayout(new GridBagLayout());	
		
		code = new JLabel();
		
		code.setBorder(BorderFactory.createBevelBorder(1));
		code.setText(icdCode.getCode());
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setVerticalAlignment(SwingConstants.CENTER);
		
		diagnoses = new JTextField();
		
		diagnoses.setBorder(BorderFactory.createBevelBorder(1));
		diagnoses.setText(icdCode.getFormattedDiagnosesOnly());
		
		JScrollPane scrollPane = new JScrollPane(diagnoses);
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createBevelBorder(1));
		
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		
		GridBagConstraints c = new GridBagConstraints();
		
		//TEMPORARY
		scrollPane.setPreferredSize(new Dimension(100, 50));
		//^^^^^^^^^^^^
		
		c.gridx = 0;
		c.gridy = 0;
		
		add(code, c);
		
		c.gridx = 1;
		c.gridy = 0;
		
		add(scrollPane, c);
		
	}
	
}
