package library;

import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fines implements ActionListener {
	static Connection conn = null;
	JFrame frame;
	JPanel panel;
    JButton button;
    
Fines()
{
	frame =new JFrame("Fines");
	frame.setSize(500, 500);
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	//frame.add(new JLabel("Click here to refresh fines")).setBounds(140, 110, 500, 100);
	button = new JButton("Refresh");
	frame.add(button).setBounds(150, 200,129, 16);
	panel=new JPanel();
	button.addActionListener(this);
	frame.setVisible(true);
	
	
	
	
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	int card_no;
	float sum;
	  Vector column_name=new Vector();
	  Vector data=new Vector();
	  Vector row;
		
		
	try {
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/", "root", "root");
		Statement stmt = conn.createStatement();
		Statement stmt1 = conn.createStatement();
		stmt.execute("use library;");
		
	String sqlquery="INSERT INTO FINES(Loan_id,Fine_amt,paid)(select BL.Loan_id , case when (BL.Date_in is null) THEN datediff(curdate(),BL.Due_date)*0.25 ELSE datediff(BL.Date_in,BL.Due_date)*0.25 END,False From BOOK_LOANS BL LEFT JOIN FINES BF ON BF.Loan_id = BL.Loan_id where BF.Loan_id is null AND (BL.Due_date < BL.Date_in OR (BL.Date_in is null and BL.Due_date < curdate() )));";
	String sqlquery1="UPDATE FINES F JOIN BOOK_LOANS BL ON F.Loan_id = BL.Loan_id SET F.fine_amt = datediff(curdate(),BL.Due_date)*0.25 where BL.Date_in is null and F.paid = FALSE and fine_amt <> datediff(curdate(),Due_date)*0.25;";
    //Statement stmt=conn.createStatement();
    //Statement stmt1=conn.createStatement();
    int a=stmt.executeUpdate(sqlquery);
    int b=stmt1.executeUpdate(sqlquery1);
    
    JOptionPane.showMessageDialog(frame, "Refreshed Successfully !");
    
    
    	
    	String sql="select BL.card_no, sum(F.fine_amt) from BOOK_LOANS BL JOIN FINES F ON F.Loan_id = BL.Loan_id where BL.Date_in is not null and F.PAID = FALSE group by BL.card_no;";		
    	
        Statement sqlstmt=conn.createStatement();
    	ResultSet rsfines=sqlstmt.executeQuery(sql);
    	ResultSetMetaData metaData = rsfines.getMetaData();
	
    	int columns = metaData.getColumnCount();
		for(int i=1;i<=columns;i++)
		{
			column_name.addElement(metaData.getColumnName(i));
		}
	
    	while(rsfines.next())
    	{
    		
    	card_no=rsfines.getInt(1);
    	sum=rsfines.getFloat(2);
    	row=new Vector(columns);
        for(int i=1;i<=columns;i++)
        {
	         row.addElement(rsfines.getObject(i));
        
			}
        data.addElement(row);
     	

    }
		panel.setVisible(false);
		JPanel panel1=new JPanel();
		JFrame frame1=new JFrame();
		
     JTable table=new JTable(data,column_name);
     JScrollPane scrollPane=new JScrollPane(table);
     panel1.add(scrollPane);
     
    frame1.add(panel1);
    frame1.setSize(500, 500);
   
    
    panel1.setVisible(true);
   frame1.setVisible(true);
	

    	
    	FinesUpdate fu=new FinesUpdate();
    	
    	
    	
    
    
    
    
    
 
	
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	}

	
	
	
}
