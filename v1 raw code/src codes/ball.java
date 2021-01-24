
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import org.w3c.dom.css.Rect;

/**
 *
 * @author ArNoB
 */
public class ball extends Thread {
   public int x=200,y=300,w=25,h=25;
   int xdir=1;
   int ydir=1;
   
    public ball( )
    {// this.start();
    }
    public void run(){
    for(int i=1;;i++)
    {move();
    try{
    sleep(4);
    }catch(Exception e){}
    }
    }
   public void move()
    {Rectangle r=new Rectangle(x,y,w,h);
    if(x<0)
    {
    xdir=1;
    }
    if(x>=575)
    {
        xdir=-1;
    }
    if(y==0)
    {
    ydir=1;
    }
    if(y>=575||(canvas.p.y<=y+h&&canvas.p.x<=x+w&&canvas.p.x+canvas.p.w>=x))
    {
        ydir=-1;
    }
    for(int i=0;i<30;i++)
    {
      if(canvas.brick.exist[i]==1)
      {
      
      if((canvas.brick.y[i]+30==y)&&r.intersects(new Rectangle(canvas.brick.x[i]-1,canvas.brick.y[i]-1,52,32)))
      {ydir=1;canvas.brick.exist[i]=0;}   
      else if((canvas.brick.y[i]==y+25)&&r.intersects(new Rectangle(canvas.brick.x[i]-1,canvas.brick.y[i]-1,52,32)))
      {ydir=-1;canvas.brick.exist[i]=0;}
      else if((canvas.brick.x[i]==x+25)&&r.intersects(new Rectangle(canvas.brick.x[i]-1,canvas.brick.y[i]-1,52,32)))
      {xdir=-1;canvas.brick.exist[i]=0;}
      else if((canvas.brick.x[i]+50==x)&&r.intersects(new Rectangle(canvas.brick.x[i]-1,canvas.brick.y[i]-1,52,32)))
              { xdir=1;canvas.brick.exist[i]=0;}
          
      }
      //break;
    }
    if(xdir==1)
    {
        x++;
    }
    if(xdir==-1)
    {
        x--;
    }
    if(ydir==-1)
    {
        y--;
    }
    if(ydir==1)
    {
        y++;
    }   
    if(y==550+25)
    { JOptionPane.showMessageDialog(null,"Valar Morgulis");
      System.exit(0);}
    
    //gg.fillOval(x,y,w,h);
    }
    
}
