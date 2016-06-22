import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private JButton submitButton;
	private ToolBar toolbar;
	private TablePanel tablePanel;
	
	public MainFrame() {
		super("DataBaseProject");
		
		
		toolbar = new ToolBar();
		tablePanel = new TablePanel();
		submitButton = new JButton("submit");
		textPanel = new TextPanel();
		
	    BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		add(toolbar);
		add(tablePanel);
		add(textPanel);
		add(submitButton);
		
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
