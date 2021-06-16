/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almost;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class gamemenu  extends JFrame{
    AudioInputStream Audio;
    public static Clip clip;
    public gamemenu(){
        
            this.setVisible(true);
            this.setSize(800,600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setTitle("Plane Vs UFOS");
            addpanel();
    }
    private void addpanel(){
    winplanepree w=new winplanepree(this);
    this.add(w);
    }
        

  public static void main(String[] a){
    new gamemenu();
    

    }
}
