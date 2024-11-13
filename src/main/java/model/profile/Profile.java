package model.profile;

import model.fractal.Fractal;
import util.FileUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a user profile for fractal visualization settings.
 * A profile contains information such as the name, maximum iterations, escape radius,
 * colormap, and the type of fractal to generate. The profile can be in use or not,
 * and the settings can be adjusted by the user.
 */
public class Profile implements Serializable {
    private String name;
    private int maxIter;
    private double escapeRadius;
    private Colormap colormap;
    private Fractal fractalType;
    private Boolean isProfileInUse;

    /**
     * Constructs a new {@code Profile} with the specified parameters.
     *
     * @param name the name of the profile
     * @param maxIter the maximum number of iterations for fractal computation
     * @param escapeRadius the escape radius for fractal calculations
     * @param colormap the colormap to be used for rendering the fractal
     * @param fractal the type of fractal to be generated
     */
    public Profile(String name,
                   int maxIter,
                   double escapeRadius,
                   Colormap colormap,
                   Fractal fractal)
    {
        this.name = name;
        this.maxIter = maxIter;
        this.escapeRadius = escapeRadius;
        this.colormap = colormap;
        this.fractalType = fractal;
        this.isProfileInUse = false; //LOOK OUT FOR THIS
    }

    /**
     * Returns the colormap associated with this profile.
     *
     * @return the colormap of the profile
     */
    public Colormap getColormap() {
        return colormap;
    }

    /**
     * Returns the escape radius for this profile's fractal computations.
     *
     * @return the escape radius of the profile
     */
    public double getEscapeRadius() {
        return escapeRadius;
    }

    /**
     * Returns the type of fractal for this profile.
     *
     * @return the fractal type associated with this profile
     */
    public Fractal getFractalType() {
        return fractalType;
    }

    /**
     * Returns the maximum number of iterations for this profile's fractal computations.
     *
     * @return the maximum iterations for the profile
     */
    public int getMaxIter() {
        return maxIter;
    }

    /**
     * Sets the colormap for this profile.
     *
     * @param colormap the new colormap to be used in this profile
     */
    public void setColormap(Colormap colormap) {
        this.colormap = colormap;
    }

    /**
     * Sets the escape radius for this profile.
     *
     * @param escapeRadius the new escape radius for this profile
     */
    public void setEscapeRadius(double escapeRadius) {
        this.escapeRadius = escapeRadius;
    }

    /**
     * Sets the type of fractal for this profile.
     *
     * @param fractalType the new fractal type for this profile
     */
    public void setFractalType(Fractal fractalType) {
        this.fractalType = fractalType;
    }

    /**
     * Sets the maximum number of iterations for this profile.
     *
     * @param maxIter the new maximum iterations for this profile
     */
    public void setMaxIter(int maxIter) {
        this.maxIter = maxIter;
    }


    /**
     * Returns {@code true} if this profile is currently in use, otherwise {@code false}.
     *
     * @return {@code true} if the profile is in use, {@code false} otherwise
     */
    public Boolean getProfileInUse() {
        return isProfileInUse;
    }

    /**
     * Sets whether this profile is in use.
     *
     * @param profileInUse {@code true} if the profile is in use, {@code false} otherwise
     */
    public void setProfileInUse(Boolean profileInUse) {
        isProfileInUse = profileInUse;
    }

    /**
     * Returns the string representation of this profile, which is its name.
     *
     * @return the name of the profile
     */
    @Override
    public String toString(){
        return name;
    }


    /**
     * Returns the name of this profile.
     *
     * @return the name of the profile
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the "in use" flag for this profile to the specified value.
     *
     * @param value the value to set for the profile's "in use" flag
     */
    public void setIsProfileInUse(Boolean value){
        this.isProfileInUse = value;
    }

    /**
     * Compares this profile with another profile by name.
     *
     * @param other the profile to compare with
     * @return {@code true} if the profiles have the same name, {@code false} otherwise
     */
    public Boolean hasSameName(Profile other){
        return (this.name.equals(other.name));
    }

    /**
     * Checks if any profile is currently in use.
     * This method reads the profiles from a file and checks their "in use" status.
     * This method is used before opening the viewer.
     *
     * @return {@code true} if any profile is in use, {@code false} otherwise
     */
    public static Boolean isThereAnyProfileInUse(){
        List<Profile> profiles = FileUtils.readProfiles();
        // Megnézni mindegyiket hogy van-e igaz, ha van akkor az első találatot használja
        for(Profile p : profiles){
            if(p.isProfileInUse){return true;}
        }
        return false;


    }
}
