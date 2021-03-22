import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.DataLine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
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
        try {
            playAudio();
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(gamemenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(gamemenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(gamemenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void addpanel(){
    winplanepree w=new winplanepree(this);
    this.add(w);
    }
    private void playAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       	 
	try {
		AudioInputStream audioInputStream;
		File file = new File(PATH.path+"d.wav");
		audioInputStream = AudioSystem.getAudioInputStream(file);
		Clip line;
		line = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
		line.open(audioInputStream);
		line.start();
		line.drain();
		audioInputStream.close();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
		
	Toolkit.getDefaultToolkit().beep();
    }

        

  public static void main(String[] a){
    new gamemenu();
    

    }
}

class game extends JFrame {
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

class winplane extends JPanel implements ActionListener, KeyListener{
    private JFrame FREAME;
    private Timer TIMER;
    private ImageIcon PLANE_IMAGE,joptionpane_img;
    private ImageIcon UFO_IMAGE[]=new ImageIcon[10];
    private long SCORE=0,hScore;
    private AudioStream key,blast;
    private Font FONT;
    private boolean left,right,up,down,flag,esc,playing,press;
    int PRESS_TIME=0, NUMBER_OF_ENEMY=1;
    int UFO_X_AXIS[]=new int[1000];
    int UFO_Y_AXIS[]=new int[1000];
    int x=400, y=250;
    int ticks=0;
    Random r=new Random();
    
    public winplane(JFrame Frame){
      UFO_X_AXIS[0]=(25*r.nextInt(800))%700;
      UFO_Y_AXIS[0]=(25*r.nextInt(800))%700;
      init(Frame);
    }
  private void init(JFrame Frame){
    this.setFocusable(true);
    this.setFocusTraversalKeysEnabled(false);
    this.addKeyListener(this);
    this.requestFocus(); 
    startTimer();
    audioInit();
    this.FREAME=Frame;
    hScore=gethScore();
    joptionpane_img=new ImageIcon(PATH.path+"ufopost.png");
  }
  private void startTimer(){
      TIMER=new Timer(100,this);
      TIMER.start();
    
  } 
  @Override
  public void paint(Graphics g){
     drawBackGround(g);
      if(press) 
         drawIfPressed(g);
      else      
         drawNotPressed(g);
      g.dispose();
        
  }
    private void drawBackGround(Graphics g){
     ImageIcon img=new ImageIcon(PATH.path+"sky.jpg");
     img.paintIcon(this, g, 0, 0);
     g.setColor(Color.gray);
     g.drawRect(0, 0, 800, 600);
     
    }
    private void drawIfPressed(Graphics g){
     FONT = new Font("Comic Sans MS", Font.BOLD,32);
     g.setFont(FONT);
     g.drawString("Score: "+SCORE, 32, 32);
     FONT = new Font("Comic Sans MS", Font.BOLD,24);
     g.setFont(FONT);
     g.drawString("Best Score: "+Math.max(hScore,SCORE), 580, 28);
     loadIcons();
     paintIcons(g);
    
    }
    private void drawNotPressed(Graphics g){
        FONT = new Font("Comic Sans MS", Font.BOLD,32);
        g.setFont( FONT );
        g.drawString("Use up, down, right or left key to control.", 32, 200);
        FONT = new Font("Comic Sans MS", Font.BOLD,16);
        g.setFont( FONT );
        g.drawString("Press any of them to begin!", 32, 240);
     }
    private void loadIcons(){
    UFO_IMAGE[0]=new ImageIcon(PATH.path+"ufo.png");
    if(up)
       PLANE_IMAGE=new ImageIcon(PATH.path+"pu.png");
    else if(down)
       PLANE_IMAGE=new ImageIcon(PATH.path+"pd.png");
    else if(right)
       PLANE_IMAGE=new ImageIcon(PATH.path+"pr.png");
    else 
        PLANE_IMAGE=new ImageIcon(PATH.path+"pl.png"); 
    if(flag)
        {
         PLANE_IMAGE=new ImageIcon(PATH.path+"explosion.png");
         UFO_IMAGE[0]=new ImageIcon(PATH.path+"explosion.png");
        }   
    }
    private void paintIcons(Graphics g){
    PLANE_IMAGE.paintIcon(this, g, x, y);
    for(int a=0;a<NUMBER_OF_ENEMY;a++)
    UFO_IMAGE[0].paintIcon(this, g, UFO_X_AXIS[a], UFO_Y_AXIS[a]);
    
    }
      @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(esc)
        {
            int response = JOptionPane.showConfirmDialog(this,"Do you want to resume?","Pause Menu:",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(PATH.path+"ufo.png"));
            if(response!=JOptionPane.YES_OPTION)Quit();
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
        {  for(int a=0;a<NUMBER_OF_ENEMY;a++)
        {
            if(x>UFO_X_AXIS[a])
                UFO_X_AXIS[a]+=25;
            if(x<UFO_X_AXIS[a])
                UFO_X_AXIS[a]-=25;
            if(y>UFO_Y_AXIS[a])
                UFO_Y_AXIS[a]+=25;
            if(y<UFO_Y_AXIS[a])
                    UFO_Y_AXIS[a]-=25;
            if(x==UFO_X_AXIS[a]&&y==UFO_Y_AXIS[a])
                flag=true;
                    
        }   
        if(flag)
        {  
            try {
                 repaint();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(winplane.class.getName()).log(Level.SEVERE, null, ex);
            }}
               
                repaint();
                if(flag)
                    
                {
                Quit();   
                }
                ticks++;
                if(ticks==21)
                {ticks=0;
                if(NUMBER_OF_ENEMY>10)
                { NUMBER_OF_ENEMY-=4;
                
                }
                else{
                      NUMBER_OF_ENEMY++;
                    UFO_X_AXIS[NUMBER_OF_ENEMY-1]=(25*r.nextInt(800))%700;
                    UFO_Y_AXIS[NUMBER_OF_ENEMY-1]=(25*r.nextInt(600))%700;
                }
                }
                if(press)
                SCORE++;}
         }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        press=true;
        playKeySound();
        if(ke.getExtendedKeyCode()==KeyEvent.VK_DOWN)
        {
            left=false;right=false;up=false;down=true;
            playing=true;
        }
        if(ke.getExtendedKeyCode()==KeyEvent.VK_UP)
        {
           left=false;right=false;up=true;down=false;
           playing=true;
        }
        if(ke.getExtendedKeyCode()==KeyEvent.VK_LEFT)
          {
             left=true;right=false;up=false;down=false;
            playing=true;
          }
        if(ke.getExtendedKeyCode()==KeyEvent.VK_RIGHT)
        {
        left=false;right=true;up=false;down=false;
        playing=true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
             { esc=true;
             playing=true;
             }
        //if(ke.getKeyCode()==KeyEvent.VK_BACK_SPACE){new secondmenu();}
        
        }
    private void audioInit(){
        try {
            InputStream io=new FileInputStream(PATH.path+"blast.wav");
            try {
                blast=new AudioStream(io);
            }catch (IOException ex) {}
        }catch (FileNotFoundException ex) {}
    }
    private void playKeySound(){
         try {
            InputStream io=new FileInputStream(PATH.path+"key.wav");
            try {key=new AudioStream(io);} 
            catch (IOException ex){}
            }
          catch (FileNotFoundException ex){}
           AudioPlayer.player.start(key);
    }
    private void playBlastSound(){AudioPlayer.player.start(blast);}
    private void stopKeySound(){AudioPlayer.player.start(key);}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
    private int gethScore(){
    BufferedReader b;
    try{
    b=new BufferedReader(new FileReader(PATH.path+"score.txt"));
    String score=b.readLine();
    b.close();
    return Integer.parseInt(score);
    }catch(Exception e){}
    finally{}
    return 0;
    }
    
    private void sethScore(long i){
    BufferedWriter b;
    try{
    b=new BufferedWriter(new FileWriter(PATH.path+"score.txt"));
    b.write(""+i);
    b.close();
    }catch(Exception e){}
    finally{}
    }
    private void Quit(){
     playBlastSound();
     if(SCORE>hScore)
     {JOptionPane.showMessageDialog(null,"!..New High Score..!\nGame over\nScore: "+SCORE,"New High Score!!",JOptionPane.INFORMATION_MESSAGE,joptionpane_img);
      sethScore(SCORE);
                    }
     else
         JOptionPane.showMessageDialog(null,"Score: "+SCORE,"Game over",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(PATH.path+"explosion.png"));
         winplanepree.ticks=100;
         FREAME.dispose();
         try {Thread.sleep(300);} catch (InterruptedException ex) {}
         new gamemenu();
         TIMER.stop();
         flag=false;
    }
    
}

class winplanepree extends JPanel implements ActionListener,KeyListener{
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
    start_button.setFocusable(true);
    start_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    start_button.setToolTipText(s);
    
    
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

class PATH {
    public static String path="";
}


