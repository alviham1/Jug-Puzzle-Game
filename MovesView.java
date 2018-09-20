package ca.utoronto.utm.jugpuzzle;

import java.awt.*;
import java.util.*;
import javax.swing.*;


/**
 * Present a view on JugPuzzle to see the number of moves by extending jlabel.
 * 
 * @author Csc207student.
 *
 */
public class MovesView extends JLabel implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle j = (JugPuzzle)o;
		this.setFont(new Font("Serif", Font.BOLD, 20));
		this.setForeground(Color.white);
		this.setBounds(280, 400, 150, 80);
		this.setText("Moves: " + j.getMoves());
	}
}
	