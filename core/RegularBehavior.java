package core;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        // TODO make new Playlist object and add it to the owner playlists
    }

    @Override
    public void playMusic(Music music) {
        // TODO play music in Music class

        if (this.playingLimit > 0)
            this.playingLimit--;
        else
            throw new InvalidOperationException("Reached the playing limit for user.");
    }

    @Override
    public void buyPremium(User owner, int month) {
        // TODO promote regular user to premium user
        // (update the value of behavior field)
    }
}
