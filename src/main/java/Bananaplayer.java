package main.java;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Bananaplayer {
    String sound;
    public Bananaplayer(String sound) {
        this.sound = sound;
    }
    public void playSound () {
        Media media = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
