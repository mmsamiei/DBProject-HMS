import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private	TextPanel queryJtext;
	private JButton submitButton;
	private ToolBar toolbar;
	
	public MainFrame() {
		super("DataBaseProject");
		
		setLayout(new BorderLayout());
		
		toolbar = new ToolBar();
		queryJtext=new TextPanel();
		submitButton = new JButton("submit");
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//queryJtext.append("hello");
			}
		});
		
		add(toolbar,BorderLayout.NORTH);
		add(queryJtext,BorderLayout.CENTER);
		add(submitButton,BorderLayout.SOUTH);
		
		
		
		
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
