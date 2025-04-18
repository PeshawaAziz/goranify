package core;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        setMonth(month);
    }

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist playlist = new Playlist(title, owner);
        owner.addPlaylist(playlist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        setMonth(this.month + month);
    }

    private void setMonth(int month) {
        if (month < 0) {
            throw new IllegalArgumentException("Month cannot be negative.");
        }

        this.month = month;
    }
}
