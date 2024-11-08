import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Event_Button_Key extends JFrame{
    JButton m = new JButton ("TEKAN KEY 1, 2, 3, 4");
    JLabel tulisan = new JLabel ("URUTAN FRAME AKAN BERUBAH");
    Event_Button_Key(){
        setTitle("INI EVENT PADA BUTTON");
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void komponen(){
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(m);
        getContentPane().add(tulisan);
        setVisible(true);
    }
    void reaksi(){
        m.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == e.VK_1){
                    setSize(300, 500);
                }
                if (e.getKeyCode() == e.VK_2){
                    setSize(200, 100);
                }
                if (e.getKeyCode() == e.VK_3){
                    setSize(100, 10);
                }
            }
        });
    }
    public static void main (String[] args){
        Event_Button_Key eb = new Event_Button_Key();
        eb.komponen();
        eb.reaksi();
    }
}
