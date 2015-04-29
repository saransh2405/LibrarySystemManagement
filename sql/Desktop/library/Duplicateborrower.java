package library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Duplicateborrower {
	
	static Connection conn = null;
	/**
	 * @param args
	 */
	public Duplicateborrower() {

		// Initialize variables for fields by data type
		String bookid;
		String title;
		
		//int linect = 0;

	try {
		// Create a connection to the local MySQL server, with the "company" database selected.
		//		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
		// Create a connection to the local MySQL server, with the NO database selected.
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

		// Create a SQL statement object and execute the query.
		Statement stmt = conn.createStatement();
	
		// Set the current database, if not already set in the getConnection
		// Execute a SQL statement
		stmt.execute("use library;");
		
		String first=Database1.txtBFirst.getText();
		String last=Database1.txtBLast.getText();
		String address=Database1.txtBAddress.getText();
		String phone=Database1.txtBPhone.getText();
		String f,l,a;
		String sql="INSERT INTO borrower(Fname, Lname, Address, Phone) VALUES('"+first+"', '"+last+"', '"+address+"', '"+phone+"')";
		int rd=0;
		// Execute a SQL query using SQL as a String object
		
		ResultSet rs = stmt.executeQuery("SELECT Fname, Lname, Address FROM borrower WHERE Fname='"+first+"' AND Lname='"+last+"' AND Address='"+address+"' ");
		// Iterate through the result set using ResultSet class's next() method
		
			// Keep track of the line/tuple count
			//linect++;
			// Populate field variables
			
		/*	f = rs.getString("Fname");
			l = rs.getString("Lname");
			a = rs.getString("Address");*/
			
			 if(rs.first()){
				
				JOptionPane.showMessageDialog(null, "User already exists!", "Duplicate", JOptionPane.ERROR_MESSAGE);
				
			} 
		 else { rd=stmt.executeUpdate(sql); }
		 
			// Do something with the data
			
		 // End while(rs.next())
			

		// Always close the recordset and connection.
		rs.close();
		conn.close();
		//System.out.println("Success!!");
	} 
	catch(SQLException ex) {
		System.out.println("Error in connection: " + ex.getMessage());
	}
}

/*
 *
 */
static void newln() {
	System.out.println();
}

}
