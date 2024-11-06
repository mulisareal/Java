import java.sql.*;

public class JDBC {
    public static void main (String[] args) throws Exception{
        String db_url = "jdbc:mysql://localhost:3306/lisa_24051130006";
        String db_user = "root";
        String db_pw = "";

        Connection con = DriverManager.getConnection(db_url, db_user, db_pw);
        Statement st = con.createStatement();

        ResultSet test = st.executeQuery("SELECT * FROM siswa");
        while (test.next()){
            System.out.println(test.getString(1));
            System.out.println(test.getString(2));
            System.out.println(test.getString(3));
            System.out.println(test.getString(4));

        }
    }
}
