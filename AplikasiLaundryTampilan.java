import javax.swing.*;
import java.awt.*;

public class AplikasiLaundryTampilan extends JFrame {
    
    private JTextField txtNota, txtNama, txtAlamat, txtJumlah, txtTotalBayar;
    private JComboBox<String> cbJenisLaundry;
    private JCheckBox cbKarpet, cbBadCover;
    private JRadioButton rbYa, rbTidak;
    private JTextArea hasilOutput;
    private ButtonGroup antarJemputGroup;

    public AplikasiLaundryTampilan() {
        setTitle("Aplikasi Laundry");
        setSize(600, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(null);

        JLabel lblNota = new JLabel("No. Nota :");
        lblNota.setBounds(20, 20, 100, 25);
        add(lblNota);
        txtNota = new JTextField();
        txtNota.setBounds(150, 20, 200, 25);
        add(txtNota);

        JLabel lblNama = new JLabel("Nama Pelanggan :");
        lblNama.setBounds(20, 60, 120, 25);
        add(lblNama);
        txtNama = new JTextField();
        txtNama.setBounds(150, 60, 200, 25);
        add(txtNama);

        JLabel lblAlamat = new JLabel("Alamat :");
        lblAlamat.setBounds(20, 100, 100, 25);
        add(lblAlamat);
        txtAlamat = new JTextField();
        txtAlamat.setBounds(150, 100, 200, 25);
        add(txtAlamat);

        JLabel lblJenisLaundry = new JLabel("Jenis Laundry :");
        lblJenisLaundry.setBounds(20, 140, 100, 25);
        add(lblJenisLaundry);
        cbJenisLaundry = new JComboBox<>(new String[] {"Express", "Reguler", "Kilat"});
        cbJenisLaundry.setBounds(150, 140, 200, 25);
        add(cbJenisLaundry);

        JLabel lblJumlah = new JLabel("Jumlah :");
        lblJumlah.setBounds(20, 180, 100, 25);
        add(lblJumlah);
        txtJumlah = new JTextField();
        txtJumlah.setBounds(150, 180, 50, 25);
        add(txtJumlah);

        JLabel lblKg = new JLabel("Kg");
        lblKg.setBounds(210, 180, 50, 25);
        add(lblKg);

        JLabel lblTambahan = new JLabel("Tambahan :");
        lblTambahan.setBounds(20, 220, 100, 25);
        add(lblTambahan);
        cbKarpet = new JCheckBox("Karpet");
        cbKarpet.setBounds(150, 220, 100, 25);
        add(cbKarpet);
        cbBadCover = new JCheckBox("Bad Cover");
        cbBadCover.setBounds(250, 220, 100, 25);
        add(cbBadCover);

        JLabel lblAntarJemput = new JLabel("Antar Jemput :");
        lblAntarJemput.setBounds(20, 260, 100, 25);
        add(lblAntarJemput);
        rbYa = new JRadioButton("Ya");
        rbYa.setBounds(150, 260, 50, 25);
        add(rbYa);
        rbTidak = new JRadioButton("Tidak");
        rbTidak.setBounds(210, 260, 60, 25);
        add(rbTidak);

        antarJemputGroup = new ButtonGroup();
        antarJemputGroup.add(rbYa);
        antarJemputGroup.add(rbTidak);

        JLabel lblTotalBayar = new JLabel("Total Bayar :");
        lblTotalBayar.setBounds(20, 300, 100, 25);
        add(lblTotalBayar);
        txtTotalBayar = new JTextField();
        txtTotalBayar.setBounds(150, 300, 200, 25);
        add(txtTotalBayar);

        JLabel lblOutput = new JLabel("Hasil Output");
        lblOutput.setBounds(380, 20, 100, 25);
        add(lblOutput);
        hasilOutput = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(hasilOutput);
        scrollPane.setBounds(380, 50, 180, 200);
        hasilOutput.setEditable(false);
        add(scrollPane);

        JButton btnBersih = new JButton("Bersih");
        btnBersih.setBounds(100, 340, 80, 25);
        add(btnBersih);

        JButton btnKeluar = new JButton("Keluar");
        btnKeluar.setBounds(200, 340, 80, 25);
        add(btnKeluar);

        JButton btnTampil = new JButton("Tampil");
        btnTampil.setBounds(300, 340, 80, 25);
        add(btnTampil);
    }

    public static void main(String[] args) {
        AplikasiLaundryTampilan frame = new AplikasiLaundryTampilan();
        frame.setVisible(true);
    }
}
