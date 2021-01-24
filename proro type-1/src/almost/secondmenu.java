package almost;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public class secondmenu extends JFrame {
    Container c;
    JButton snake,plane,brick;
     Font f;
    // ImageIcon i=new ImageIcon("C:\\Users\\Admin\\Desktop\\starting menu\\project v-1\\src\\dk.jpg");;
    public secondmenu(){
    setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(100,50,600,600);
    this.setTitle("Select_Game");
    c=this.getContentPane();
    c.setLayout(new GridLayout());
     c.setBackground(Color.BLUE);
        f=new Font("Serif", Font.BOLD,19);
    
  
    snake=new JButton("Snake Game");
    brick=new JButton("Brick Game");
    plane=new JButton("Plane Game");
    snake.setFont(f);
    plane.setFont(f);
    brick.setFont(f);
    //snake.setBounds(10,10,160,160);
    snake.setForeground(Color.BLACK);
    snake.setBackground(Color.PINK);
    snake.setOpaque(true);
    c.add(snake);
    //brick.setBounds(180160,160);
    brick.setForeground(Color.BLACK);
    brick.setBackground(Color.CYAN);
    brick.setOpaque(true);
   c.add(brick);
   // plane.setBounds(380,10,160,160);
    plane.setForeground(Color.BLACK);
    plane.setBackground(Color.WHITE);
    plane.setOpaque(true);
   c.add(plane);
   snake.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          new snakegame();
          dispose();
        }
    });
   plane.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          new game();
          dispose();
        }
    });
   brick.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          new win();
          dispose();
        }
    });
    }
     public static void main(String[] args) {
        new secondmenu();
    }

   
    
}
