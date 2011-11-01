package ex2;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = -3027073673772023302L;
	
	private JTextField userinput;
	private JPasswordField passinput;
	
	LoginDialog(Frame parent) {
		super(parent, "Enter Credentials");
		
		JPanel content = new JPanel(); 
		GroupLayout layout = new GroupLayout(content);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		userinput = new JTextField(20);
		passinput = new JPasswordField(20);
		passinput.addActionListener(this);
		
		JLabel userlabel = new JLabel("Username: ");
		JLabel passlabel = new JLabel("Password: ");
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(this);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(userlabel)
						.addComponent(passlabel))
				.addGroup(layout.createParallelGroup()
						.addComponent(userinput)
						.addComponent(passinput)
						.addComponent(confirm, GroupLayout.Alignment.TRAILING)));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(userlabel,GroupLayout.Alignment.CENTER)
						.addComponent(userinput))
				.addGroup(layout.createParallelGroup()
						.addComponent(passlabel,GroupLayout.Alignment.CENTER)
						.addComponent(passinput))
				.addComponent(confirm));
		
		content.setLayout(layout);
		this.setContentPane(content);
		
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
		setResizable(false);
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( userinput.getText().equals(new String(passinput.getPassword())) ) {
			JOptionPane.showMessageDialog(this, ">2011\n>username and password are the same\nISHYGDDT"
					,"Bad Password Detected"
					, JOptionPane.ERROR_MESSAGE
					, createImageIcon("images/ISHYGDDT.jpg", "thanks 4chan"));
		} else {
			JOptionPane.showMessageDialog(this, "Your username and password have been sent to our servers for future use.\nThanks."
					,"Duly Noted"
					, JOptionPane.INFORMATION_MESSAGE
					, createImageIcon("images/yukko.jpg", ""));
			dispose();
		}
	}
}