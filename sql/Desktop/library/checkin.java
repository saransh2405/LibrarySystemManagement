package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;



public class checkin {

	private JFrame frame;
	private JTextField bidtextField;
	private JTextField cnotextField_1;
	private JTextField fnametextField_2;
	private JTable table;
	JRadioButton rdbtnBookId;
	JRadioButton rdbtnCardNo;
	List<List> tablevalues=new ArrayList();
	
	String cbookid;
	String ccardno;
	String clname;
	String cfname;
	String loanid;
	String branchid;
	String dateout;
	String datein;
	String duedate;
	
	//for storing table values
	String tbookid=null;
	String tloanid=null;
	String tbranchid=null;
	String tcardno=null;
	//to store text field values
	String book_id;
	
	//Object[][] values;
	
	static Connection conn=null;
	private JButton btnUpdate;
	private JRadioButton rdbtnLname;
	private JTextField lnametextField;
	private JRadioButton rdbtnFname;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public checkin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frame.setBounds(100, 100, 676, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocation(0, 0);
		frame.setTitle("Check In");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 640, 252);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				  
	    		tloanid=(table.getModel().getValueAt(row,0).toString());
	    		System.out.println("tloanid="+tloanid);
	    		tbookid=(table.getModel().getValueAt(row,1).toString());
	    		tbranchid=(table.getModel().getValueAt(row,2).toString());
	    		tcardno=(table.getModel().getValueAt(row,3).toString());
	    		
				
			}
		});
		
		scrollPane.setViewportView(table);
		final String columnName[] ={"loan id", "book_id", "branch_id", "card_no", "date_out", "fname","lname"};
		//table.setModel(new DefaultTableModel(values,7));
		
		rdbtnBookId = new JRadioButton("BOOK ID");
		rdbtnBookId.setBackground(new Color(204, 204, 255));
		rdbtnBookId.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnBookId.setBounds(163, 24, 109, 23);
		frame.getContentPane().add(rdbtnBookId);
		
		rdbtnCardNo = new JRadioButton("CARD NO");
		rdbtnCardNo.setBackground(new Color(204, 204, 255));
		rdbtnCardNo.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnCardNo.setBounds(163, 65, 109, 23);
		frame.getContentPane().add(rdbtnCardNo);
		
		bidtextField = new JTextField();
		bidtextField.setBounds(411, 24, 136, 20);
		frame.getContentPane().add(bidtextField);
		bidtextField.setColumns(10);
		
		cnotextField_1 = new JTextField();
		cnotextField_1.setBounds(411, 65, 136, 20);
		frame.getContentPane().add(cnotextField_1);
		cnotextField_1.setColumns(10);
		
		fnametextField_2 = new JTextField();
		fnametextField_2.setBounds(411, 110, 136, 20);
		frame.getContentPane().add(fnametextField_2);
		fnametextField_2.setColumns(10);
		
		rdbtnLname = new JRadioButton("LAST NAME");
		rdbtnLname.setBackground(new Color(204, 204, 255));
		rdbtnLname.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnLname.setBounds(163, 149, 109, 23);
		frame.getContentPane().add(rdbtnLname);
		
		lnametextField = new JTextField();
		lnametextField.setBounds(411, 149, 136, 20);
		frame.getContentPane().add(lnametextField);
		lnametextField.setColumns(10);
		
		rdbtnFname = new JRadioButton("FIRST NAME");
		rdbtnFname.setBackground(new Color(204, 204, 255));
		rdbtnFname.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnFname.setBounds(163, 110, 109, 23);
		frame.getContentPane().add(rdbtnFname);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(206, 212, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					cbookid=bidtextField.getText();
					ccardno=cnotextField_1.getText();
					cfname=fnametextField_2.getText();
					clname=lnametextField.getText();
					
//					System.out.println("cbookid "+cbookid);
//					System.out.println("ccardno "+ccardno);

				
					String sqlQuery = "select Loan_id,Book_id,Branch_id,bl.Card_no,Date_out,fname,lname "
							+ "from book_loans as bl,borrower as b where b.fname like '%" + cfname + "%' and b.lname like '%" + clname
							+ "%' and bl.Book_id like '%" + cbookid + "%'" + " and bl.Card_no like '%" + ccardno
							+ "%' and b.Card_no=bl.Card_no and Date_in IS null;";
					System.out.println("sqlQuery = "+sqlQuery);
					
				
					try{
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

						Statement stmt = conn.createStatement();
						stmt.execute("use library;");
						ResultSet rs = stmt.executeQuery(sqlQuery);
						int linect=0;
						//storing the values in object array
						while (rs.next()) {
							
							List tempList = new ArrayList();
							
							linect++;
							
							for(int i=1;i<=7;i++)
							{
	//							System.out.println(rs.getString(i));
								tempList.add(rs.getString(i));
								
							}
							
							
							tablevalues.add(tempList);
							
						}
//						System.out.println("gn");
						if(tablevalues.isEmpty()){
							JOptionPane.showMessageDialog(frame, "Invalid entry", "Error", JOptionPane.PLAIN_MESSAGE);
							cnotextField_1.setText("");
							fnametextField_2.setText("");
							lnametextField.setText("");
							bidtextField.setText("");
							}

						Object[][] values=convertlist_to_object(tablevalues,7);
	//					System.out.println("sd");

						table.setModel(new DefaultTableModel(values,columnName));
						
						
					
//						System.out.println("loanid" +"\t"+ "bookid" +"\t"+ "branchid" +"\t"+ "cardno" +"\t"+ "dateout" +"\t"+ "duedate" +"\t"+ "datein");
						rs.close();
						conn.close();
						}//try
						catch(SQLException ex) {
							System.out.println("XXXXXXXXXXXXXXXError in connection: " + ex.getMessage());
						}
			
					
				}
		});
		btnOk.setBounds(341, 212, 89, 23);
		frame.getContentPane().add(btnOk);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
						
								conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
				
						
						Statement stmt = conn.createStatement();
					
						
						stmt.execute("use library;");

						


					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(date);
			        String date_in=dateFormat.format(date);
			        System.out.println("date in="+date_in);
			        String query="update book_loans set date_in='"+date_in+"' where loan_id="+tloanid;
					stmt.executeUpdate(query);
					query="update book_copies set No_of_copies =No_of_copies+1 where book_id='"+book_id+"' and branch_id="+tbranchid;
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(frame, "Check In Successful", "Success", JOptionPane.PLAIN_MESSAGE);
					cnotextField_1.setText("");
					fnametextField_2.setText("");
					lnametextField.setText("");
					bidtextField.setText("");
				//	rs.close();
					conn.close();
					System.out.println("Success!!");
				
				//	setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(274, 525, 89, 26);
		frame.getContentPane().add(btnUpdate);
		
		

		
		
	}
	public Object[][] convertlist_to_object(List<List> multiDimensionalList,int columnsize)
	{
		List<List> multiDimensionalList1 = new ArrayList();
		multiDimensionalList1=multiDimensionalList;
		Object[][] o = new Object[multiDimensionalList1.size()][columnsize];
		List temp1;
		for(int i=0;i<multiDimensionalList1.size();i++)
		{
			temp1=multiDimensionalList1.get(i);
			for(int j=0;j<temp1.size();j++)
			{
				o[i][j]=temp1.get(j);
	//			System.out.print("bye");
				
			}
		}
		return o;
	}
	
	
}
