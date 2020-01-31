import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class AlbumWriter {

    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("album", "Sonata Arctica",
                "Reckoning Night", 2007, 5));
        albums.add(new Album("album", "Kamelot","Black Halo", 2005, 4));

        JSONArray arrayAlbum = new JSONArray();
        for (Album album : albums) {
            JSONObject albumJSON = new JSONObject();
            albumJSON.put("type", album.getType());
            albumJSON.put("title", album.getTitre());
            albumJSON.put("artist", album.getArtiste());
            albumJSON.put("publication", album.getPublication());
            albumJSON.put("rating", album.getRating());
            arrayAlbum.add(albumJSON);
        }
        JSONObject collection = new JSONObject();
        collection.put("collection", arrayAlbum);

        try {
            DiskFile.saveStringIntoFile("output.json",
                    collection.toString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
//Pour tester le String[] args
//
// java nomFichierJava argument
// if (args[0].equals("-t"))
//    sout("Bravo");
// else
//    sout("Try again");
