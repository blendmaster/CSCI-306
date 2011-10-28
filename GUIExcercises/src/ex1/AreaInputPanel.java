package ex1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AreaInputPanel extends JPanel {
	private static final long serialVersionUID = -698315858131397397L;

	public AreaInputPanel(String title, String label, String text, final String status, final StatusListener listener) {
		super(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(title));
		
		JLabel theLabel = new JLabel(label + ": ");
		theLabel.setAlignmentY(LEFT_ALIGNMENT);
		add(theLabel,BorderLayout.PAGE_START);
			
		JTextArea area = new JTextArea(text,5,20);
		
		area.setFont(new Font("Georgia", Font.PLAIN, 18));
		area.setMargin(new Insets(5, 5, 5, 5 ));
		area.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				listener.clearStatus();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				listener.updateStatus(status);
			}
		});
		
		add(new JScrollPane(area), BorderLayout.CENTER);
	}

}
