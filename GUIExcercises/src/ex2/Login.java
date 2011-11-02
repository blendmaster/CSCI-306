package ex2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Login extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2835808078928828237L;
	
	Login() {
		super("Login Time");
		
		JButton button = new JButton("Login");
		button.addActionListener(this);
		add(button);
		
		pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new LoginDialog(this);
	}
	
    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                new Login();
            }
        });
    }
    

}
