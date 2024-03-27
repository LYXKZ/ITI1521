import java.util.Arrays;
import java.io.*;

public class PlayList {

    // Instance variables

    private Song[] songs;
    private int count;
    private int capacityIncrement;
  
    // Constructor
    // See below for a new usage of the reserved keyword this.

    public PlayList( int initialCapacity, int capacityIncrement ) {
    
        if ( initialCapacity < 1 )
            throw new IllegalArgumentException( "Illegal capacity: "+ initialCapacity );
    
        if ( capacityIncrement < 1 )
            throw new IllegalArgumentException( "Illegal increment: "+ capacityIncrement );
    
        songs = new Song[ initialCapacity ];
        this.capacityIncrement = capacityIncrement;
    }
  
    public PlayList( int initialCapacity ) {
        this( initialCapacity, 10 );
    }
  
    public PlayList() {
        this( 10, 10 );
    }

    // Returns the number of elements currently stored in the PlayList
  
    public int getSize() {
        return count;
    }
  
    public boolean addSong( Song song ) {

        if ( song == null )
            throw new IllegalArgumentException( "null is not a valid argument" );

        for ( int i=0; i<count; i++ )
            if ( songs[ i ].equals( song ) ) // songs[ i ] cannot be null
                return false;
        
        if ( count == songs.length ) {

            Song[] tmp = songs;
            songs = new Song[ tmp.length + capacityIncrement ];
            for ( int i=0; i< tmp.length; i++ )
                songs[ i ] = tmp[ i ];
        }

        songs[ count++ ] = song;
        return true;
    }
  
    public Song getSongAt( int index ) {

        if ( index < 0 || index >= count )
            throw new IndexOutOfBoundsException( "" + index );

        return songs[ index ];
    }
  
    // Arrays already has a sort method.

    public void sort( java.util.Comparator<Song> c ) {
        Arrays.sort( songs, c );
    }

    // Implementing our own sort method.

    public void sort2( java.util.Comparator<Song> c ) {
    
        for ( int i = 0; i < count; i++ ) {
      
            int min = i;
      
            // Find the smallest element in the unsorted region of the
            // array.
      
            for ( int j = i+1; j < count; j++ )
                if ( c.compare( songs[ j ], songs[ min ] ) < 0 )
                    min = j;
      
            // Swap the smallest unsorted element with the element
            // found a position i.
      
            Song tmp = songs[ min ];
            songs[ min ] = songs[ i ];
            songs[ i ] = tmp;
        }
    }

    public static PlayList getSongsFromFile( String fileName ) throws IOException {
        //throw new UnsupportedOperationException("PlayList getSongsFromFile not implemented");
        // YOUR CODE HERE (remove the exception)
        /*InputStreamReader reader;
        PlayList playlist = new PlayList();

        FileInputStream x = new FileInputStream(fileName);
        reader = new InputStreamReader(x);

        int i;
        int y = 1;
        String name = "", artist = "", album = "";
        while ((i = reader.read()) != -1) {
            char c = (char) i;

            if (y == 1) {
                if (c == ':') {
                    y = 2;
                } else {
                    name = name + c;
                }
            } else if (y == 2) {
                if (c == ':') {
                } else {
                    artist = artist + c;
                }
            } else {
                if (c == '\n') {
                    playlist.addSong(new Song(name, artist, album));
                    y = 1;
                    playlist.count += 1;
                } else {
                    album = album + c;
                }
            }
        }
        reader.close();
        return playlist; */
        PlayList playlist = new PlayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while ((line = reader.readLine()) != null) {
            String name = line.substring(0, line.indexOf(':'));
            String temp = line.substring(line.indexOf(':') + 1);
            String artist = temp.substring(0, temp.indexOf(':'));
            String album = temp.substring(temp.indexOf(':') + 1);

            playlist.songs[playlist.count] = new Song(name, artist, album);
            playlist.count += 1;
        }
        reader.close();
        return playlist;
    }

    public void writeSongsToFile( String fileName ) throws IOException {
        //throw new UnsupportedOperationException("PlayList writeSongsToFile not implemented");
        // YOUR CODE HERE (remove the exception)
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName));
        for (Song song : songs) {
            if (song != null) {
            out.write(song.getName() + ":" + song.getArtist() + ":" + song.getAlbum() + "\n");
        }}
        out.close();

    }

    public boolean equals(PlayList other){
        if(other == null){
            return false;
        }
        if(count != other.count || capacityIncrement != other.capacityIncrement){
            return false;
        }
        for(int i = 0; i < count; i++){
            if(! songs[i].equals(other.songs[i])){
                return false;
            }
        }
        return true;
    }


    public String toString(){
        String result = "PlayList:\n";
        for(int i = 0; i < count; i++){
            result += "\t" + songs[i].toString() + "\n";
        }
        result += "Count: " + count + "\nCapacityIncrement: "+ capacityIncrement;
        return result;
    }
}
