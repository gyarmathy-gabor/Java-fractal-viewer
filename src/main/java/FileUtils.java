import com.google.gson.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface FileUtils {


    public static String jsonToString(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader filereader = new FileReader(path);                       // "/colormaps.json"
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch(IOException e){e.printStackTrace();}
        return stringBuilder.toString();
    }


    public static Colormap[] readColormaps(String path){
        String json = jsonToString(path);
        List<Colormap> colormaps = new ArrayList<Colormap>();
        Gson gson = new Gson();


        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();

        for(JsonElement element : jsonArray){
            JsonObject jsonObject = element.getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            JsonArray hexArray = jsonObject.get("colors").getAsJsonArray();

            String colorArray[] = new String[hexArray.size()];
            for(int i=0;i<hexArray.size();i++){
                colorArray[i] = hexArray.get(i).getAsString();
            }
            Colormap colormap = new Colormap(name,colorArray);
            colormaps.add(colormap);
        }
        return colormaps.toArray(new Colormap[0]);
    }

    public static void writeProfiles(String path, List<Profile> profiles){


    }

    public static void saveProfile(String path, Profile profile){ //Save current profile


    }

    public static List<Profile> readProfiles(String path){
        return null;
    }

    public static Profile readChoosenProfiles(String path){
        return null;
    }

}
