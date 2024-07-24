package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        // Use the correct JDBC URL format
        String url = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
        String userName = "hr";
        String password = "hr";
        String query = "select * from employees";

            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name")
                +"  " + rs.getString("employee_id") + " " + rs.getInt("salary"));
            }
            st.close();
            con.close();
    }
}
