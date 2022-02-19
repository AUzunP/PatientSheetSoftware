package main;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {

		System.out.println("Test");

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new MainFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
	}
	
}
