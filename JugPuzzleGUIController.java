package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


/**
 * This class allows a  user to play an instance of JugPuzzle in gui view. It
 * implements a simple gui interface using model view controller architecture and
 * Creates and hooks up the Model, View and the controller.
 * 
 * @author csc207 student
 */
public class JugPuzzleGUIController {
	
	public static void createAndShowGUI() {
		
		// View
		Jug0View j0 = new Jug0View();
		Jug1View j1 = new Jug1View();
		Jug2View j2 = new Jug2View();
		JugBar0 bar0 = new JugBar0();
		JugBar1 bar1 = new JugBar1();
		JugBar2 bar2 = new JugBar2();
		MovesView Moves = new MovesView();
		JLabel highscore = new JLabel("Highscore: 0");
		highscore.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel name = new JLabel("JugPuzzle");
		name.setFont(new Font("Serif", Font.BOLD, 30));
		
		
		// Model
		JugPuzzle j = new JugPuzzle();
		Jug jug0 = j.getJugs()[0];
		Jug jug1 = j.getJugs()[1];
		Jug jug2 = j.getJugs()[2];
		
		// Hook the model to the view.
		jug0.addObserver(j0);
		jug1.addObserver(j1);
		jug2.addObserver(j2);
		j.addObserver(Moves);
		jug0.addObserver(bar0);
		jug1.addObserver(bar1);
		jug2.addObserver(bar2);
		
		// Create the GUI controller to control the Model.
		JFrame frame = new JFrame("Jug Puzzle Game"); // Frame with title
		frame.setSize(480, 480);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setForeground(Color.white);
		// What happens when we close the JFrame...
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Layout components in frame left to right, top to bottom
		frame.getContentPane().setLayout(null);
		
		JButton b1, b2, b3, b4, b5, b6; // Two reference to JButton, no buttons exist yet!!
		
		// Create the buttons
		b1 = new JButton("Jug 0");
		b2 = new JButton("Jug 1");
		b3 = new JButton("Jug 2");
		b4 = new JButton("Restart");
		b5 = new JButton("Quit");
		b6 = new JButton("Help");

		// set component bounds
		b1.setBounds(45, 360, 100, 40);
		b2.setBounds(190, 360, 100, 40);
		b3.setBounds(335, 360, 100, 40);
		b4.setBounds(0, 0, 160, 40);
		b5.setBounds(320, 0, 160, 40);
		b6.setBounds(160, 0, 160, 40);
		name.setBounds(175, 50, 150, 40);
		highscore.setBounds(95, 400, 150, 80);
		
		// set component colors
		b1.setForeground(Color.black);
		b1.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBackground(Color.orange);
		b4.setForeground(Color.black);
		b4.setBackground(Color.white);
		b5.setForeground(Color.black);
		b5.setBackground(Color.white);
		b6.setForeground(Color.black);
		b6.setBackground(Color.white);
		name.setForeground(Color.orange);
		highscore.setForeground(Color.white);
		
		// add them to the contentPane
		frame.add(j0);
		frame.add(j1);
		frame.add(j2);
		frame.add(Moves);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);
		frame.getContentPane().add(b5);
		frame.getContentPane().add(b6);
		frame.getContentPane().add(bar0);
		frame.getContentPane().add(bar1);
		frame.getContentPane().add(bar2);
		frame.getContentPane().add(name);
		frame.getContentPane().add(highscore);

		
		// Create button press event handlers
		boolean pressed = false;
		JugPuzzleGUIControllerActionListener mb1 = new JugPuzzleGUIControllerActionListener(b1, b2, b3, b6, j, pressed, highscore);
		pressed = mb1.ispressed();
		QuitActionListener mb5 = new QuitActionListener();
		HelpActionListener mb6 = new HelpActionListener();
		
	
		// Tell the buttons who they should call when they are pressed
		b1.addActionListener(mb1);
		b2.addActionListener(mb1);
	    b3.addActionListener(mb1);
	    b4.addActionListener(mb1);
	    b5.addActionListener(mb5);
	    b6.addActionListener(mb6);
	    
		// lets see the frame
		frame.setVisible(true);
		
		// Let the model tell the views to update
		j.notifyObservers();
		jug0.notifyObservers();
		jug1.notifyObservers();
		jug2.notifyObservers();
	}
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
