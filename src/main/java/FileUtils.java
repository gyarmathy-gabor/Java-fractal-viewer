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

    public static void writeProfiles(List<Profile> profiles){
        FileOutputStream fileout = null;
        try {
            fileout = new FileOutputStream("src/main/resources/profiles.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(profiles);
            out.close();
        }
        catch (FileNotFoundException e) {throw new RuntimeException(e);}
        catch (IOException e) {throw new RuntimeException(e);}

    }

    public static void saveProfile(Profile profile){ //Save current profile
        List<Profile> profiles = readProfiles();
        if(profiles==null){
            profiles = new ArrayList<>();
        }
        profiles.add(profile);
        writeProfiles(profiles);
    }

    public static void deleteProfile(Profile profileToDelete){
        List<Profile> profiles = readProfiles();

        // Remove profile if the name matches
        profiles.removeIf(profile -> profile.getName().equals(profileToDelete.getName()));

        writeProfiles(profiles);
    }

    public static List<Profile> readProfiles(){
        File file = new File("src/main/resources/profiles.dat");
        if(!file.exists()){
            return new ArrayList<>();
        }


        FileInputStream fileIn = null;
        List<Profile> profiles = null;
        try {
            fileIn = new FileInputStream("src/main/resources/profiles.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn) ;
            profiles =(List<Profile>) in.readObject();
            in.close();
        }
        catch (FileNotFoundException e) {
            writeProfiles(null);
        }
        catch (IOException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

        return profiles;
    }

    public static Profile getChoosenProfile(){
        List<Profile> profiles = readProfiles();
        for(Profile p : profiles){
            if(p.getProfileInUse()){
                return p;
            }
        }
        return null;
    }
}
