/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almost;

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
