import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TugasPendahuluan extends JFrame{
        Label nama = new Label ("Masukkan Angka Pertama: ");
        TextField nama2 = new TextField();
        Label operator = new Label ("Operator ");
        TextField operator2 = new TextField();
        Label nama3 = new Label ("Masukkan Angka Kedua: ");
        TextField nama4 = new TextField();
        Label nama5 = new Label ("Hasil perhitungan ");
        TextField nama6 = new TextField();
        Button nama7 = new Button("+");
        Button nama8 = new Button("-");
        Button nama9 = new Button("/");
        Button nama10 = new Button("*");
        Button nama11 = new Button("=");
        TugasPendahuluan(){
            super("DESIGN FORM");
            setLocation(200,100);
            setSize(400,350);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        void objek(){
            getContentPane().setLayout(null);
            getContentPane().add(nama);
            getContentPane().add(nama2);
            getContentPane().add(nama3);
            getContentPane().add(nama4);
            getContentPane().add(nama5);
            getContentPane().add(nama6);
            getContentPane().add(nama7);
            getContentPane().add(nama8);
            getContentPane().add(nama9);
            getContentPane().add(nama10);
            getContentPane().add(nama11);
            getContentPane().add(operator);
            getContentPane().add(operator2);
            nama.setBounds(30,10,150,20);
            nama2.setBounds(40,40,120,20);
            operator.setBounds(30,70,150,20);
            operator2.setBounds(40,100,120,20);
            nama3.setBounds(30,130,150,20);
            nama4.setBounds(40,160,120,20);
            nama5.setBounds(30,190,150,20);
            nama6.setBounds(40,220,120,20);
            nama7.setBounds(30,240,40,20);
            nama8.setBounds(75,240,40,20);
            nama9.setBounds(120,240,40,20);
            nama10.setBounds(75,260,40,20);
            nama11.setBounds(30,260,40,20);
            
            setVisible(true);
        }
        
        void EventListener(){
            nama7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    operator2.setText("+");
                }
            });
            nama8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    operator2.setText("-");
                }
            });
            nama9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    operator2.setText("/");
                }
            });
            nama10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    operator2.setText("*");
                }
            });
            nama11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent press){
                   int a = Integer.parseInt(nama2.getText());
                   int b = Integer.parseInt(nama4.getText());
                   String op = operator2.getText(); 
                   int result = 0;
                   double result_float = 0;

                   switch (op){
                    case "+":
                        result = a+b;
                        nama6.setText(String.valueOf(result));
                        break;

                    case "-":
                        result = a-b;
                        nama6.setText(String.valueOf(result));
                        break;

                    case "/":
                        if (b==0){
                            nama6.setText("Error : Division by zero");
                            break;
                        }
                        double x = Double.valueOf(a);
                        double y = Double.valueOf(b);
                        result_float = x / y;
                        nama6.setText(String.valueOf(result_float));
                        break;

                    case "*":
                        result = a * b;
                        nama6.setText(String.valueOf(result));
                        break;

                    default:
                        nama6.setText("Error : Invalid Operator");
                        break;
                   }
                }
            });
    
        }
        
        public static void main (String[] args){
            TugasPendahuluan ZZ = new TugasPendahuluan();
            ZZ.objek();
            ZZ.EventListener();
    }
}
