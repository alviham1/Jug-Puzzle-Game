package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * implements action listener to close the game when quit is pressed.
 * @author Hamza
 *
 */

public class QuitActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	

}
