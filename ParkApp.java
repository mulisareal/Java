import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;

public class ParkApp extends JFrame {
    JLabel title = new JLabel("Plaza Parking Management");
    JTextArea inputPlat = new JTextArea();
    JButton searchButton = new JButton("Search");
    JButton deleteButton = new JButton("Out");
    JButton addbButton = new JButton("In");
    

    //Font
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font inputFont = new Font("SansSerif", Font.BOLD, 15);

    ParkApp() {
        setTitle("Plaza Parking App");
        setLocationRelativeTo(null);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(title);
        getContentPane().add(inputPlat);
        getContentPane().add(searchButton);
        getContentPane().add(deleteButton);
        getContentPane().add(addbButton);
        
        title.setFont(font1);
        title.setBounds(232, 30, 300, 25);
        inputPlat.setBounds(30, 92, 150, 23);
        inputPlat.setFont(inputFont);
        searchButton.setBounds(190, 90, 100, 25);
        addbButton.setBounds(300, 90, 100, 25);
        deleteButton.setBounds(410, 90, 100, 25);
    }

    void event() {

        //Table
        JTable dataTable = new JTable();
        dataTable.setEnabled(false);
        JScrollPane dataPanel = new JScrollPane(dataTable);
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[3];
        columnsName[0] = "Nomer Plat";
        columnsName[1] = "Tanggal, Jam masuk";
        columnsName[2] = "Total tarif";
        model.setColumnIdentifiers(columnsName);

        try {
            final String getData = "SELECT * FROM vechicle_parked;";
            Connection con = SQLCon.getConnetion();
            PreparedStatement ps = con.prepareStatement(getData);
            ResultSet rs = ps.executeQuery();
            Object[] data;

            while (rs.next()) {
               data = new Object[]  {rs.getString("plat"), rs.getString("time_in")};
               model.addRow(data);
            }
        } catch (SQLException e) {
            SQLCon.printSQLException(e);
        } finally {
            System.out.println("Done table process");
        }

        dataTable.setModel(model);
        getContentPane().add(dataPanel);
        dataPanel.setBounds(20, 200, 500, 300);

        //Auto Capslock input plat
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
        ParkApp app = new ParkApp();
        app.object();
        app.event();
    }
}
