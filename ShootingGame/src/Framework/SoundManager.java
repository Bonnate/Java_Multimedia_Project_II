package Framework;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {
	// Singleton - pattern
	private static SoundManager Instance = null;

	public static SoundManager Instance() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (Instance == null) {
			Instance = new SoundManager();
		}

		return Instance;
	};

	public void PlayClip(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		}

		catch (Exception ex) {
		}
	}
}
