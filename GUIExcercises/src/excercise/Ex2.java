package excercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex2 extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
	
	Ex2() {
		this.setTitle("Quick Excercise #2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		this.setLocationRelativeTo(getRootPane()); 
		this.setSize(100, 100);
		
		
		this.button = new JButton("How are you?");

		button.addActionListener(this);
		add(button,AbstractButton.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Great", "Terrible"};
		if( "howareyou".equals(e.getActionCommand())) {
			//the option dialog makes more sense in this case 
			//than showInputDialog
			if( JOptionPane.showOptionDialog(
					this, 
					"How do you feel today?",
					"That feel",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[0]) == JOptionPane.YES_OPTION )
			{	
				JOptionPane.showMessageDialog(this, "Word dawg. Stay awesome");
			} else { //nope
				JOptionPane.showMessageDialog(this, "It's okay bro. We all know that feel.");
			}
			
		}
	}

	public static void main(String[] args) {
		Ex2 gui = new Ex2();
	
		gui.setVisible(true);
	}

}
