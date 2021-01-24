
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author ArNoB
 */
public class canvas extends JPanel  implements ActionListener,KeyListener {
    public static ball b=new ball();
    public static player p= new player();
    static public bricks brick =new bricks();
    Timer t;
    public int pp=0;
    public int x=1,y=1;
    public canvas()
    {
        addKeyListener(this);
   this.setFocusable(true);
   this.setFocusTraversalKeysEnabled(false);
    t=new Timer(5,this);
    t.start();

    }
    public void paint(Graphics g)
    {g.fillRect(0, 0, 600, 600);
        g.setColor(Color.blue);
    g.fillOval(b.x,b.y, b.w, b.h);
    g.fillRect(p.x,p.y, p.w, p.h);
    g.setColor(Color.green);
    for(int i=0;i<30;i++)
    {
    if(brick.exist[i]==1)
        g.fillRect(brick.x[i],brick.y[i],50,30);
    }
    g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       t.start();
       if(pp==1)
       b.move();
        repaint();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
          
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        pp=1;
if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            p.x+=50;
            if(p.x>500)
                p.x-=50;
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT)
        {
          p.x-=50;
            if(p.x<0)
                p.x+=50;
        }   
      
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
