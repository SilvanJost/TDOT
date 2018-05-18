package client.assets;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundLoader {


	public Clip loadSound(String path){
		
		Clip sound  = null;
		try
	    {
	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(path));
	        sound = AudioSystem.getClip();
	        sound.open(audioIn);
	        }
		catch( Exception e )
	    {
	        e.printStackTrace();
	    }
		return sound;
	}
}
