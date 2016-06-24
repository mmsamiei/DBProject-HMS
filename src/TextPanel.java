import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextPanel extends JPanel {
	private JTextArea textArea;
	public TextPanel() {
		setTextArea(new JTextArea());
		setLayout(new BorderLayout());
		
		add(new JScrollPane(getTextArea()), BorderLayout.CENTER);
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
}
