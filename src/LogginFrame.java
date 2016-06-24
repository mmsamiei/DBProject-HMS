import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class LogginFrame extends JFrame {
	private JTextField usernameTextField;
	private JTextField passwordTexField;
	private JButton submitJButton;
	public LogginFrame(){
		
		setLayout(null);
		
		setSize(400,400);
		
		usernameTextField = new JTextField();
		usernameTextField.setLocation(200, 0);
		usernameTextField.setSize(100,30);
		getContentPane().add(usernameTextField);

		
		passwordTexField = new JTextField();
		passwordTexField.setLocation(200, 200);
		passwordTexField.setSize(100,30);
		getContentPane().add(passwordTexField);

		
		
		submitJButton = new JButton();
		submitJButton.setLocation(200, 300);
		submitJButton.setSize(100, 30);
		submitJButton.setText("submit");
		getContentPane().add(submitJButton);
		submitJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					try {
						Connection con=DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/healthsystem",usernameTextField.getText().toString(),passwordTexField.getText().toString());
						System.out.println("salam ok ! I Love you mmsamiei ! :D ");
						MainFrame mainFrame = new MainFrame();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}  
				  
			}
		});

		setVisible(true);
	
	}
}
