package ex2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class LoginPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 2835808078928828237L;
	
	LoginPanel() {
		super(new BorderLayout());
		
		JButton button = new JButton("Login");
		button.addActionListener(this);
		add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new LoginDialog(null,"beep","boop");
	}
	
	private static void createAndShowGUI() {
	    //Create and set up the window.
	    JFrame frame = new JFrame("Login");
	        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        LoginPanel login = new LoginPanel();
	        frame.setContentPane(login);
	 
	        //Display the window.
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.setResizable(false);
	}
	 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                createAndShowGUI();
            }
        });
    }
    

}
