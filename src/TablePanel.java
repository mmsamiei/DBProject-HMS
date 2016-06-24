import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class TablePanel extends JPanel {
	
	public JTable table;

	public TableModel tableModel;
	
	
	public TablePanel() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
		



		

		
	}
	
	public void refresh(ResultSet resultSet) throws SQLException{
		System.out.println("1");
		tableModel.buildTableModel(resultSet);
		System.out.println("2");
		tableModel.fireTableDataChanged();
		System.out.println("3");
		remove(table);
		table = new JTable(tableModel);
		add(table, BorderLayout.CENTER);
	}
	
}
