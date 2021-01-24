package almost;



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
public class win {
   public win(){
       JFrame f=new JFrame();
   f.setVisible(true);
   
   f.setLocation(100,50);
   f.setTitle("Brick Game");
   f.setSize(610,640);
   //f.setResizable(false);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   canvas c=new canvas();
   
   f.add(c);
  // this.setFocusable(false );
   }
    public static void main(String[] args) {
        new win();
    }
    
}
