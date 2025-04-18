package core;

import java.util.ArrayList;

public class User {
    private static ArrayList<User> allUsers = new ArrayList<>();

    private String username;
    private String password;

    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private ArrayList<Playlist> playlists;

    private UserBehavior behavior;

    public User(String username, String password) throws InvalidOperationException, IllegalArgumentException {
        setUsername(username);
        setPassword(password);
        followerList = new ArrayList<>();
        followingList = new ArrayList<>();
        playlists = new ArrayList<>();
        setBehavior(new RegularBehavior());

        allUsers.add(this);
    }

    public void follow(User user) {
        addFollowing(user);
        user.addFollower(user);
    }

    public void createPlaylist(String title, User owner) {
        this.behavior.createPlaylist(title, owner);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }

    public void addFollowing(User user) {
        if (user == null || this.equals(user))
            throw new InvalidOperationException("Invalid following user.");

        if (!followingList.contains(user))
            followingList.add(user);
        else
            throw new InvalidOperationException("Already following user.");
    }

    public void addFollower(User user) {
        if (user == null || this.equals(user))
            throw new InvalidOperationException("Invalid follower user.");

        if (!followerList.contains(user))
            followerList.add(user);
        else
            throw new InvalidOperationException("User already a follower.");
    }

    public void addPlaylist(Playlist playlist) {
        if (playlist == null)
            throw new IllegalArgumentException("Playlist cannot be null.");

        if (!playlists.contains(playlist))
            playlists.add(playlist);
        else
            throw new InvalidOperationException("Playlist already exists.");
    }

    public boolean verifyPassword(String password) {
        if (password == null)
            throw new IllegalArgumentException("Password cannot be null.");

        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        if (username == null || username.trim().isEmpty())
            throw new IllegalArgumentException("Username cannot be null or empty.");

        for (User user : allUsers)
            if (user.getUsername().equals(username))
                throw new IllegalArgumentException("Username is already taken.");

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        if (password == null || password.length() < 8)
            throw new IllegalArgumentException("Password must be at least 8 characters long.");

        this.password = password;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public final void setBehavior(UserBehavior behavior) {
        if (behavior == null)
            throw new IllegalArgumentException("Behavior cannot be null.");

        this.behavior = behavior;
    }
}
