package ex1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;


public class OptionPanel extends JPanel {
	private static final long serialVersionUID = 187547734131707680L;

	public OptionPanel(String title, String label, final StatusListener status, boolean allowMultipleSelections, Option...options ) {
		setBorder(BorderFactory.createTitledBorder(title));
		
		this.add(new JLabel(label + ": "));
		
		ButtonGroup group = new ButtonGroup();
		
		for( Option option: options ) {
			JToggleButton button = allowMultipleSelections ? new JCheckBox(option.text) : new JRadioButton(option.text);
			final String message = option.message;
			
			button.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if( e.getStateChange() == ItemEvent.SELECTED) {
						status.updateStatus(message);
					}
				}
			});
			
			if( !allowMultipleSelections ) group.add(button);
			this.add(button);
		}
	}
}
