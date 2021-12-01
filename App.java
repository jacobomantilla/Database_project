import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;



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

            //figure out how to set up this text area correctly
            JTextArea queryInput = new JTextArea();

            //figure out how to set up this list a little better
            JList<String> tableList = new JList<String>();
            
            //creating the left and right split panes
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tableList, queryInput);
            splitPane.setOneTouchExpandable(true);
            splitPane.setDividerLocation(250);

            //creating the table output pane
            // JTable outputTable = new JTable();

            //Creating the top and bottom split panes
            // JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, outputTable);
            // splitPane2.setOneTouchExpandable(true);
            // splitPane2.setDividerLocation(400);

    
            // Text Area at the Center
            JTextArea ta = new JTextArea();
    
            // Creating the panel at bottom and adding components
            JPanel panel = new JPanel(); // the panel is not visible in output
            JLabel label = new JLabel("Enter Text");
            JTextField tf = new JTextField(10);
            JButton send = new JButton("Send");
            JButton reset = new JButton("Reset");
    
            // Handling Button Click Event
            send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.setText(tf.getText());
                }
            });
            panel.add(label); // Components Added using Flow Layout
            panel.add(tf);
            panel.add(send);
            panel.add(reset);
    
            //Adding Components to the frame.
            // frame.getContentPane().add(BorderLayout.SOUTH, panel);
            frame.getContentPane().add(BorderLayout.NORTH, mb);
            frame.getContentPane().add(BorderLayout.CENTER, splitPane);
            frame.setVisible(true);
        }
    } 
