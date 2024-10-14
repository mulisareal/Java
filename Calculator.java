import javax.swing.*;
import java.awt.*;

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
        setVisible(true);
    }
    public static void main(String[] args){
        Calculator ZZ=new Calculator();
        ZZ.objek();
    }
}
