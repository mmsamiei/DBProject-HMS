import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class TableModel extends AbstractTableModel{
	static DefaultTableModel defTableModel = new DefaultTableModel();

	public TableModel() {
		super();
	}
	
	@Override
	public int getColumnCount() {

		return defTableModel.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return defTableModel.getRowCount();
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		System.out.println(defTableModel.getValueAt(rowIndex, columnIndex));
		return defTableModel.getValueAt(rowIndex, columnIndex);
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    
	    defTableModel = new DefaultTableModel(data, columnNames);
	    return defTableModel;
	}
	


}
