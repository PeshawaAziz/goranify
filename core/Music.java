package core;

import java.util.ArrayList;

public class Music {
    private static ArrayList<Music> allMusics = new ArrayList<>();

    private String title;
    private User singer;
    private int numberOfStreams = 0;

    public Music(String title, User singer) throws IllegalArgumentException {
        setTitle(title);
        setSinger(singer);

        allMusics.add(this);
    }

    public void play() {
        System.out.println("Playing " + title + " by " + singer.getUsername());
        numberOfStreams++;
    }

    public ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(music);
            }
        }

        return result;
    }

    public ArrayList<Music> search(String title, String singerName) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.getTitle().toLowerCase().contains(title.toLowerCase()) &&
                    music.getSinger().getUsername().toLowerCase().contains(singerName.toLowerCase())) {
                result.add(music);
            }
        }

        return result;
    }

    public String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Music title cannot be null or empty.");
        }

        this.title = title;
    }

    public User getSinger() {
        return singer;
    }

    public final void setSinger(User singer) {
        if (singer == null) {
            throw new IllegalArgumentException("Singer cannot be null.");
        }

        this.singer = singer;
    }

    public int getNumberOfStreams() {
        return numberOfStreams;
    }

    public void setNumberOfStreams(int numberOfStreams) {
        if (numberOfStreams < 0) {
            throw new IllegalArgumentException("Number of streams cannot be negative.");
        }

        this.numberOfStreams = numberOfStreams;
    }
}