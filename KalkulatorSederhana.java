import javax.swing.*;
import java.awt.event.*;

public class KalkulatorSederhana extends JFrame implements ActionListener {
    // Komponen GUI
    private JTextField angkaPertama, angkaKedua, hasil;
    private JButton tambah, kurang, kali, bagi;

    // Konstruktor untuk membuat GUI
    public KalkulatorSederhana() {
        // Mengatur layout dan judul
        setTitle("Kalkulator Sederhana");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        // Membuat dan menambahkan komponen ke frame
        JLabel label1 = new JLabel("Masukkan Angka Pertama:");
        label1.setBounds(20, 20, 200, 20);
        add(label1);
        
        angkaPertama = new JTextField();
        angkaPertama.setBounds(20, 50, 150, 30);
        add(angkaPertama);

        JLabel label2 = new JLabel("Masukkan Angka Kedua:");
        label2.setBounds(20, 90, 200, 20);
        add(label2);
        
        angkaKedua = new JTextField();
        angkaKedua.setBounds(20, 120, 150, 30);
        add(angkaKedua);
        
        // Tombol operasi
        tambah = new JButton("+");
        kurang = new JButton("-");
        kali = new JButton("*");
        bagi = new JButton("/");

        tambah.setBounds(20, 160, 50, 30);
        kurang.setBounds(80, 160, 50, 30);
        kali.setBounds(140, 160, 50, 30);
        bagi.setBounds(200, 160, 50, 30);

        // Mendaftarkan action listener ke tombol
        tambah.addActionListener(this);
        kurang.addActionListener(this);
        kali.addActionListener(this);
        bagi.addActionListener(this);

        // Menambahkan tombol ke frame
        add(tambah);
        add(kurang);
        add(kali);
        add(bagi);

        JLabel labelHasil = new JLabel("Hasil:");
        labelHasil.setBounds(20, 200, 150, 20);
        add(labelHasil);
        
        hasil = new JTextField();
        hasil.setBounds(20, 230, 150, 30);
        hasil.setEditable(false);  // Supaya tidak bisa diubah secara manual
        add(hasil);

        // Menampilkan frame
        setVisible(true);
    }

    // Implementasi ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double angka1 = Double.parseDouble(angkaPertama.getText());
            double angka2 = Double.parseDouble(angkaKedua.getText());
            double hasilOperasi = 0;

            if (e.getSource() == tambah) {
                hasilOperasi = angka1 + angka2;
            } else if (e.getSource() == kurang) {
                hasilOperasi = angka1 - angka2;
            } else if (e.getSource() == kali) {
                hasilOperasi = angka1 * angka2;
            } else if (e.getSource() == bagi) {
                if (angka2 != 0) {
                    hasilOperasi = angka1 / angka2;
                } else {
                    JOptionPane.showMessageDialog(this, "Tidak bisa membagi dengan nol!");
                    return;
                }
            }
            hasil.setText(String.valueOf(hasilOperasi));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!");
        }
    }

    // Main method
    public static void main(String[] args) {
        new KalkulatorSederhana();
    }
}
