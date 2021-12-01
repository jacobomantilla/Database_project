import javax.swing.*;
import java.awt.BorderLayout;
//import java.awt.event.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class App {
        public static void main(String[] args) throws Exception {

            //Creating the Frame
            JFrame frame = new JFrame("Database GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 700);
            // Creating the MenuBar and adding components
            JMenuBar mb = new JMenuBar();
            JMenu m1 = new JMenu("FILE");
            JMenu m2 = new JMenu("Help");
            mb.add(m1);
            mb.add(m2);
            JMenuItem m11 = new JMenuItem("Open");
            JMenuItem m22 = new JMenuItem("Save as");
            m1.add(m11);
            m1.add(m22);


            //Create the text area for user to input queries
            JTextArea queryInput = new JTextArea();


            //Set up table list with hard coded values for the tables in the project
            String[] tableNames = {"db_book.csv", "db_customer.csv", "db_employee.csv",
                                    "db_order_detail.csv", "db_order.csv", "db_shipper.csv", "db_subject.csv","db_supplier.csv"};
            JList<String> tableList = new JList<String>(tableNames);

                
            //Set up table display with hard coded values from db_book.csv
            String[][] tableDataMatrix = {{"BookID","Title","UnitPrice","Author","Quantity","SupplierID","SubjectID"},{"1","book1","12.34","author1","5","3","1"},{"2","book2","56.78","author2","2","3","1"},{"3","book3","90.12","author3","10","2","1"},{"4","book4","34.56","author4","12","3","2"}, {"5","book5","78.90","author5","5","2","2"}, {"6","book6","12.34","author6","30","1","3"}, {"7","book7","56.90","author2","17","3","4"}, {"8","book8","33.44","author7","2","1","3"}};

            TableModel dataModel = new AbstractTableModel() {
                public int getColumnCount() { return 7; }
                public int getRowCount() { return 9;}
                public Object getValueAt(int row, int col) { return tableDataMatrix[row][col]; }
            };
            JTable outputTable = new JTable(dataModel);
            JButton submit = new JButton("Submit");
            outputTable.add(submit);

            
            //creating the left and right split panes
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tableList, queryInput);
            JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, outputTable);
            splitPane.setOneTouchExpandable(true);
            splitPane.setDividerLocation(250);
    
            // Creating the panel at bottom and adding components
            // JPanel panel = new JPanel();
            // JLabel label = new JLabel("Enter Text");
            // JTextField tf = new JTextField(10);
            // JButton send = new JButton("Send");
            // JButton reset = new JButton("Reset");

            frame.add(splitPane2, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setSize(500, 500);
            frame.setVisible(true);
            
            //Adding Components to the frame.
            // frame.getContentPane().add(BorderLayout.SOUTH, panel);
            // frame.getContentPane().add(BorderLayout.NORTH, mb);
            // frame.getContentPane().add(BorderLayout.CENTER, splitPane);
            // frame.setVisible(true);
            // Handling Button Click Event
            // send.addActionListener(new ActionListener() {
            //     @Override
            //     public void actionPerformed(ActionEvent e) {
            //         //ta.setText(tf.getText());
            //     }
            // });
            // panel.add(label); // Components Added using Flow Layout
            // panel.add(tf);
            // panel.add(send);
            // panel.add(reset);
        }
    }

