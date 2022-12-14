import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundHandler {

    public static void RunMusic (String path, float volume){
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            clip.loop(0);
        }catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (LineUnavailableException e){

        }
    }

    public static void RunMusic (String path, float volume, boolean isBackground){
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (LineUnavailableException e){

        }
    }

}