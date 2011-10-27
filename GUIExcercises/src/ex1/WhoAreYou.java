package ex1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import quickex3.OptionPanel;

public final class WhoAreYou extends JFrame implements ActionListener,StatusListener {
	
	private static final long serialVersionUID = 5160490348130252527L;
	private JMenu menu;
	private JMenuItem close;
	private JLabel statusbar;
	
	WhoAreYou() {
		super("Who Are You?");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.menu = new JMenu("Program");
		this.close = new JMenuItem("Exit");
		this.close.addActionListener(this);
		this.menu.add( close );

		this.setJMenuBar(new JMenuBar());
		this.getJMenuBar().add(this.menu);
		
		add(new OptionPanel("Do you like",
				               new String[] {"Bunnies","Kittens", "Puppies", "Pandas"},
				               new String[] {"Bunnies are still underground, so you're cool","Kittens are great", "Puppies sold out years ago","E'rybody likes pandas"},
				               this,
				               true));
		add(new OptionPanel("Are you a",
	               new String[] {"Freshman","Sophomore", "Junior", "Senior", "Employed", "NEET"},
	               new String[] {"You don't know what you're in for, do you?","Stay with it dude", "3/4s is good enough for government work","E'rybody likes seniors", "Make some bank", "It's okay bro, you can always go to school later"},
	               this,
	               false));
		
				               
		this.statusbar = new JLabel("Ready");
		statusbar.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(statusbar, BorderLayout.SOUTH);
		
		pack();
	}
	
	public static void main(String[] args) {
		WhoAreYou y = new WhoAreYou();
		y.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource().equals(close)) {
			this.setVisible(false);
			this.dispose();
		} else {
			statusbar.setText(e.getActionCommand());
		}
	}

	@Override
	public void updateStatus(String message) {
		statusbar.setText(message);
		
	}

}
