package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;
import java.util.Observer;

/**
 * A Jug Puzzle consists of three Jugs (numbered 0,1 and 2) with capacities 8,5
 * and 3 respectively. Initially, jug 0 is full, the other two are empty. The
 * player of the game spills liquid between the jugs (move) until both jugs 0
 * and 1 contain 4 units of liquid each. When a player makes a move, one Jug spills into
 * another. The JugPuzzle knows how many moves have taken place since the start
 * of the game. A spill ends as soon as one jug is empty or one jug is filled.
 * 
 * @author csc207student
 */

public class JugPuzzle extends Observable{
	private Jug[] jugs;
	private int moves;

	/**
	 * Create a new JugPuzzle with three jugs, capacities 8,5,3
	 * and initial amounts 8,0,0. The goal is to achieve amounts
	 * 4,4,0. Initially the number of moves is 0.
	 */
	public JugPuzzle() {
		this.setJugs(new Jug[3]);
		this.getJugs()[0] = new Jug(8, 8);
		this.getJugs()[1] = new Jug(5);
		this.getJugs()[2] = new Jug(3);
		this.moves = 0;
	}
	/**
	 * Reset the JugPuzzle by setting jug amounts back to 
	 * initial values i.e 8, 0, 0 respectively and 
	 * reset number of moves to 0.
	 */
	public void reset() {
		this.getJugs()[0].reset();
		this.getJugs()[1].reset();
		this.getJugs()[2].reset();
		this.moves = 0;
		this.setChanged();
		this.notifyObservers("puzzle reset");
	}
	
	/**
	 * 
	 * @return the array of jugs
	 */
	public Jug[] getJugs() {
		return jugs;
	}
	

	public void setJugs(Jug[] jugs) {
		this.jugs = jugs;
	}

	/**
	 * 
	 * @return the number of moves since the start of the game.
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * 
	 * @return whether this is solved, that is 4 units in jugs 0 and 1 each.
	 */
	public boolean getIsPuzzleSolved() {
		return getJugs()[0].getAmount() == 4 && getJugs()[1].getAmount() == 4;
	}

	/**
	 * Make a single move of the JugPuzzle, that is spill Jug 'from' into Jug 'to'.
	 * This counts as a single move.
	 * 
	 * @param from an integer identifying a jug
	 * @param to an integer identifying a jug
	 */
	public void move(int from, int to) {
		if(0<=from && from<getJugs().length && 0<=to && to<getJugs().length){
			getJugs()[from].spillInto(getJugs()[to]);
			moves++;
		}
		this.setChanged();
		this.notifyObservers("Moves increased by 1");
	}

	/**
	 * @return a string representation of this
	 */
	public String toString() {
		return moves + " " + " 0:" + getJugs()[0] + " 1:" + getJugs()[1] + " 2:" + getJugs()[2];
	}
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers("observed");
	}
}