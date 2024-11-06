import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

public class Calculator extends JFrame{
    TextField layar = new TextField();
    Button satu = new Button("1");
    Button dua = new Button("2");
    Button tiga = new Button("3");
    Button plus = new Button("+");
    Button empat = new Button("4");
    Button lima = new Button("5");
    Button enam = new Button("6");
    Button minus = new Button("-");
    Button tujuh = new Button("7");
    Button delapan = new Button("8");
    Button sembilan = new Button("9");
    Button kali = new Button("*");
    Button nol = new Button("0");
    Button ce = new Button("c");
    Button hasil = new Button("=");
    Button bagi = new Button("/");
    Calculator(){
        setTitle("Calculator");
        setLocation(200,100);
        setSize(400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void objek(){
        getContentPane().setLayout(null);
        getContentPane().add(layar);
        getContentPane().add(satu);
        getContentPane().add(dua);
        getContentPane().add(tiga);
        getContentPane().add(plus);
        getContentPane().add(empat);
        getContentPane().add(lima);
        getContentPane().add(enam);
        getContentPane().add(minus);
        getContentPane().add(tujuh);
        getContentPane().add(delapan);
        getContentPane().add(sembilan);
        getContentPane().add(kali);
        getContentPane().add(nol);
        getContentPane().add(ce);
        getContentPane().add(hasil);
        getContentPane().add(bagi);
        
        layar.setBounds(10,5,230,40);
        satu.setBounds(10,50,50,35);
        dua.setBounds(70,50,50,35);
        tiga.setBounds(130,50,50,35);
        plus.setBounds(190,50,50,35);
        empat.setBounds(10,95,50,35);
        lima.setBounds(70,95,50,35);
        enam.setBounds(130,95,50,35);
        minus.setBounds(190,95,50,35);
        tujuh.setBounds(10,140,50,35);
        delapan.setBounds(70,140,50,35);
        sembilan.setBounds(130,140,50,35);
        kali.setBounds(190,140,50,35);
        nol.setBounds(10,185,50,35);
        ce.setBounds(70,185,50,35);
        hasil.setBounds(130,185,50,35);
        bagi.setBounds(190,185,50,35);
        nol.setBackground(Color.decode("#FFF6B7"));
        satu.setBackground(Color.decode("#FFF6B7"));
        dua.setBackground(Color.decode("#FFF6B7"));
        tiga.setBackground(Color.decode("#FFF6B7"));
        empat.setBackground(Color.decode("#FFF6B7"));
        lima.setBackground(Color.decode("#FFF6B7"));
        enam.setBackground(Color.decode("#FFF6B7"));
        tujuh.setBackground(Color.decode("#FFF6B7"));
        delapan.setBackground(Color.decode("#FFF6B7"));
        sembilan.setBackground(Color.decode("#FFF6B7"));
        ce.setBackground(Color.decode("#B7BCFF"));
        hasil.setBackground(Color.decode("#B7E9FF"));
        plus.setBackground(Color.decode("#FFB7E3"));
        minus.setBackground(Color.decode("#FFB7E3"));
        kali.setBackground(Color.decode("#FFB7E3"));
        bagi.setBackground(Color.decode("#FFB7E3"));
        setVisible(true);
    }

    void event() {
        satu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "1");
            }
        });
        dua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "2");
                }
        });
        tiga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "3");
                }
        });
        empat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "4");
                }
        });
        lima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "5");
                }
        });
        enam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "6");
                }
        });
        tujuh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "7");
                }
        });
        delapan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "8");
                }
        });
        sembilan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "9");
                }
        });
        nol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(layar.getText() + "0");
                }
        });

        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (layar.getText().contains("-") || layar.getText().contains("/") || layar.getText().contains("*")) {
                    layar.setText((layar.getText().substring(0, layar.getText().length() - 1)) + "+");
                } else {
                    layar.setText(layar.getText() + "+");
                }
            }
        });
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (layar.getText().contains("+") || layar.getText().contains("/") || layar.getText().contains("*")) {
                    layar.setText((layar.getText().substring(0, layar.getText().length() - 1)) + "-");
                } else {
                    layar.setText(layar.getText() + "-");
                }
            }
        });
        kali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (layar.getText().contains("-") || layar.getText().contains("/") || layar.getText().contains("+")) {
                    layar.setText((layar.getText().substring(0, layar.getText().length() - 1)) + "");
                } else {
                    layar.setText(layar.getText() + "*");
                }
            }
        });
        bagi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (layar.getText().contains("-") || layar.getText().contains("+") || layar.getText().contains("*")) {
                    layar.setText((layar.getText().substring(0, layar.getText().length() - 1)) + "/");
                } else {
                    layar.setText(layar.getText() + "/");
                }
            }
        });
        ce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layar.setText(" ");
                }
        });
        hasil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String text = layar.getText();
                int a = 0;
                int b = 0;
                if (text.contains("+")) {
                    StringTokenizer st = new StringTokenizer(text, "+");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else if (text.contains("-")) {
                    StringTokenizer st = new StringTokenizer(text, "-");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else if (text.contains("*")) {
                    StringTokenizer st = new StringTokenizer(text, "*");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else if (text.contains("/")) {
                    StringTokenizer st = new StringTokenizer(text, "/");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else {
                    layar.setText("Invaid operator");
                }
                long hasil = 0;
                double hasil_double = 0;

                if (layar.getText().contains("+")) {
                    hasil = a + b;
                    layar.setText(String.valueOf(hasil));
                } else if (layar.getText().contains("-")) {
                    hasil = a - b;
                    layar.setText(String.valueOf(hasil));
                } else if (layar.getText().contains("*")) {
                    hasil = a * b;
                    layar.setText(String.valueOf(hasil));
                } else if (layar.getText().contains("/")) {
                    if (b == 0) {
                        layar.setText("Error: Division by 0");
                    } else {
                    hasil_double = (double) a / (double) b;
                    layar.setText(String.valueOf(hasil_double));
                    }
                } else {
                    layar.setText("Invalid input!");
                }

                
            }
        });

        // while (true) {
        //     System.out.println(layar.getText());
        //  }
    }

    void object() {
    }
    public static void main(String[] args){
        Calculator ZZ=new Calculator();
        ZZ.objek();
        ZZ.event();
    }
}
