package library;


import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class losdisplay extends JFrame
{
    public losdisplay()
    {
    	super("Seach Results");
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
      
        String bookid=Database1.txtBookid.getText();
        String title=Database1.txtTitle.getText();
        String author=Database1.txtAuthor.getText();
        String fname=Database1.txtFname.getText();
        String minit=Database1.txtMinit.getText();
        String lname=Database1.txtLname.getText();
        
        String sql = "SELECT DISTINCT b.Book_id AS 'Book Id', b.Title AS 'Title', a.Author_name AS 'Author', l.Branch_id AS 'Branch Id', c.No_of_copies AS 'No. of Copies',c.No_of_copies-(select count(*) from book_loans b where b.Book_id = c.Book_id and b.Branch_id = c.Branch_id) As 'Available copies'  FROM book b, book_authors a, library_branch l, book_copies c WHERE b.Book_id = a.Book_id and c.Branch_id = l.Branch_id and c.Book_id = a.Book_id and a.Book_id='0789305003';";

        
        try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/library", "root", "root" );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
        
        

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }

   /* public static void main(String[] args)
    {
        displayitdude frame = new displayitdude();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }*/
}