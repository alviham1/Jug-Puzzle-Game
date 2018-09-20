package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

	/**
	 * Presents a visual view of Jug2 by extending progress bar.
	 * with maximum amount = jug capacity 
	 * @author Csc207student.
	 *
	 */
public class JugBar2 extends JProgressBar implements Observer { 
	@Override
	public void update(Observable o, Object arg) {
		Jug jug = (Jug)o;
		this.setOrientation(SwingConstants.VERTICAL);
		this.setBounds(335,245,100,75);
		this.setForeground(Color.blue.darker());
		this.setBackground(Color.darkGray);
		this.setMaximum(3);
		this.setMinimum(0);
		this.setString("");
		this.setStringPainted(true);
		this.setValue(jug.getAmount());
	}
}

