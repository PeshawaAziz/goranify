package core;

public class PremiumBehavior implements UserBehavior {
    private int month;

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
}
