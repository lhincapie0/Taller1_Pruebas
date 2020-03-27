package co.edu.icesi.fi.tics.tssc.exceptions;

public class NotExistingGame extends Exception{

	public NotExistingGame() {
		super("The game does not exist");
	}
}
