import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LembarPenilaian extends JFrame {
    Label nim = new Label("NIM");
    TextField kotaknim = new TextField();
    JButton cari = new JButton("Cari");
    Label nama = new Label("Nama");
    TextField kotaknama = new TextField();
    Label kelas = new Label("Kelas");
    JRadioButton pilihi = new JRadioButton("I");
    JRadioButton pilihj = new JRadioButton("J");
    JRadioButton pilihk = new JRadioButton("K");
    ButtonGroup kelasGroup = new ButtonGroup();
    Label matakuliah = new Label("Matakuliah");
    String[] items = {"Kalkulus", "Pemrograman", "Teknik Digital", "Persamaan Diferensial", "Vektor Matriks"};
    JComboBox<String> matkul = new JComboBox<>(items);
    JButton edit = new JButton("Edit");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    Connection connection;

    LembarPenilaian() {
        setTitle("Lembar Penilaian");
        setLocation(200, 100);
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeDatabaseConnection();

        cari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cariData();
            }
        });

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editData();
            }
        });

        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });

        hapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hapusData();
            }
        });

        keluar.addActionListener(e -> System.exit(0));
    }

    private void initializeDatabaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lisa_24051130006", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void cariData() {
        String nim = kotaknim.getText();
        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a NIM.");
            return;
        }

        try {
            String query = "SELECT * FROM siswa WHERE nim = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                kotaknama.setText(rs.getString("nama"));

                String kelas = rs.getString("kelas");
                if (kelas.equals("I")) pilihi.setSelected(true);
                else if (kelas.equals("J")) pilihj.setSelected(true);
                else if (kelas.equals("K")) pilihk.setSelected(true);

                matkul.setSelectedItem(rs.getString("matkul"));
            } else {
                JOptionPane.showMessageDialog(this, "Data not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void editData() {
        kotaknama.setEditable(true);
        pilihi.setEnabled(true);
        pilihj.setEnabled(true);
        pilihk.setEnabled(true);
        matkul.setEnabled(true);
    }

    private void simpanData() {
        try {
            String nim = kotaknim.getText();
            String nama = kotaknama.getText();
            String kelas = pilihi.isSelected() ? "I" : pilihj.isSelected() ? "J" : "K";
            String mataKuliah = (String) matkul.getSelectedItem();

            String updateQuery = "UPDATE siswa SET nama = ?, kelas = ?, matkul = ? WHERE nim = ?";
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1, nama);
            ps.setString(2, kelas);
            ps.setString(3, mataKuliah);
            ps.setString(4, nim);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        }
    }

    private void hapusData() {
        String nim = kotaknim.getText();
        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a NIM to delete.");
            return;
        }

        try {
            String deleteQuery = "DELETE FROM siswa WHERE nim = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setString(1, nim);
            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                kotaknim.setText("");
                kotaknama.setText("");
                kelasGroup.clearSelection();
                matkul.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
    }

    void objek() {
        getContentPane().setLayout(null);
        getContentPane().add(nim);
        getContentPane().add(kotaknim);
        getContentPane().add(cari);
        getContentPane().add(nama);
        getContentPane().add(kotaknama);
        getContentPane().add(kelas);
        getContentPane().add(pilihi);
        getContentPane().add(pilihj);
        getContentPane().add(pilihk);
        getContentPane().add(matakuliah);
        getContentPane().add(matkul);
        getContentPane().add(edit);
        getContentPane().add(simpan);
        getContentPane().add(hapus);
        getContentPane().add(keluar);

        kelasGroup.add(pilihi);
        kelasGroup.add(pilihj);
        kelasGroup.add(pilihk);

        nim.setBounds(10, 15, 30, 10);
        kotaknim.setBounds(100, 10, 100, 22);
        cari.setBounds(240, 10, 160, 22);
        nama.setBounds(10, 35, 40, 30);
        kotaknama.setBounds(100, 40, 300, 22);
        kelas.setBounds(10, 65, 40, 30);
        pilihi.setBounds(100, 65, 40, 30);
        pilihj.setBounds(140, 65, 40, 30);
        pilihk.setBounds(180, 65, 40, 30);
        matakuliah.setBounds(10, 98, 60, 30);
        matkul.setBounds(100, 100, 100, 25);
        edit.setBounds(10, 140, 100, 25);
        simpan.setBounds(110, 140, 100, 25);
        hapus.setBounds(210, 140, 100, 25);
        keluar.setBounds(320, 140, 80, 25);
        setVisible(true);
    }

    public static void main(String[] args) {
        LembarPenilaian ZZ = new LembarPenilaian();
        ZZ.objek();
    }
}
