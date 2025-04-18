import core.*;

public class Main {
    public static void main(String[] args) {
        /*
         * TEST CODE
         */

        try {
            User zirak = new User("HasanZirak", "safepass123");
            User kaya = new User("AhmetKaya", "somepass");

            Music song1 = new Music("Karwan", kaya);
            Music song2 = new Music("Nalashkena", zirak);

            System.out.println(zirak.getUsername() + " plays music:");
            zirak.playMusic(song1);

            kaya.buyPremium(kaya, 3);
            System.out.println(kaya.getUsername() + " creates a playlist: ");
            kaya.createPlaylist(kaya.getUsername() + "'s PL", kaya);

            Playlist manualPlaylist = new Playlist(zirak.getUsername() + "'s PL", zirak);
            System.out.println("Adding music to " + zirak.getUsername() + " playlist:");
            manualPlaylist.addMusic(song2, "somepass");

            System.out.println("Editing playlist title:");
            manualPlaylist.editTitle("New Playlist Title", "somepass");

            System.out.println("Playing playlist:");
            manualPlaylist.playPlaylist();
        } catch (InvalidOperationException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}