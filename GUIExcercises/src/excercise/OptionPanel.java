package excercise;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class OptionPanel extends JPanel implements ItemListener {
	private static final long serialVersionUID = 187547734131707680L;
	private Map<JToggleButton, String> checkboxes;
	private StatusListener statusListener;

	public OptionPanel(String label, String[] options, String[] messages, StatusListener statusListener, boolean allowMultipleSelections ) {
		checkboxes = new HashMap<JToggleButton, String>();
		this.statusListener = statusListener;
		this.add(new JLabel(label + ": "));
		
		ButtonGroup group = new ButtonGroup();
		
		for( int i = 0; i < options.length; i++ ) {
			JToggleButton option = allowMultipleSelections ? new JCheckBox(options[i]) : new JRadioButton(options[i]);
			option.addItemListener(this);
			checkboxes.put(option, messages[i]);
			if( !allowMultipleSelections ) group.add(option);
			this.add(option);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if( e.getStateChange() == ItemEvent.SELECTED) {
			//JOptionPane.showMessageDialog(this, checkboxes.get(e.getSource()));
			statusListener.updateStatus(checkboxes.get(e.getSource()));
		}
		
	}

	
	

}
