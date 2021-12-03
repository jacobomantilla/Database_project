import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.ResultSet;

//import java.util.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

//import package DATABASE_PROJECT;



public class App {
    
        public static void main(String[] args) throws Exception {
            //initialize db connection
            exec myExec = new exec("jacobo", "3306", "free");
            

            //Creating the Frame
            JFrame frame = new JFrame("Database GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create the text area for user to input queries
            JPanel queryPanel = new JPanel(new BorderLayout());
            JTextArea queryInput = new JTextArea();
            JButton submit = new JButton("Submit");
            queryInput.setLineWrap(true);
            JScrollPane scrollPaneRight = new JScrollPane(queryInput);
            queryPanel.add(scrollPaneRight, BorderLayout.CENTER);
            queryPanel.add(submit, BorderLayout.PAGE_END);


            //Set up table list with hard coded values for the tables in the project
            String[] tableNames = {"db_book", "db_customer", "db_employee",
                                    "db_order_detail", "db_order", "db_shipper", "db_subject","db_supplier"};
            JList<String> tableList = new JList<String>(tableNames);
            JScrollPane scrollPaneLeft = new JScrollPane(tableList);

                
            //Set up table display with hard coded values from db_book.csv
            String[][] tableDataMatrix = {{"BookID","Title","UnitPrice","Author","Quantity","SupplierID","SubjectID"},{"1","book1","12.34","author1","5","3","1"},{"2","book2","56.78","author2","2","3","1"},{"3","book3","90.12","author3","10","2","1"},{"4","book4","34.56","author4","12","3","2"}, {"5","book5","78.90","author5","5","2","2"}, {"6","book6","12.34","author6","30","1","3"}, {"7","book7","56.90","author2","17","3","4"}, {"8","book8","33.44","author7","2","1","3"}};

            TableModel dataModel = new AbstractTableModel() {
                public int getColumnCount() { return 7; }
                public int getRowCount() { return 8;}
                public Object getValueAt(int row, int col) { return tableDataMatrix[row+1][col]; }
                public String getColumnName(int col) {return tableDataMatrix[0][col];}
            };
            JTable outputTable = new JTable(dataModel);
            JScrollPane scrollPaneBottom = new JScrollPane(outputTable);
        

            
            //creating the left and right split panes
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneLeft, queryPanel);
            splitPane.setDividerLocation(300);
            JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, scrollPaneBottom);
            splitPane2.setDividerLocation(400);
            splitPane.setOneTouchExpandable(true);
    
            // Creating the panel at bottom and adding components
            // JPanel panel = new JPanel();
            // JLabel label = new JLabel("Enter Text");
            // JTextField tf = new JTextField(10);
            // JButton send = new JButton("Send");
            // JButton reset = new JButton("Reset");

            frame.add(splitPane2, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setSize(700, 700);
            frame.setVisible(true);

            // Handling Button Click Event
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //save the data in the text field to fetch data from DB
                    //String databaseQuery = queryInput.getText();
                    queryInput.setText("");
                    //call function to get tables from the DB using the query input
                    /*make a function that takes string query input, executes it in Maria,
                         and returns the resulting dataset.
                         Then use that dataset in order to populate the table with next commands*/
                    //throw an exception if the query includes the keyword DROP
                    
                }
            });

            //Handling table selection from left panel
            tableList.addListSelectionListener(new ListSelectionListener() {

                @Override public void valueChanged(ListSelectionEvent arg0) {
                    System.out.println(tableList.getSelectedValue().toString());
                    String tableName = tableList.getSelectedValue().toString();
                    String query = "SELECT * FROM " + tableName;
                    ResultSet rs = myExec.getQueryData(query);
                }
            });

            //handling the input from the textbox 
            // queryInput.addKeyListener(l);
            //     String queryInput.getText()
            //handling the input from the JList elements

            //building the table according to the elements fetched from the keyboard
        
    }
}

