package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




@SuppressWarnings("serial")
public class Tabledisplay extends JTable {
	
	Database1 d=new Database1();

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public static TableModel checkinSearch()
	{
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		// Connect to an MySQL Database, run query, get result set
				String url = "jdbc:mysql://localhost:3306/library";
				String userid = "root";
				String password = "root";
		String a=Database1.txtBFirst.getText();
		String b=Database1.txtBLast.getText();
		
			String sql = "SELECT b.Loan_id AS 'Loan Id', b.Book_id AS 'Book Id', b.Branch_id AS 'Branch Id', b.Card_no AS 'Card Number' FROM book_loans b, borrower c WHERE b.Card_no=c.Card_no AND c.Fname='"+a+"' AND c.Lname='"+b+"';";

		DefaultTableModel tableModel = new DefaultTableModel();
		
		String[] tableRow;
		tableModel.addColumn("Loan Id");
		tableModel.addColumn("Book Id");
		tableModel.addColumn("Branch Id");
		tableModel.addColumn("Card Number");
		
		

		


		
		//tableModel.addColumn("Book Id","Branch ID","Title","Author","No Of Copies","Available Copies");
		// Java SE 7 has try-with-resources
		// This will ensure that the sql objects are closed when the program
		// is finished with them
		try (Connection connection = DriverManager.getConnection(url, userid,password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.add(md.getColumnName(i));
			}

			// Get row data
			while (rs.next()) {
				ArrayList row = new ArrayList(columns);
				 tableRow = new String[6];
				
				tableRow[0] = rs.getString(1);
				tableRow[1] = rs.getString(2);
				tableRow[2] = rs.getString(3);
				tableRow[3] = rs.getString(4);
				
				tableModel.addRow(tableRow);
 
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tableModel;
	

	
	
}
}



