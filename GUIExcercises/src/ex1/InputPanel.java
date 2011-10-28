package ex1;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	private static final long serialVersionUID = 3398919009067279025L;

	public InputPanel(String title, final StatusListener listener, Option...inputs) {
		setBorder(BorderFactory.createTitledBorder(title));
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		ParallelGroup horizontal = layout.createParallelGroup();
		SequentialGroup vertical = layout.createSequentialGroup();
		
		ParallelGroup labels = layout.createParallelGroup();
		ParallelGroup textFields = layout.createParallelGroup();
		
		for(final Option input : inputs) {
			JLabel label = new JLabel(input.text + ": ");
			JTextField field = new JTextField(20);
			
			field.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					listener.clearStatus();
				}

				public void focusGained(FocusEvent e) {
					listener.updateStatus(input.message);
				}
			});
			
			labels.addComponent(label);
			textFields.addComponent(field);
			
			vertical.addGroup( layout.createParallelGroup()
					.addComponent(label)
					.addComponent(field));
		}
		
		horizontal.addGroup(layout.createSequentialGroup()
				.addGroup(labels)
				.addGroup(textFields));
		
		layout.setVerticalGroup(vertical);
		layout.setHorizontalGroup(horizontal);
	}

}
