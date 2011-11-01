package ex2;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginDialog extends JDialog {
	private static final long serialVersionUID = -3027073673772023302L;
	
	private final String username, password;
	
	LoginDialog(Frame parent, String username, String password) {
		super(parent, "Enter credentials");
		this.username = username;
		this.password = password;
		
		JPanel content = new JPanel(); 
		
		JTextField userinput = new JTextField(20);
		JPasswordField passinput = new JPasswordField(20);
		
		content.add(userinput); content.add(passinput);
		this.setContentPane(content);
		pack();
		setVisible(true);
		setResizable(false);
	}
}