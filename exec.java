//package DATABASE_PROJECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class exec {
    String dbName;
    String port;
    String pwd;
    Connection conn;
    ResultSet rs;
    public exec(String name, String port, String pwd){
        //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        this.dbName = name;
        this.port = port;
        this.pwd = pwd;
    }

    public ResultSet getQueryData(String query){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:"
            + port + "/" + dbName + "?" +
            "user=root&password=" + pwd);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //return conn;
    }catch (SQLException ex){
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }catch (Exception e){
        System.out.println("Unkown Error:" + e.getMessage());
    }
        return rs;
    }

      
        public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {
        
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames);
        }
        public static void main(String[] args){
            try{
                //the newInstance() call is a workaround for some
                //broken Java implementations
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                String dbName = "Your Database name";
                String port = "Your database server port";
                String pwd = "Your root password";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
                + port + "/" + dbName + "?" +
                "user=root&password=" + pwd);
             
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Planets");
                    while(rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("name");
                    System.out.println(id + "---" + name);
                }
            }catch (SQLException ex) {
                // handle the error
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            catch (Exception e){
                System.out.println("Unkown Error:" + e.getMessage());
            }
        }
}

    

