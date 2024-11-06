import java.sql.*;

public class SQLCon {
    private static final String DB_url = "jdbc:mysql://localhost/parkingdb";
    private static final String DB_user = "root";
    private static final String DB_pw = "";

    public static Connection getConnetion() throws SQLException {
        return DriverManager.getConnection(DB_url, DB_user, DB_pw);
    }

    //Catch Exceptions
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

