import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class TablePanel extends JPanel {
	
	private JTable table;
	private JScrollPane scrollPane;
	public TablePanel(){
		
		
		table = new JTable();
		//scrollPane = new JScrollPane(table);
		//add(table);
		//add(scrollPane);
		
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
	}
	
}
