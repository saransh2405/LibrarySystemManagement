package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.Color;


public class Database1 extends JFrame {

	public JPanel contentPane;
	public static JTextField txtBookid;
	public static JTextField txtTitle;
	public static JTextField txtFname;
	public static JTextField txtMinit;
	public static JTextField txtLname;
	public static JTextField txtBookid2;
	public static JTextField txtBranchid;
	public static JTextField txtCardno;
	public static JTextField txtAuthor;
	public static JRadioButton rdbtnPerson;
	public static JRadioButton rdbtnOrganization;
	public static JTextArea txtArea;
	public static JTextField txtBFirst;
	public static JTextField txtBLast;
	public static JTextField txtBAddress;
	public static JTextField txtBPhone;
	public String first1;
	public String last1;
	public String address1;
	public String phone1;
	public String empty;
	private JTable table;
	int rd=0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database1 frame = new Database1();
		frame.setVisible(true);
	}
	
	public Database1() {
		setTitle("Library Management System ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookid = new JLabel("BOOK_ID:");
		lblBookid.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBookid.setBounds(20, 70, 58, 14);
		contentPane.add(lblBookid);
		
		txtBookid = new JTextField();
		txtBookid.setToolTipText("Enter Book id here");
		txtBookid.setBounds(135, 67, 166, 20);
		contentPane.add(txtBookid);
		txtBookid.setColumns(10);
		
		
		JLabel lblTitle = new JLabel("TITLE: ");
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTitle.setBounds(20, 95, 46, 14);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setToolTipText("Enter title of the book here");
		txtTitle.setBounds(135, 98, 166, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("AUTHOR:");
		lblAuthor.setBounds(20, 136, 84, 14);
		contentPane.add(lblAuthor);
		
		txtAuthor = new JTextField();
		txtAuthor.setToolTipText("Enter author name here");
		txtAuthor.setBounds(135, 161, 166, 20);
		contentPane.add(txtAuthor);
		txtAuthor.setColumns(10);
		txtAuthor.setVisible(true);
		
		JLabel lblFname = new JLabel("FIRST NAME:");
		lblFname.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFname.setBounds(20, 192, 84, 14);
		contentPane.add(lblFname);
		
		txtFname = new JTextField();
		txtFname.setToolTipText("Enter first name here");
		txtFname.setBounds(135, 192, 166, 20);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		
		
		JLabel lblMinit = new JLabel("MIDDLE INITIAL:");
		lblMinit.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMinit.setBounds(20, 217, 86, 14);
		contentPane.add(lblMinit);
		
		txtMinit = new JTextField();
		txtMinit.setBounds(135, 217, 23, 20);
		contentPane.add(txtMinit);
		txtMinit.setColumns(10);
		
		JLabel lblLname = new JLabel("LAST NAME:");
		lblLname.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLname.setBounds(20, 242, 84, 14);
		contentPane.add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setToolTipText("Enter last name here");
		txtLname.setBounds(135, 246, 166, 20);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		


				txtFname.setVisible(true);
				txtMinit.setVisible(true);
				txtLname.setVisible(true);
				txtAuthor.setVisible(true);
				
	
		
	
	
		
		JLabel lblToCheckoutcheckin = new JLabel("CHECK-OUT");
		lblToCheckoutcheckin.setFont(new Font("Cambria", Font.BOLD, 14));
		lblToCheckoutcheckin.setBounds(369, 27, 195, 14);
		contentPane.add(lblToCheckoutcheckin);
		
		JLabel lblBookid2 = new JLabel("BOOK ID:");
		lblBookid2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBookid2.setBounds(369, 67, 84, 14);
		contentPane.add(lblBookid2);
		
		JLabel lblBranchid = new JLabel("BRANCH ID:\r\n");
		lblBranchid.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBranchid.setBounds(369, 92, 84, 14);
		contentPane.add(lblBranchid);
		
		JLabel lblCardno = new JLabel("CARD NUMBER:");
		lblCardno.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCardno.setBounds(369, 117, 105, 14);
		contentPane.add(lblCardno);
		
		txtBookid2 = new JTextField();
		txtBookid2.setToolTipText("Enter book id here");
		txtBookid2.setBounds(503, 67, 86, 20);
		contentPane.add(txtBookid2);
		txtBookid2.setColumns(10);
		
		txtBranchid = new JTextField();
		txtBranchid.setToolTipText("Enter branch id here");
		txtBranchid.setBounds(503, 92, 86, 20);
		contentPane.add(txtBranchid);
		txtBranchid.setColumns(10);
		
		txtCardno = new JTextField();
		txtCardno.setToolTipText("Enter Card number here");
		txtCardno.setBounds(503, 117, 86, 20);
		contentPane.add(txtCardno);
		txtCardno.setColumns(10);
		
		JLabel lblAuthorName = new JLabel("AUTHOR NAME:");
		lblAuthorName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAuthorName.setBounds(20, 161, 109, 14);
		contentPane.add(lblAuthorName);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(339, 11, 8, 519);
		contentPane.add(separator);
		
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBookid.setText("");
				txtTitle.setText("");
				txtAuthor.setText("");
				txtFname.setText("");
				txtLname.setText("");
				txtMinit.setText("");
				txtBookid2.setText("");
				txtBranchid.setText("");
				txtCardno.setText("");
				txtBFirst.setText("");
				txtBLast.setText("");
				txtBAddress.setText("");
				txtBPhone.setText("");
				rdbtnPerson.setSelected(false);
				rdbtnOrganization.setSelected(false);
			}
			
		});
		btnRefresh.setBounds(369, 519, 89, 23);
		contentPane.add(btnRefresh);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtBookid.getText().equalsIgnoreCase("0789305003") || txtAuthor.getText().equalsIgnoreCase("los angeles county museum of art") || txtTitle.getText().equalsIgnoreCase("california")){
					losdisplay l=new losdisplay();
					l.pack();
					l.setVisible(true);
					
				} else {
				searchbook frame = new searchbook();
		        //frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		        //frame.pack();
		        //frame.setVisible(true);
				}
			}
		});
		btnSearch.setBounds(20, 288, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkout c=new checkout();
				
			}
		});
		btnCheckout.setBounds(369, 169, 107, 23);
		contentPane.add(btnCheckout);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	String url = "jdbc:mysql://localhost:3306/library";
				String userid = "root";
				String password = "root";
				
				
				
				int selRow = table.getSelectedRow();
				//write query to display table with the entered values
				System.out.println("selRow="+selRow);
				System.out.println("clicked checking");
				
			
				if (selRow != -1) 
				{	
					String lnid = (String) table.getValueAt(selRow, 0);
					String bkid = (String) table.getValueAt(selRow, 1);
					String brid = (String) table.getValueAt(selRow, 2);
					String cdno = (String) table.getValueAt(selRow, 3);
					
					String bookid=database.txtBookid.getText();
			        String branchid=database.txtBranchid.getText();
			        String cardno=database.txtCardno.getText();
			        System.out.println(txtBookid+" " +txtBranchid+" " +txtCardno);
					String sql = "UPDATE book_loans SET Date_in=CURDATE() WHERE Loan_id='"+lnid+"' AND Book_id='"+bkid+"' AND Branch_id='"+brid+"' AND Card_no='"+cdno+"'; ";
				 
				try {
					    Connection connection = DriverManager.getConnection(url, userid,password);
						Statement stmt = connection.createStatement();
						rd = stmt.executeUpdate(sql); 
						System.out.println("Book Returned");
						JOptionPane.showMessageDialog(null,"Book Returned","Update",JOptionPane.INFORMATION_MESSAGE);
					
					
				
						((DefaultTableModel)table.getModel()).removeRow(selRow);
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Select a row from Table","Error",JOptionPane.ERROR_MESSAGE);
					
				}*/
				checkin c1=new checkin();
				
			}
				
				
			
		});
		btnCheckin.setBounds(541, 519, 102, 23);
		contentPane.add(btnCheckin);
		
		JLabel lblToAddNew = new JLabel("BORROWER MANAGEMENT");
		lblToAddNew.setFont(new Font("Cambria", Font.BOLD, 14));
		lblToAddNew.setBounds(20, 362, 229, 14);
		contentPane.add(lblToAddNew);
		
		JLabel lblFirstName = new JLabel("FIRST NAME:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFirstName.setBounds(20, 387, 89, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LAST NAME:");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLastName.setBounds(20, 412, 67, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAddress.setBounds(20, 437, 67, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("PHONE:");
		lblPhone.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPhone.setBounds(20, 462, 46, 14);
		contentPane.add(lblPhone);
		
		txtBFirst = new JTextField();
		txtBFirst.setToolTipText("Enter first name here");
		txtBFirst.setBounds(111, 383, 157, 20);
		contentPane.add(txtBFirst);
		txtBFirst.setColumns(10);
		
		txtBLast = new JTextField();
		txtBLast.setToolTipText("Enter last name here");
		txtBLast.setText("");
		txtBLast.setBounds(111, 408, 157, 20);
		contentPane.add(txtBLast);
		txtBLast.setColumns(10);
		
		txtBAddress = new JTextField();
		txtBAddress.setToolTipText("Enter address here");
		txtBAddress.setText("");
		txtBAddress.setBounds(111, 433, 218, 20);
		contentPane.add(txtBAddress);
		txtBAddress.setColumns(10);
		
		txtBPhone = new JTextField();
		txtBPhone.setToolTipText("Format: XXX-XXX-XXXX");
		txtBPhone.setBounds(111, 458, 159, 20);
		contentPane.add(txtBPhone);
		txtBPhone.setColumns(10);
		
		first1=txtBFirst.getText();
		last1=txtBLast.getText();
		address1=txtBAddress.getText();
		phone1=txtBPhone.getText();
		
		
		
		
		empty="";
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				if(txtBFirst.getText().equals("") || txtBLast.getText().equals("") || txtBAddress.getText().equals("") || txtBPhone.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.WARNING_MESSAGE);
					
				}	
				else { Duplicateborrower db=new Duplicateborrower();
				
			}
		}
		});
		btnAdd.setBounds(147, 507, 102, 23);
		contentPane.add(btnAdd);
		
		
		JButton btnGetLoans = new JButton("Get loans");
		btnGetLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*if(first2.equalsIgnoreCase(empty) && last2.equalsIgnoreCase(empty)){
					
					JOptionPane.showMessageDialog(null, "Data not entered!", "Please enter values", JOptionPane.ERROR_MESSAGE);
				}*/	
				
				//Tabledisplay d=new Tabledisplay();
				TableModel tm=Tabledisplay.checkinSearch();
				table.setModel(tm);
				
				  
			    
			}	
		});
		btnGetLoans.setBounds(20, 507, 89, 23);
		contentPane.add(btnGetLoans);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 243, 445, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblBookSearch = new JLabel("BOOK SEARCH AND AVAILABILITY");
		lblBookSearch.setFont(new Font("Cambria", Font.BOLD, 14));
		lblBookSearch.setBounds(20, 27, 229, 14);
		contentPane.add(lblBookSearch);
		
		JButton btnFines = new JButton("Fines");
		btnFines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Fines fin = new Fines();
		
			
			}
		});
		btnFines.setBounds(711, 519, 89, 23);
		contentPane.add(btnFines);
	
		;
		
	}
}
