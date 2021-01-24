package almost;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ArNoB
 */
public class sm extends JFrame {
    Container c;
    JLabel l,l1;
    JButton b;
    Font f;
    JPanel p;
    CardLayout cd;
    public sm(){
        cd=new CardLayout();
        f=new Font("Arial",Font.BOLD,24);
        p=new JPanel();
        p.setLayout(null);
     this.setVisible(true);
    this.setSize(800,600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("...title...");
    c=this.getContentPane();
    c.setLayout(cd);
    b=new JButton("start");
    b.setFont(f);
    b.setBackground(Color.CYAN);
    b.setForeground(Color.white);
    b.setBounds(350, 275, 100, 50);
    p.setBackground(Color.white);
    p.add(b);
    l=new JLabel("Java Game Project");
     l.setBackground(Color.CYAN);
     l.setOpaque(true);
     l.setForeground(Color.white);
     l.setBounds(0,0,800,100);
     l.setFont(f);
     l.setHorizontalAlignment(0);
     p.add(l);
      l1=new JLabel("BY Shafaet, Saiful & Fuad");
     l1.setBackground(Color.cyan);
     l1.setOpaque(true);
     l1.setForeground(Color.white);
     l1.setBounds(90,470,600,100);
     l1.setFont(f);
     l1.setHorizontalAlignment(0);
     p.add(l1);
     c.add(p);
     b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            dispose();
            new game();
            }
     });
     //b.setSelected(true);
      this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent ke) {
          if(ke.getKeyCode()==KeyEvent.VK_ENTER)
          { dispose();
            new game();}
              
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); 
    }
    public static void main(String[] args) {
        new sm();
    }
}
