package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class checkout {
	static Connection conn = null;
	static Connection conn1 = null;

	checkout() {
		String co_book_id, co_branch_id, co_card_no;
		int no_book_copies_available = 0;
		co_book_id = Database1.txtBookid2.getText();
		co_branch_id = Database1.txtBranchid.getText();
		co_card_no = Database1.txtCardno.getText();
		System.out.println(co_book_id+" "+co_branch_id+" "+co_card_no);
		if (co_book_id.equals("") || co_branch_id.equals("")
				|| co_card_no.equals("")) {

			JOptionPane.showMessageDialog(null,"Please enter all the mandatory fields! \n Book id,Branch id,Card no");

		} else if (!co_book_id.equals("") && !co_branch_id.equals("")
				&& !co_card_no.equals("")) { 
			
			int count = 0, count1 = 0, No_of_books_currently_checked = 0, max_checkout_of_book = 0;
			String sqlstatement = "select card_no,count(card_no)as no_of_books_checked from book_loans  where date_in IS NULL and date_out<=CURDATE() and card_no="
					+ co_card_no
					+ " group by card_no having count(card_no)>=3;";
			System.out.println(sqlstatement);
			
			max_checkout_of_book = activeCheckoutofCardno(sqlstatement,
					co_card_no);
			System.out.println("Max checkout of book=" + max_checkout_of_book);
			if (max_checkout_of_book == 0) {
				
				String sqlstatement2 = "select * from book_copies where book_id=\""
						+ co_book_id + "\" and branch_id=" + co_branch_id + ";";
				try {
					no_book_copies_available = book_availability(sqlstatement2,co_book_id, co_branch_id);
				} catch (SQLException ex) {
					Logger.getLogger(Database1.class.getName()).log(Level.SEVERE,
							null, ex);
				}
				if (no_book_copies_available >= 1) {
					
					try {
						
						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/", "root", "root");
						Statement stmt = conn.createStatement();
						stmt.execute("use library;");
						String sqlstatement3 = "insert into book_loans values(default,\""
								+ co_book_id
								+ "\",+"
								+ co_branch_id
								+ ","
								+ co_card_no
								+ ",CURDATE(),DATE_ADD(CURDATE(), INTERVAL 14 DAY),NULL);";
						int rss1 = 0;
						rss1 = stmt.executeUpdate(sqlstatement3);
						if (rss1 == 1) {
							
							JOptionPane.showMessageDialog(null, "Book "	+ co_book_id + "Successfully checked out!");
						} else {
							
							JOptionPane.showMessageDialog(null,"Failed to check out!");
						}
					} catch (SQLException ex) {
						System.out.println("Error in connection: " + ex.getMessage());
					}
					
				}
				
			}
			

		} else
			JOptionPane.showMessageDialog(null, "All the fields are mandatory!");

	}

	private int activeCheckoutofCardno(String statement, String card_num) {
		int active_checkout = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "root");
			Statement stmt = conn.createStatement();
			stmt.execute("use library;");
			try (ResultSet rs = stmt.executeQuery(statement)) {

				if (rs.first()) {
					do {
						JOptionPane.showMessageDialog(null,"Card_no: " + card_num + " already has 3 books checked out. No more books can be checked out! ");
						active_checkout = 1;
					} while (rs.next());
				}

				rs.close();
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
		}
		return active_checkout;
	}

	private int book_availability(String statement, String book_ids,
			String branch_ids) throws SQLException {
		int num_of_book_avai = 0,count = 0, activebooks = 0, temp = 0;
		activebooks = findTheactivebook(book_ids, Integer.parseInt(branch_ids));
		try {
			System.out.println("Now here!");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
					"root", "root");
			Statement stmt = conn.createStatement();
			stmt.execute("use library;");
			System.out.println("Statement to check avail copies in branch:"
					+ statement);
			try (ResultSet rs = stmt.executeQuery(statement)) {
				while (rs.next()) {
					System.out.println("checking number of copies available!");
					count++;
					temp = rs.getInt(3);

				}
				num_of_book_avai = temp - activebooks;
				if (num_of_book_avai == 0)
					JOptionPane.showMessageDialog(null,"No more copies of Book_id: " + book_ids	+ " are available at branch " + branch_ids + " !!");
				else {
					System.out.println("number of available copies:" + num_of_book_avai);
				//	System.out.println("Failed to check no of copies");
				}

				rs.close();
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
		}

		return num_of_book_avai;
	}
	
	public int findTheactivebook(String bid, int brid) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
	    Statement stmt1 = conn1.createStatement();
	   stmt1.execute("use library;");
	    int No_of_copies_borrow=0;
	     String sqlstatement1="select count(branch_id),branch_id,book_id from book_loans where book_id=\""+bid+"\"  and branch_id=\""+brid+"\" and  DATE_IN IS NULL AND DATE_OUT<=CURDATE() group by book_id,branch_id;";
	                            System.out.println(sqlstatement1);
	                            try(ResultSet rss=stmt1.executeQuery(sqlstatement1)){
	                                while(rss.next()){
	                                     No_of_copies_borrow=rss.getInt(1);
	                                     //System.out.println("Here"+No_of_copies_borrow);
	                                }
	                                rss.close();
	                            }
	                            catch(SQLException ex1) {
	                            JOptionPane.showMessageDialog(null,ex1);
	                            }
	              return No_of_copies_borrow;
	    
	}
	
}