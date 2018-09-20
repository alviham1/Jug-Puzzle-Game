package ca.utoronto.utm.jugpuzzle;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Presents a numerical view of Jug 2 by extending Jlabel
 * 
 * @author Csc207student
 *
 */
public class Jug2View extends JLabel implements Observer { 
	@Override
	public void update(Observable o, Object arg) {
		Jug jug = (Jug)o;
		this.setFont(new Font("Serif", Font.BOLD, 25));
		this.setForeground(Color.blue.brighter());
		this.setBounds(360, 205, 100, 40);
		this.setText(jug.toString());		
	}
}
