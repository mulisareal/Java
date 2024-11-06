import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiLaundry extends JFrame {
    // Komponen untuk input data
    private JTextField txtNota, txtNama, txtAlamat, txtJumlah, txtTotalBayar;
    private JComboBox<String> cbJenisLaundry;
    private JCheckBox cbKarpet, cbBadCover;
    private JRadioButton rbYa, rbTidak;
    private JTextArea hasilOutput;
    private ButtonGroup antarJemputGroup;

    public AplikasiLaundry() {
        // Set up frame
        setTitle("Aplikasi Laundry");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setLayout(new GridBagLayout());

        // GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Komponen
        JLabel lblNota = new JLabel("No. Nota :");
        txtNota = new JTextField(15);
        JLabel lblNama = new JLabel("Nama Pelanggan :");
        txtNama = new JTextField(15);
        JLabel lblAlamat = new JLabel("Alamat :");
        txtAlamat = new JTextField(15);
        JLabel lblJenisLaundry = new JLabel("Jenis Laundry :");
        cbJenisLaundry = new JComboBox<>(new String[] {"Express", "Reguler", "Kilat"});
        JLabel lblJumlah = new JLabel("Jumlah :");
        txtJumlah = new JTextField(5);
        JLabel lblKg = new JLabel("Kg");
        JLabel lblTambahan = new JLabel("Tambahan :");
        cbKarpet = new JCheckBox("Karpet");
        cbBadCover = new JCheckBox("Bad Cover");
        JLabel lblAntarJemput = new JLabel("Antar Jemput :");
        rbYa = new JRadioButton("Ya");
        rbTidak = new JRadioButton("Tidak");
        antarJemputGroup = new ButtonGroup();
        antarJemputGroup.add(rbYa);
        antarJemputGroup.add(rbTidak);
        JLabel lblTotalBayar = new JLabel("Total Bayar :");
        txtTotalBayar = new JTextField(10);
        hasilOutput = new JTextArea(5, 20);
        hasilOutput.setEditable(false);

        // Tombol
        JButton btnBersih = new JButton("Bersih");
        JButton btnKeluar = new JButton("Keluar");
        JButton btnTampil = new JButton("Tampil");

        // Layouting (menggunakan GridBagLayout)
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        add(lblNota, gbc);
        gbc.gridx = 1;
        add(txtNota, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblNama, gbc);
        gbc.gridx = 1;
        add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblAlamat, gbc);
        gbc.gridx = 1;
        add(txtAlamat, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(lblJenisLaundry, gbc);
        gbc.gridx = 1;
        add(cbJenisLaundry, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(lblJumlah, gbc);
        gbc.gridx = 1;
        add(txtJumlah, gbc);
        gbc.gridx = 2;
        add(lblKg, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        add(lblTambahan, gbc);
        gbc.gridx = 1;
        add(cbKarpet, gbc);
        gbc.gridx = 2;
        add(cbBadCover, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        add(lblAntarJemput, gbc);
        gbc.gridx = 1;
        add(rbYa, gbc);
        gbc.gridx = 2;
        add(rbTidak, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        add(lblTotalBayar, gbc);
        gbc.gridx = 1;
        add(txtTotalBayar, gbc);

        gbc.gridx = 3; gbc.gridy = 0; gbc.gridheight = 8;
        add(new JScrollPane(hasilOutput), gbc);

        // Tombol di bagian bawah
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 1;
        add(btnBersih, gbc);
        gbc.gridx = 1;
        add(btnKeluar, gbc);
        gbc.gridx = 2;
        add(btnTampil, gbc);

        // Action Listeners
        btnTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilkanData();
            }
        });

        btnBersih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bersihkanForm();
            }
        });

        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void tampilkanData() {
        // Mengambil data dari form dan menampilkan di TextArea
        String nota = txtNota.getText();
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String jenisLaundry = (String) cbJenisLaundry.getSelectedItem();
        String jumlah = txtJumlah.getText();
        String tambahan = (cbKarpet.isSelected() ? "Karpet " : "") + (cbBadCover.isSelected() ? "Bad Cover" : "");
        String antarJemput = rbYa.isSelected() ? "Ya" : "Tidak";
        String totalBayar = txtTotalBayar.getText();

        // Menampilkan hasil
        hasilOutput.setText("Nota: " + nota + "\nNama: " + nama + "\nAlamat: " + alamat + 
                            "\nJenis Laundry: " + jenisLaundry + "\nJumlah: " + jumlah + " Kg" +
                            "\nTambahan: " + tambahan + "\nAntar Jemput: " + antarJemput +
                            "\nTotal Bayar: Rp" + totalBayar);
    }

    private void bersihkanForm() {
        // Mengosongkan semua input form
        txtNota.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtJumlah.setText("");
        cbKarpet.setSelected(false);
        cbBadCover.setSelected(false);
        antarJemputGroup.clearSelection();
        txtTotalBayar.setText("");
        hasilOutput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AplikasiLaundry frame = new AplikasiLaundry();
            frame.setVisible(true);
        });
    }
}
