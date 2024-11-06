

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Entity {
    protected Connection getConnection() throws SQLException {
        String pass = "mypass";
        String userDB = "root";
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/ePay", userDB, pass);
        return conn;
    }

    protected ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        return st.executeQuery(sql);
    }
}