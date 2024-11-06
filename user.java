import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
package dbObjects;

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
public class User extends Entity {
    private long idUser;
    private String userName;
    private String pass;
    private String fullName;
    private String email;
    private Date dateOfBirth;
    private String address;

    public User(long idUser, String userName, String pass, String fullName,
            String email, Date dateOfBirth, String address) {
        super();
        this.idUser = idUser;
        this.userName = userName;
        this.pass = pass;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public User(long idUser) throws SQLException {
        super();
        this.idUser = idUser;
        setUserById(idUser);
    }

    private void setUserById(long idUser) throws SQLException {
        ResultSet resultSet = getResultSet("SELECT * FROM User WHERE idUser = " + idUser);
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("idUser"));
            userName = resultSet.getString("username");
            pass = resultSet.getString("pass");
            fullName = resultSet.getString("fullname");
            email = resultSet.getString("email");
            dateOfBirth = resultSet.getDate("dateOfBirth");
            address = resultSet.getString("address");
        }
    }

    @Override
    public String toString() {
        return userName;
    }

}