package ca.utoronto.utm.jugpuzzle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class JugPuzzleGUIControllerActionListener implements ActionListener {
	private JugPuzzle puzzle;
	private boolean pressed;
	JButton b1, b2, b3, b6;
	JLabel highscore;
	int score;
	

	public JugPuzzleGUIControllerActionListener(JButton b1, JButton b2, JButton b3, JButton b6, JugPuzzle puzzle, boolean pressed, JLabel highscore) {
		this.puzzle = puzzle;
		this.pressed = pressed;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b6 = b6;
		this.highscore = highscore;
		score = 999999999;
		
	}
	public boolean ispressed() {
		return this.pressed;
	}
	
	
	// 1) Modify this so that it prints out which button was pressed.
	// Hint: Lookup ActionEvent.
	// 2) Modify this so that it sets the JTextField to which button was pressed
	// Hint: MyButtonListener will need access to a JTextField.

	int from;
	int to;
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Restart") {
			this.puzzle.reset();
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
		}
		
		else if (this.pressed == false) {
			String f = e.getActionCommand().substring(4,5);
			from = Integer.parseInt(f);
			this.pressed = true;
		}
		else {
			String t = e.getActionCommand().substring(4,5);
			to = Integer.parseInt(t);
			if (!this.puzzle.getIsPuzzleSolved()) {
				this.puzzle.move(from, to);
				this.pressed = false;
				if (this.puzzle.getIsPuzzleSolved()) {
					b1.setEnabled(false);
					b2.setEnabled(false);
					b3.setEnabled(false);
					b6.setEnabled(false);
					String message = "Congrats you solved it in " + puzzle.getMoves() + " moves!!" + "\n" + "Press 'Quit' to exit or 'Restart' to play again" ;
					JOptionPane.showMessageDialog(null, message, "Won Alert", JOptionPane.INFORMATION_MESSAGE);
					if (this.puzzle.getMoves() < score) {
						highscore.setText("Highscore: " + this.puzzle.getMoves());
						score = this.puzzle.getMoves();
					}
				}
			}
		}
	}
}
	
