


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
    this.setSize(820,610);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Plane Game/Main Game");
     winplane w=new winplane();
      this.add(w);
       //this.setFocusable(false);
      
     // this.pack();
    }
    public static void main(String[] args) {
      game g=new game();    
      
    }

  
}
