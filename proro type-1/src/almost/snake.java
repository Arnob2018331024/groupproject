package almost;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class snake extends JPanel implements KeyListener,ActionListener{
   ImageIcon img,hr,hu,hd,hl,b,e;
   int x[]=new int[750];
   int y[]=new int[750];
   int length=3;
   Timer t;
   boolean l=false;
   boolean r=false;
   boolean u=false;
   boolean d=false;
   int a;
    public snake(){
        this.setFocusable(true);
       this.setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
       
        //this.setBackground(Color.GRAY);
        //this.setBounds(0, 0, 1120, 600);
        x[0]=35+25;
        x[1]=10+25;
        x[2]=10;
        y[0]=70;
        y[1]=70;
        y[2]=70;
        t=new Timer(100,this);
        t.start();
    }
    public void paint(Graphics g){
        
        g.setColor(Color.white);
        g.drawRect(10,10,852, 52);
    img=new ImageIcon("build\\classes\\almost\\snaketitle.jpg");
    img.paintIcon(this, g, 11, 11);
    g.setColor(Color.white);
    g.drawRect(10, 65, 851,601 );
    g.setColor(Color.black);
    g.fillRect(11, 66, 850, 600);
    for(int a=0;a<length;a++)
    {
    if(a==0&&u){
    hu=new ImageIcon("build\\classes\\almost\\upmouth.png");
   
        hu.paintIcon(this, g, x[a], y[a]);
    }
    if(a==0&&d){
    hd=new ImageIcon("build\\classes\\almost\\downmouth.png");
    
        hd.paintIcon(this, g, x[a], y[a]);
    }
    if(a==0&&l){
    hl=new ImageIcon("build\\classes\\almost\\leftmouth.png");
    
        hl.paintIcon(this, g, x[a], y[a]);
    }
    if(a==0&&r){
    hr=new ImageIcon("build\\classes\\almost\\rightmouth.png");
    
        hr.paintIcon(this, g, x[a], y[a]);
    }
    if(a!=0){
    b=new ImageIcon("build\\classes\\almost\\snakeimage.png");
    
        b.paintIcon(this, g, x[a], y[a]);
    }
    
    }
    g.dispose();
    }

    public void actionPerformed(ActionEvent ae) {
        t.start();
        if(r==true)
          {   for(a=length-1;a>=1;a--)
              {   
                  x[a]=x[a-1];
                  y[a]=y[a-1];
              }
               x[0]+=25;
              if(x[0]>860-25)
                  x[0]=10;
             
          }
        if(d==true)
          {   for(a=length-1;a>=1;a--)
              {   
                  x[a]=x[a-1];
                  y[a]=y[a-1];
              }
              y[0]=y[0]+25;
              if(y[0]>666)
                  y[0]=66;
             
          }
        if(l==true)
          {   for(a=length-1;a>=1;a--)
              {   
                  x[a]=x[a-1];
                  y[a]=y[a-1];
              }
              x[0]=x[0]-25;
              if(x[0]<0)
                  x[0]=666;
             
          }
        if(u==true)
          {   for(a=length-1;a>=1;a--)
              {   
                  x[a]=x[a-1];
                  y[a]=y[a-1];
              }
              y[0]=y[0]-25;
              if(y[0]<0)
                  y[0]=666;
             
          }
       
          repaint();
    }
    public void keyTyped(KeyEvent ke) {
       
      }

    public void keyPressed(KeyEvent ke) {
      if(ke.getKeyCode()==KeyEvent.VK_DOWN)
       {
           
               l=false;
               u=false;
               d=true;
               r=false;
           
       }
        if(ke.getKeyCode()==KeyEvent.VK_UP)
       {
          
               l=false;
               u=true;
               d=false;
               r=false;
           
       }
         if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
       {
          
               l=false;
               r=true;
               d=false;
               u=false;
           
       }
          if(ke.getKeyCode()==KeyEvent.VK_LEFT)
       {
          
               u=false;
               l=true;
               d=false;
               r=false;
           
       }
          
        //x[2]=100;
        repaint();
      System.out.println("key pressed");
    }

    public void keyReleased(KeyEvent ke) {
       
    }

   
  

    
   
    
}
