
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class start extends JFrame implements ActionListener{
    Container c;
    Font f;
    ImageIcon i=new ImageIcon("home page.png");
    JLabel l;
    JButton b;
    start(){
        f=new Font("Serif", Font.BOLD,50);
    b=new JButton("Start");
    b.setBackground(Color.white);
    b.setForeground(Color.black);
    b.setBounds(190,350,200,80);
    setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(100,50,615,650);
    this.setTitle("JavaGammeProject");
    c=this.getContentPane();
    c.setLayout(null);
   
    l=new JLabel(i);
    l.setBounds(0, 0,600, 600);
    b.setFont(f);
    c.add(b);
    c.add(l);
    b.addActionListener(this);
    }
    public static void main(String[] args) {
        new start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         new secondmenu();
        this.dispose();
       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
