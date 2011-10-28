package ex1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public final class WhoAreYou extends JFrame implements StatusListener {
	
	private static final long serialVersionUID = 5160490348130252527L;
	private JMenuItem close;
	private JLabel statusbar;
	
	WhoAreYou() {
		super("Who Are You?");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setupMenu();
		
		JPanel metrics = new JPanel();
		metrics.setLayout(new BoxLayout(metrics, BoxLayout.PAGE_AXIS));
		
		metrics.add(new OptionPanel(
				"Animals",
				"Do you like",
				this,
				true,
				new Option("Bunnies","Bunnies are still underground, so you're cool"),
				new Option("Kittens","Kittens are great"),
				new Option("Puppies","Puppies sold out years ago"),
				new Option("Pandas","E'rybody likes pandas")));
		metrics.add(new OptionPanel(
				"Power Level",
				"Are you a",
				this,
				false,
				new Option("Freshman","You don't know what you're in for, do you?"),
				new Option("Sophomore", "Stay with it dude"),
				new Option("Junior","3/4s is good enough for government work"),
				new Option("Senior","E'rybody likes seniors"),
				new Option("Office Drone","Keep telling yourself it'll get better"),
				new Option("CEO","1% represent"),
				new Option("NEET","It's okay bro, school and jobs are for newbs")));
		metrics.add(new InputPanel(
				"Your Superpowers",
				this,
				new Option("Best", "Like lazors and bear-taming and stuff"),
				new Option("Would settle for", "meh, x-ray vision I guess"),
				new Option("Worst", "hair growth? pain sensitivity? you tell me, man")));
		metrics.add(new AreaInputPanel(
				"Origin Story",
				"Make yourself marketable to late 2000s Hollywood producers",
				"Ye olde origin story",
				"Best make it good, buddy",
				this));
		add(metrics);
		
		setupStatusbar();
		
		pack();
		setLocationRelativeTo(null);
		setMinimumSize(getPreferredSize());
		setVisible(true);
	}

	private void setupStatusbar() {
		this.statusbar = new JLabel();
		clearStatus();
		statusbar.setBorder(BorderFactory.createLoweredBevelBorder());
		this.getContentPane().add(statusbar, BorderLayout.PAGE_END);
	}

	private void setupMenu() {
		JMenu menu = new JMenu("Program");
		this.close = new JMenuItem("Exit");
		this.close.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		menu.add( close );

		setJMenuBar(new JMenuBar());
		getJMenuBar().add(menu);
	}
	
	public void updateStatus(String message) {
		statusbar.setText(message);
	}

	public void clearStatus() {
		statusbar.setText("Let me judge you!");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WhoAreYou();
			}
		});
	}

}
