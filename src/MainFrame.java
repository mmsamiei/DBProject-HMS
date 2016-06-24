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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private JButton submitButton;
	private ToolBar toolbar;
	private TablePanel tablePanel;
	private Connection con;
	private String username;
	private String password;
	private JFrame thisFrame;

	public MainFrame(String username, String password) throws SQLException {

		super("DataBaseProject");
		thisFrame = this;
		this.username = username;
		this.password = password;

		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/healthsystem", username, password);

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

		setSize(600, 600);
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

				String[] splitted = textPanel.getTextArea().getText()
						.toString().split(" ");

				switch (splitted[0]) {
				case "select":
					try {
						Statement statement = con.createStatement();
						ResultSet rset = statement.executeQuery(textPanel
								.getTextArea().getText().toString());
						tablePanel.refresh(rset);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(thisFrame, e.getMessage());
					}
					break;

				default:
					try {
						Statement statement = con.createStatement();
						statement.executeUpdate(textPanel.getTextArea()
								.getText().toString());
						statement.close();
						System.out.println("database updated well");
					} catch (SQLException e) {
						System.err.println("we have error in update");
						JOptionPane.showMessageDialog(thisFrame, e.getMessage());
					}

					break;
				}

			}
		});
	}

	public void setFrame(JFrame jfram) {
		this.thisFrame = jfram;
	}
}
