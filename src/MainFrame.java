import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;




public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private JButton submitButton;
	private ToolBar toolbar;
	private TablePanel tablePanel;
	private Connection con;
	
	public MainFrame() throws SQLException {
		super("DataBaseProject");
		
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/healthsystem","root","1376");
		
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
		
		
		submitButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
//					try {
//						Statement statement = con.createStatement();
//						statement.executeUpdate(textPanel.getTextArea().getText().toString());
//						statement.close();
//						System.out.println("database updated well");
//					} catch (SQLException e) {
//						System.err.println("we have error in update");
//						e.printStackTrace();
//						
//					}	
				
				try {
					Statement statement = con.createStatement();
					ResultSet rset = statement.executeQuery(textPanel.getTextArea().getText().toString());
					tablePanel.refresh(rset);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
