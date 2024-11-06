import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class loginadmin extends JFrame {
    Label username = new Label("Username");
    TextField kotakuser = new TextField();
    Label password = new Label("Password");
    TextField kotakpass = new TextField();
    JButton login = new JButton("Login");
    JButton exit = new JButton("Exit");

    private Connection connection;

    loginadmin(){
        setTitle("Login Admin");
        setLocation(200, 100);
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeDatabaseConnection();

        login.addActionListener(e -> loginAdmin());
        exit.addActionListener(e -> System.exit(0));

        objek();
    }

    private void initializeDatabaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/loginadmin", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void loginAdmin() {
        String user = kotakuser.getText();
        String pass = kotakpass.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan masukkan username dan password.");
            return;
        }

        try {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Login failed: " + e.getMessage());
        }
    }

    void objek() {
        getContentPane().setLayout(null);
        getContentPane().add(username);
        getContentPane().add(kotakuser);
        getContentPane().add(password);
        getContentPane().add(kotakpass);
        getContentPane().add(login);
        getContentPane().add(exit);

        username.setBounds(50, 50, 80, 30);
        kotakuser.setBounds(150, 50, 180, 30);
        password.setBounds(50, 100, 80, 30);
        kotakpass.setBounds(150, 100, 180, 30);
        login.setBounds(100, 200, 80, 30);
        exit.setBounds(200, 200, 80, 30);

        setVisible(true);
    }

    public static void main(String[] args) {
        new loginadmin();
    }
}
