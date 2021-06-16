/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almost;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ArNoB
 */
public class winplanepree extends JPanel implements ActionListener,KeyListener{
   JButton start_button,quit_button,level;
   JFrame Frame;
   Font font;
   Timer t;
   ImageIcon ufo;
   int round=0,size=48,x=470,ufox=500;
   public static int ticks=0;
   public winplanepree(JFrame f){
   this.Frame=f;
  
   setLayout(null);
   setButtons();
   t=new Timer(100,this);
   t.start();
   }
   private void setButtons(){
    start_button=new JButton("Play");
    quit_button=new JButton("Quit");
    setbutton(start_button,250,"Play");
    setbutton(quit_button,350,"Quit");
    start_button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {swich();}});
    quit_button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {System.exit(0);}});
    start_button.addKeyListener(this);
    
   }
   private void setbutton(JButton start_button,int x,String s){
    font=new Font("Serif", Font.BOLD,56);
    start_button.setFont(font);
    start_button.setBackground(Color.LIGHT_GRAY);
    start_button.setForeground(Color.WHITE);
    start_button.setBounds(320,x,160,80);
    start_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    start_button.setFocusable(true);
    
    
   }
   private void swich(){
        try{gamemenu.clip.stop();}catch(Exception e){}
        Frame.dispose();
        try { Thread.sleep(300);} catch (InterruptedException ex) {}
        new game();
       }
   public void paint(Graphics g){
      drawBackGround(g);
      if(ticks==100)
      {
       write(g);
       t.stop();
      this.Frame.add(start_button);
      this.Frame.add(quit_button);
      quit_button.setFocusable(true); 
      quit_button.requestFocus(true);  
      start_button.setFocusable(true); 
      start_button.requestFocus(true);  
      }
      else{
        prewrite(g);
      }
    }
   private void drawBackGround(Graphics g){
     ImageIcon img=new ImageIcon(PATH.path+"sky.jpg");
     img.paintIcon(this, g, 0, 0);
     g.setColor(Color.gray);
     g.drawRect(0, 0, 800, 600);
     
    }
    
   private void write(Graphics g){
       g.setColor(Color.white);
       font = new Font("Comic Sans MS", Font.BOLD,56);
       g.setFont( font );
       g.drawString("Click Play Button To Start!", 32, 120);
       font = new Font("Comic Sans MS", Font.BOLD,16);
       g.setFont( font );
       g.drawString("This is project is mad by Shafaet, Saiful and Fuad!", 32, 160);
    }
     private void prewrite(Graphics g){
        ufo=new ImageIcon(PATH.path+"ufopost.png");
        g.setColor(Color.white);
       font = new Font("Comic Sans MS", Font.BOLD,56);
       g.setFont( font );
       g.drawString("UFOS", 152, 120);
       g.drawString("  &", 152, 170);
       g.drawString("PLANE", 152, 220);
       if(ticks%10==0) round++;
       g.setColor(Color.black);
       if(round%2==0)
       {font = new Font("Comic Sans MS", Font.BOLD,size--);ufox+=4;}
       else
        {font = new Font("Comic Sans MS", Font.BOLD,size++);ufox-=4;}
       g.setFont( font );
       if(ticks%10<3)
       g.drawString("Loading.", x, 520);
       else if(ticks%10<7)
       g.drawString("Loading..", x, 520);
       else
       g.drawString("Loading...", x, 520);
       ufo.paintIcon(this, g, ufox, 200);
         }
  
   
       @Override
    public void actionPerformed(ActionEvent ae) {
     repaint();
     ticks++;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyChar()==KeyEvent.VK_ENTER) swich();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
