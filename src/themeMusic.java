


/*
 * Silas, Risto, Ryan X
 * January 27 2022
 * final summitive

 * Class plays classic theme music while user plays game
 */
//nessesary imports
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
/**
 *
 * @author Risto, Ryan and Silas
 */
public class themeMusic {



    void playMusic(String musicLocation){//play music method takes in parameter for music location 

            try{
                File musicPath = new File(musicLocation);//Instantiates new music path 
                if(musicPath.exists()){//if the music path exists then run
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);//gets music path from music path provided
                    Clip clip = AudioSystem.getClip();//gets the wav file
                    clip.open(audioInput);//opens audio input
                    clip.start();//starts the wav file
                    clip.loop(Clip.LOOP_CONTINUOUSLY);//loops wav file continuously until application is stopped

                }else{//if music path does not exist 
                    System.out.println("cannot find the file");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

}    

