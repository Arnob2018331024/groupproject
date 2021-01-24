import java.awt.Color;
import javax.swing.JFrame;

public class snakegame extends JFrame{
     snakegame(){
     this.setVisible(true);
     this.setTitle("Snake Game");
     this.setResizable(false);
     this.setBounds(100, 40, 882, 720);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setBackground(Color.GRAY );
     snake  g=new snake();
     this.add(g);
     }
    public static void main(String[] args) {
       snakegame snak=new snakegame();
	   //snake  g=new snake();
      // game g=new game();
       //snak.add(g);
    }
    
}
