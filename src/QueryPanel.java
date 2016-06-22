import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class QueryPanel extends JPanel {
	private	TextPanel queryJtext;
	private JButton submitButton;
	public QueryPanel() {
		queryJtext = new TextPanel();
		submitButton = new JButton();
		
		setLayout(new BorderLayout());
		add(queryJtext,BorderLayout.NORTH);
		add(submitButton,BorderLayout.CENTER);
	}
}
