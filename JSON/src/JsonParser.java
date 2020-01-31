import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.io.IOException;
import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<Album> jsonFileToAlbums
            (String filname) throws IOException {

        ArrayList<Album> albums = new ArrayList<>();

        // va chercher le JSON et le dompe dans un String
        String jsonString =
                DiskFile.loadFileIntoString("collection.json");

        // on va chercher l'objet generique et on transforme la chaine
        // en objet JSON

        JSONObject object =
                (JSONObject)JSONSerializer.toJSON(jsonString);
        // ensuite, on va chercher l'objet qu'on veut dans cet objet-là
        // et on retourne l'Arraylist. On ne veut pas trop travailler en
        // JSONArray pour le reste du projet, par contre
        JSONArray data = object.getJSONArray("collection");

        jsonToAlbums(albums, data);

        return albums;
    }

    private static void jsonToAlbums
            (ArrayList<Album> albums, JSONArray data) {

        // autre type de boucle possible
        //for (Object albumTemp : data) {
        //    JSONObject album = (JSONObject) albumTemp ;
        //}

        for (int i = 0; i < data.size(); ++i) {
            JSONObject album = data.getJSONObject(i);
            albums.add((new Album(
                    // doit être mot pour mot ce qu'il y a dans
                    // collection.json, pas la classe Album
                    album.getString("type"),
                    album.getString("artist"),
                    album.getString("title"),
                    album.getInt("publication"),
                    album.getInt("rating")

            )));
        }

    }

}
