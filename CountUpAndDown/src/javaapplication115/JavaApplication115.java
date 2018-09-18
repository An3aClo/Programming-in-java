package javaapplication115;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A simple Swing program that just creates a window and puts a button in it.
 * The button updates a counter each time it is clicked.  There is a label
 * that displays the counter value.
 * 
 * @author Barbara Lerner
 * @version Sep 13, 2011
 *
 */
public class JavaApplication115 implements ActionListener {
	// Counts the number of clicks
	private int counter = 0;
	
	// The label to display the counter value.
	private JLabel counterLabel;

	// Button that counts up when clicked.
	private JButton countUpButton;

	// Button that counts down when clicked.
	private JButton countDownButton;

	/**
	 * Creates a panel that holds the button and label.
	 * @return the panel that is created.
	 */
	public JPanel createPanel() {
		// Create the panel that will display the form
		JPanel clickMePanel = new JPanel();
		
		// Add the button that counts up
		countUpButton = new JButton ("Count up");
		countUpButton.addActionListener(this);
		clickMePanel.add(countUpButton);
		
		// Add the button that counts down
		countDownButton = new JButton ("Count down");
		countDownButton.addActionListener(this);
		clickMePanel.add(countDownButton);
		
		// Add a counter to the display
		counterLabel = new JLabel("" + counter);
		clickMePanel.add(counterLabel);
		
		return clickMePanel;
	}
	
	/**
	 * Increments the counter on each button click and displays
	 * the new value.
	 * @param event information about the button click
	 */
	public void actionPerformed(ActionEvent event) {
		//if (event.getSource() == countUpButton) {
                if(event.getActionCommand().equals("Count up")){
			counter++;
			counterLabel.setText("" + counter);
		}
		else {
			counter--;
			counterLabel.setText("" + counter);
		}
	}

	/**
	 * A program to display a button and counter.
	 * @param args None expected.
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Click Me!");
                f.setSize(400, 400);
		//f.setSize(new Dimension(400, 400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the panel to display
		 JavaApplication115 clickMe = new JavaApplication115();
		JPanel clickMePanel = clickMe.createPanel(); 
			
		// Add the panel to the center of the window
		 //Container contentPane = f.getContentPane();
		f.getContentPane()./*contentPane.*/add(clickMePanel, BorderLayout.CENTER);
		
		// Display the window.
		f.setVisible(true);

	}

}
