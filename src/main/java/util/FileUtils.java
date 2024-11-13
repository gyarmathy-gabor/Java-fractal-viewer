package util;

import com.google.gson.*;
import model.profile.Colormap;
import model.profile.Profile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A utility class for handling file operations, particularly related to saving, loading,
 * and manipulating profiles and colormaps. It provides methods to read and write data
 * to files, specifically for profiles and colormaps in JSON format and binary serialization.
 * The usage of both JSON and binary serialization heavily depended on the developer's mood.:,)
 */
public interface FileUtils {


    /**
     * Reads the contents of a JSON file and returns it as a single string.
     *
     * @param path The path of the JSON file to read.
     * @return The contents of the file as a String.
     */
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

    /**
     * Reads the colormap data from a specified JSON file.
     * The file is expected to contain an array of colormap objects.
     * Each colormap object has a "name" field and a "colors" array containing hex color values.
     *
     * @param path The path to the JSON file containing colormap data.
     * @return An array of Colormap objects parsed from the file.
     */
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

    /**
     * Writes the list of profiles to a file, serializing them to disk.
     *
     * @param profiles The list of profiles to be saved.
     */
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

    /**
     * Saves a given profile by adding it to the list of existing profiles and writing
     * the updated list back to disk.
     *
     * @param profile The profile to save.
     */
    public static void saveProfile(Profile profile){ //Save current profile
        List<Profile> profiles = readProfiles();
        if(profiles==null){
            profiles = new ArrayList<>();
        }
        profiles.add(profile);
        writeProfiles(profiles);
    }

    /**
     * Deletes the specified profile from the list of profiles.
     * The profile is removed based on its name.
     *
     * @param profileToDelete The profile to delete.
     */
    public static void deleteProfile(Profile profileToDelete){
        List<Profile> profiles = readProfiles();

        // Remove profile if the name matches
        profiles.removeIf(profile -> profile.getName().equals(profileToDelete.getName()));

        writeProfiles(profiles);
    }

    /**
     * Reads and returns a list of profiles from the "profiles.dat" file.
     * If the file does not exist, an empty list is returned.
     *
     * @return A list of Profile objects read from the file, or an empty list if the file doesn't exist.
     */
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

    /**
     * Retrieves the profile that is marked as active (currently in use).
     *
     * @return The active Profile, or null if no active profile is found.
     */
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
