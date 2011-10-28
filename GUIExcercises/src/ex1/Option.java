package ex1;

/**
 * Option structure.
 * text is the text of the option
 * message is the status message displayed when the option is selected
 * @author Steven
 *
 */
public class Option {
	public Option(String text, String message) {
		this.text = text;
		this.message = message;
	}

	final String text, message; 
}
