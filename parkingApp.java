import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class parkingApp extends JFrame {
    JLabel title = new JLabel("Plaza Parking Management");
    JTextArea inputPlat = new JTextArea();
    JButton searchButton = new JButton("Search");
    JButton deleteButton = new JButton("Out");
    JButton addButton = new JButton("In");
    JButton edit = new JButton("Edit");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton exitButton = new JButton("Exit");

    // Font
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font inputFont = new Font("SansSerif", Font.BOLD, 15);
    
    private Connection connection;

    parkingApp() {
        setTitle("Plaza Parking App");
        setLocationRelativeTo(null);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeDatabaseConnection();

        addButton.addActionListener(e -> tambahData()); 
        edit.addActionListener(e -> editData());
        simpan.addActionListener(e -> simpanData());
        hapus.addActionListener(e -> hapusData());
        exitButton.addActionListener(e -> System.exit(0));

        object();
        event();
    }

    private void tambahData() {
        String platNumber = inputPlat.getText().trim();
        if (platNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nomor plat");
            return;
        }
        
        LocalDateTime now = LocalDateTime.now();
        String entryTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            String insertQuery = "INSERT INTO tabelparkir (plat, waktu) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertQuery);
            ps.setString(1, platNumber);
            ps.setString(2, entryTime);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Vehicle entry recorded successfully.");
            inputPlat.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to record entry: " + e.getMessage());
        }
    }

    private void editData() {
        inputPlat.setEditable(true);
        String editPlat = inputPlat.getText();
        if (editPlat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a plate number to save.");
            return;
        }
    
        try {
            String updateQuery = "UPDATE tabelparkir SET plat = ? WHERE plat = ?";
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1, editPlat);
            ps.setString(2, editPlat);
            ps.executeUpdate();
    
            JOptionPane.showMessageDialog(this, "Data updated successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to update data: " + e.getMessage());
        }
    }
    private void initializeDatabaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/parkingapp", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void hapusData() {
        String editPlat = inputPlat.getText();
        if (editPlat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a plate number");
            return;
        }
        try {
            String deleteQuery = "DELETE FROM tabelparkir WHERE plat = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setString(1, editPlat);
            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Plate number deleted successfully.");
                inputPlat.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Plate number not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to delete plate number: " + e.getMessage());
        }
    }

    private void simpanData() {
        String editPlat = inputPlat.getText();
        if (editPlat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a plate number to save.");
            return;
        }

        try {
            String updateQuery = "UPDATE FROM tabelparkir SET plat = ? WHERE plat = ?";
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1, editPlat);
            ps.setString(2, editPlat); 
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data saved successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to save data: " + e.getMessage());
        }
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(title);
        getContentPane().add(inputPlat);
        getContentPane().add(searchButton);
        getContentPane().add(deleteButton);
        getContentPane().add(addButton);
        getContentPane().add(edit);
        getContentPane().add(simpan);
        getContentPane().add(hapus);
        getContentPane().add(exitButton);
        
        title.setFont(font1);
        title.setBounds(232, 30, 300, 25);
        inputPlat.setBounds(30, 92, 150, 23);
        inputPlat.setFont(inputFont);
        searchButton.setBounds(190, 90, 100, 25);
        addButton.setBounds(300, 90, 100, 25);
        deleteButton.setBounds(410, 90, 100, 25);
        edit.setBounds(190, 150, 100, 25);
        simpan.setBounds(300, 150, 100, 25);
        hapus.setBounds(410, 150, 100, 25);
        exitButton.setBounds(520, 90, 100, 25);
    }

    void event() {
        // Table
        JTable dataTable = new JTable();
        dataTable.setEnabled(false);
        JScrollPane dataPanel = new JScrollPane(dataTable);
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = {"Plate Number", "Entry Time", "Total Charge"};
        model.setColumnIdentifiers(columnsName);

        try {
            final String getData = "SELECT * FROM tabelparkir";
            Connection con = SQLCon.getConnetion();
            PreparedStatement ps = connection.prepareStatement(getData);
            ResultSet rs = ps.executeQuery();
            Object[] data;

            while (rs.next()) {
                data = new Object[]{rs.getString("plat"), rs.getString("waktu"), rs.getString("total_tarif")};
                model.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done table process");
        }

        dataTable.setModel(model);
        getContentPane().add(dataPanel);
        dataPanel.setBounds(20, 200, 650, 300);

        // Auto Capslock input
        inputPlat.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
    }

    public static void main(String[] args) {
        new parkingApp();
    }
}
