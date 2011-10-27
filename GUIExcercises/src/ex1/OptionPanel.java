package ex1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;


public class OptionPanel extends JPanel {
	private static final long serialVersionUID = 187547734131707680L;

	public OptionPanel(String title, String label, Map<String,String> options, final StatusListener status, boolean allowMultipleSelections ) {
		setBorder(BorderFactory.createTitledBorder(title));
		
		this.add(new JLabel(label + ": "));
		
		ButtonGroup group = new ButtonGroup();
		
		for( Map.Entry<String, String> option: options.entrySet() ) {
			JToggleButton button = allowMultipleSelections ? new JCheckBox(option.getKey()) : new JRadioButton(option.getKey());
			final String message = option.getValue();
			
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
