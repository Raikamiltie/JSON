import java.io.IOException;
import java.util.ArrayList;

public class AlbumStats {

    public static void main(String[] args) {

        // pas une bonne pratique, techniquement, de hard-coder ca
        String filename = "collection.json";

        try {
            ArrayList<Album> albums = JsonParser.jsonFileToAlbums(filename);
            printStats(albums);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printStats(ArrayList<Album> albums) {
        int nbAlbums = 0;
        int nbSingles = 0;
        int nbDepuis2003 = 0;
        int nbNoteCinq = 0;

        for (Album album : albums) {
            if (album.getType().equals("single")) {
                ++nbAlbums;
            } else {
                ++nbSingles;
            }

            if (album.getPublication() >= 2003) {
                ++nbDepuis2003;
            }
            if (album.getRating() == 5) {
                ++nbNoteCinq;
            }
        }
        System.out.printf(" Nombre albums : %d%n Nombre singles : %d%n Nombre depuis 2003 : %d%n" +
                " Nombre note 5 : %d%n", nbAlbums, nbSingles, nbDepuis2003, nbNoteCinq);
    }

}
