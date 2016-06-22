import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {
	private JButton logginButton, logoutButton, exitButton;

	public ToolBar() {
		logginButton = new JButton("Loggin");
		logoutButton = new JButton("Logout");
		exitButton = new JButton("Exit");

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(logginButton);
		add(logoutButton);
		add(exitButton);

		logginButton.addActionListener(this);
		logoutButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton clicked = (JButton) arg0.getSource();
		if (clicked.equals(logginButton)) {

		}
		if (clicked.equals(logoutButton)) {

		}
		if (clicked.equals(exitButton)) {

		}
	}
}
