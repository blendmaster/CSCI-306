package ex1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public final class WhoAreYou extends JFrame implements StatusListener {
	
	private static final long serialVersionUID = 5160490348130252527L;
	private JMenu menu;
	private JMenuItem close;
	private JLabel statusbar;
	
	@SuppressWarnings("serial")
	WhoAreYou() {
		super("Who Are You?");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setupMenu();
		
		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
		
		options.add(new OptionPanel(
				"Animals",
				"Do you like",
				new LinkedHashMap<String,String>() {{
					put("Bunnies","Bunnies are still underground, so you're cool");
					put("Kittens","Kittens are great");
					put("Puppies","Puppies sold out years ago");
					put("Pandas","E'rybody likes pandas");
				}},
				this,
				true));
		options.add(new OptionPanel(
				"Power Level",
				"Are you a",
				new LinkedHashMap<String,String>() {{
					put("Freshman","You don't know what you're in for, do you?");
					put("Sophomore", "Stay with it dude");
					put("Junior","3/4s is good enough for government work");
					put("Senior","E'rybody likes seniors");
					put("Employed","Make some bank");
					put("NEET","It's okay bro, you can always go to school later");
				}},
				this,
				false));
		add(options);
		
		setupStatusbar();
		
		pack();
		setLocationRelativeTo(null);
		setMinimumSize(getPreferredSize());
		setVisible(true);
	}

	private void setupStatusbar() {
		this.statusbar = new JLabel("Ready");
		statusbar.setBorder(BorderFactory.createLoweredBevelBorder());
		this.getContentPane().add(statusbar, BorderLayout.PAGE_END);
	}

	private void setupMenu() {
		this.menu = new JMenu("Program");
		this.close = new JMenuItem("Exit");
		this.close.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		this.menu.add( close );

		this.setJMenuBar(new JMenuBar());
		this.getJMenuBar().add(this.menu);
	}
	
	public static void main(String[] args) {
		new WhoAreYou();
	}

	@Override
	public void updateStatus(String message) {
		statusbar.setText(message);
		
	}

}
