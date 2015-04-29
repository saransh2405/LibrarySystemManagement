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

public class FinesUpdate implements ActionListener{
	
	static Connection conn = null;
	JFrame frame1;
	JPanel panel1;
	JTextField text;
	JButton button1;
	
FinesUpdate()
{
	
	
	frame1 =new JFrame("Fines");
	frame1.setSize(500, 500);
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.getContentPane().setLayout(null);
	frame1.getContentPane().add(new JLabel("Card No:")).setBounds(100, 110, 50, 16);
	text=new JTextField();
	text.setBounds(194,110,129,26);
	frame1.getContentPane().add(text); 
	
	button1 = new JButton("Pay fine");
	frame1.getContentPane().add(button1).setBounds(150, 200,129, 16);
	button1.addActionListener(this);
	frame1.setVisible(true);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	try {
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/", "root", "root");
	int cardno=Integer.parseInt(text.getText());	
		
String sql="UPDATE FINES F JOIN BOOK_LOANS BL ON F.Loan_id = BL.Loan_id SET F.paid = TRUE where BL.Date_in is not null and F.paid = FALSE and BL.card_no = '"+cardno+"';";		
Statement sqlstmt=conn.createStatement();
sqlstmt.execute("use library;");
int r=sqlstmt.executeUpdate(sql);



if(r!=0)
{
	JOptionPane.showMessageDialog(frame1,"UPDATED");
}
//else
//{
	//JOptionPane.showMessageDialog(frame1,"Error !");
//}
		
		
		
		
	}catch (SQLException e1) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(frame1,"Error !");
		e1.printStackTrace();
	}





}
	

}
