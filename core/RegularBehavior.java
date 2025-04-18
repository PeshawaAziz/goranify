package core;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new InvalidOperationException("Regular users cannot create playlists.");
    }

    @Override
    public void playMusic(Music music) {
        music.play();

        if (this.playingLimit > 0)
            this.playingLimit--;
        else
            throw new InvalidOperationException("Reached the playing limit for user.");
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
    }
}
