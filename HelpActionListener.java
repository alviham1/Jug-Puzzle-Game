package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * implements action listener to return a dialog box with instructions
 *  on how to play the game when the help button is pressed
 * @author Hamza
 *
 */
public class HelpActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		String message = "A Jug Puzzle consists of three Jugs with capacities 8,5 and 3 respectively." + "\n"
				+ " Initially, jug 0 is full, the other two are empty. \"When spills are made between " + "\n"
				+ "jugs, either one jug will be emptied or one jug will be filled. spill liquid between" + "\n"
				+ " the jugs by pressing between buttons jug0, jug1, jug3 until both jugs 0 and 1 contain 4 units of liquid each.";
		JOptionPane.showMessageDialog(null, message, "Instructions", JOptionPane.INFORMATION_MESSAGE);
	}
	

}
