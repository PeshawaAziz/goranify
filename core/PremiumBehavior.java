package core;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        setMonth(month);
    }

    @Override
    public void createPlaylist(String title, User owner) {
        // TODO make new Playlist object and add it to the owner playlists
    }

    @Override
    public void playMusic(Music music) {
        // TODO play the given music
    }

    @Override
    public void buyPremium(User owner, int month) {
        // TODO increase the subscription time with the given month
    }

    private void setMonth(int month) {
        if (month < 0) {
            throw new IllegalArgumentException("Month cannot be negative.");
        }

        this.month = month;
    }
}
