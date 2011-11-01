package ex2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

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
