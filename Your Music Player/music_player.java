import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private String filePath;

    public Song(String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getFilePath() {
        return filePath;
    }
}

class MusicLibrary {
    List<Song> songs;
    private Map<String, List<Song>> playlists;
    private int bass;
    private int treble;

    public MusicLibrary() {
        songs = new ArrayList<>();
        playlists = new HashMap<>();
        bass = 0;
        treble = 0;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void createPlaylist(String name) {
        playlists.put(name, new ArrayList<>());
    }

    public void addToPlaylist(String playlistName, Song song) {
        List<Song> playlist = playlists.get(playlistName);
        if (playlist != null) {
            playlist.add(song);
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public void playSong(Song song) {
        System.out.println("Playing: " + song.getTitle() + " - " + song.getArtist());
    }

    public void setEqualizerSettings(int bass, int treble) {
        this.bass = bass;
        this.treble = treble;
        System.out.println("Equalizer settings adjusted: Bass=" + bass + " Treble=" + treble);
    }

    public int getBass() {
        return bass;
    }

    public int getTreble() {
        return treble;
    }
}

public class music_player {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a song");
            System.out.println("2. Create a playlist");
            System.out.println("3. Add a song to a playlist");
            System.out.println("4. Play a song");
            System.out.println("5. Set Equalizer settings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    library.addSong(new Song(title, artist, filePath));
                    break;
                case 2:
                    System.out.print("Enter playlist name: ");
                    String playlistName = scanner.nextLine();
                    library.createPlaylist(playlistName);
                    break;
                case 3:
                    System.out.print("Enter playlist name: ");
                    playlistName = scanner.nextLine();
                    System.out.print("Enter song title: ");
                    title = scanner.nextLine();
                    Song songToAdd = library.songs.stream()
                            .filter(song -> song.getTitle().equals(title))
                            .findFirst()
                            .orElse(null);
                    if (songToAdd != null) {
                        library.addToPlaylist(playlistName, songToAdd);
                        System.out.println(title + " added to " + playlistName);
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter song title to play: ");
                    title = scanner.nextLine();
                    Song songToPlay = library.songs.stream()
                            .filter(song -> song.getTitle().equals(title))
                            .findFirst()
                            .orElse(null);
                    if (songToPlay != null) {
                        library.playSong(songToPlay);
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter bass value (-10 to 10): ");
                    int bass = scanner.nextInt();
                    System.out.print("Enter treble value (-10 to 10): ");
                    int treble = scanner.nextInt();
                    library.setEqualizerSettings(bass, treble);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
