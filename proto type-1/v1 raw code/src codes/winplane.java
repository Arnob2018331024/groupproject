
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class winplane extends JPanel implements ActionListener, KeyListener{
    Timer t;
    ImageIcon i1;
    ImageIcon i2[]=new ImageIcon[10];
    long point=0;
    
    boolean left,right,up,down,flag,esc,playing;
    int ne=1;
    int ex[]=new int[10];
    int ey[]=new int[10];
    int x=400, y=250;
    int ticks=0;
    Random r=new Random();
    public winplane(){
       this.setFocusable(true);
   this.setFocusTraversalKeysEnabled(false);
    this.addKeyListener(this);
    t=new Timer(100,this);
    t.start();
      ex[0]=700;
      ey[0]=50;
      this.requestFocus();
    }
    
    
    public void paint(Graphics g){
      g.setColor(Color.white);
    g.fillRect(0, 0, 800, 600);
    g.setColor(Color.gray);
    g.drawRect(0, 0, 800, 600);
    //i1=new ImageIcon("O:\\study\\codes\\java\\New folder\\swing anisul islam\\pro-test-1\\src\\textures\\enemy.png");
   i2[0]=new ImageIcon("snakeimage.png");
   //i2[1]=new ImageIcon("O:\\study\\codes\\java\\New folder\\swing anisul islam\\pro-test-1\\src\\textures\\snakeimage.png");
   //i2[2]=new ImageIcon("O:\\study\\codes\\java\\New folder\\swing anisul islam\\pro-test-1\\src\\textures\\snakeimage.png");
   //i2[3]=new ImageIcon("O:\\study\\codes\\java\\New folder\\swing anisul islam\\pro-test-1\\src\\textures\\snakeimage.png");
   //i2[4]=new ImageIcon("O:\\study\\codes\\java\\New folder\\swing anisul islam\\pro-test-1\\src\\textures\\snakeimage.png");
   if(up)
       i1=new ImageIcon("pu.png");
   else if(down)
       i1=new ImageIcon("pd.png");
   else if(right)
       i1=new ImageIcon("pr.png");
    else 
            i1=new ImageIcon("pl.png");
   //if(up) 
   i1.paintIcon(this, g, x, y);
    for(int a=0;a<ne;a++)
    i2[0].paintIcon(this, g, ex[a], ey[a]);
    
    g.dispose();
    }
    public void run(){
    }
    public static void main(String[] args) {
   
}
      @Override
    public void actionPerformed(ActionEvent ae) {
        //System.out.println("Oishi...oishi...oishi");
        if(esc)
        {
               JOptionPane.showMessageDialog(null,"Game has been Paused press ok to continue");
         esc=false;
        }
        if(down)
            y=(y+50)%575;   
        if(up)
        {
        y-=50;
        if(y<0)
            y=550;
        }
        
        if(right)
        {x=(x+50)%800;}
            
           
            if(left)
              {x-=50;
                if(x<0)
                x=775;
                 }
        if(playing)
        {  for(int a=0;a<ne;a++)
        {
            if(x>ex[a])
                ex[a]+=25;
            if(x<ex[a])
                ex[a]-=25;
            if(y>ey[a])
                ey[a]+=25;
            if(y<ey[a])
                    ey[a]-=25;
            if(x==ex[a]&&y==ey[a])
                flag=true;
                    
        }
                repaint();
                if(flag)
                    
                {
                  
                    JOptionPane.showMessageDialog(null,"Game over\nScore: "+point);
                    System.exit(0);
                  flag=false;
                }
                ticks++;
                if(ticks==20)
                {ticks=0;
                if(ne==10)
                { ne-=4;
                
                }
                else{
                    ne++;
                    ex[ne-1]=(25*r.nextInt(800))%800;
                    ey[ne-1]=(25*r.nextInt(600))%600;
                
                }
                }
                point++;}
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if(ke.getExtendedKeyCode()==KeyEvent.VK_DOWN)
        {
           left=false;
            right=false;
            up=false;
            down=true;
        playing=true;
        }
        if(ke.getExtendedKeyCode()==KeyEvent.VK_UP)
        {
            left=false;
           right=false;
            up=true;
            down=false;
        playing=true;
        }
            if(ke.getExtendedKeyCode()==KeyEvent.VK_LEFT)
            {
             left=true;
            right=false;
            up=false;
            down=false;
           playing=true;
            }
        if(ke.getExtendedKeyCode()==KeyEvent.VK_RIGHT)
        {
         left=false;
            right=true;
           up=false;
            down=false;
        playing=true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
             {  esc=true;
             playing=true;
             
             }
        if(ke.getKeyCode()==KeyEvent.VK_BACK_SPACE){new secondmenu();}
            
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
