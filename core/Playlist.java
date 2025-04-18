package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist;
    private User owner;

    public Playlist(String title, User owner) throws IllegalArgumentException {
        setTitle(title);
        setOwner(owner);
        this.playlist = new ArrayList<>();
    }

    public void editTitle(String title, String password) {
        if (owner.verifyPassword(password)) {
            setTitle(title);
            System.out.println("Playlist title edited successfully.");
        } else
            throw new InvalidOperationException("Wrong password. Music title cannot be edited.");
    }

    public void addMusic(Music music, String password) {
        if (music == null)
            throw new IllegalArgumentException("Music cannot be null.");

        if (playlist.contains(music))
            throw new InvalidOperationException("Music is already in the playlist.");

        if (owner.verifyPassword(password)) {
            playlist.add(music);
            System.out.println("Music added to the playlist successfully.");
        } else
            throw new IllegalArgumentException("Wrong password. Music cannot be added.");
    }

    public void removeMusic(String musicTitle, String password) {
        if (musicTitle == null || musicTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Music title cannot be null or empty.");
        }

        if (owner.verifyPassword(password)) {
            boolean removed = false;
            Iterator<Music> iterator = playlist.iterator();
            while (iterator.hasNext()) {
                Music music = iterator.next();
                if (music.getTitle().equals(musicTitle)) {
                    iterator.remove();
                    removed = true;
                    break;
                }
            }

            if (removed) {
                System.out.println("Music removed from the playlist successfully.");
            } else {
                throw new IllegalArgumentException("Music with the given title does not exist in the playlist.");
            }
        } else {
            throw new IllegalArgumentException("Wrong password. Music cannot be removed.");
        }
    }

    public void removeMusic(Music music, String password) {
        if (music == null) {
            throw new IllegalArgumentException("Music cannot be null.");
        }

        if (owner.verifyPassword(password)) {
            if (playlist.remove(music)) {
                System.out.println("Music removed from the playlist successfully.");
            } else {
                throw new IllegalArgumentException("Music does not exist in the playlist.");
            }
        } else {
            throw new IllegalArgumentException("Wrong password. Music cannot be removed.");
        }
    }

    public ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();

        for (Music music : playlist) {
            if (music.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(music);
            }
        }

        return result;
    }

    public ArrayList<Music> searchInPlaylist(String musicTitle, String singerName) {
        ArrayList<Music> result = new ArrayList<>();

        for (Music music : playlist) {
            if (music.getTitle().toLowerCase().contains(title.toLowerCase()) &&
                    music.getSinger().getUsername().toLowerCase().contains(singerName.toLowerCase())) {
                result.add(music);
            }
        }

        return result;
    }

    public void playPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("The playlist is empty.");
        } else
            for (Music music : playlist) {
                music.play();
            }
    }

    public void playShuffledPlaylist() {
        if (playlist.isEmpty())
            System.out.println("The playlist is empty.");
        else {
            Collections.shuffle(playlist);

            for (Music music : playlist) {
                music.play();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Playlist title cannot be null or empty.");

        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public final void setOwner(User owner) {
        if (owner == null)
            throw new IllegalArgumentException("Owner cannot be null.");

        this.owner = owner;
    }
}
