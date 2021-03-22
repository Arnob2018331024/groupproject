package almost;




import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ArNoB
 */
public class game extends JFrame {
    public game(){
    this.setVisible(true);
    this.setSize(800,600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("Plane Vs UFOS");
    
     addpanel();
       //this.setFocusable(false);
      
     // this.pack();
    }
    private void addpanel(){
    winplane w=new winplane(this);
    this.add(w);
    }
    public static void main(String[] args) {
      game g=new game();    
      
    }

  
}
