import java.io.Serializable;

public class Profile implements Serializable {
    private String name;
    private int maxIter;
    private double escapeRadius;
    private Colormap colormap;
    private Fractal fractalType;
    private Boolean isProfileInUse;

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

    public Colormap getColormap() {
        return colormap;
    }

    public double getEscapeRadius() {
        return escapeRadius;
    }

    public Fractal getFractalType() {
        return fractalType;
    }

    public int getMaxIter() {
        return maxIter;
    }

    public void setColormap(Colormap colormap) {
        this.colormap = colormap;
    }

    public void setEscapeRadius(double escapeRadius) {
        this.escapeRadius = escapeRadius;
    }

    public void setFractalType(Fractal fractalType) {
        this.fractalType = fractalType;
    }

    public void setMaxIter(int maxIter) {
        this.maxIter = maxIter;
    }

    public Boolean getProfileInUse() {
        return isProfileInUse;
    }

    public void setProfileInUse(Boolean profileInUse) {
        isProfileInUse = profileInUse;
    }

    public String toString(){
        return name;
    }

    public String getName(){
        return name;
    }

    public void setIsProfileInUse(Boolean value){
        this.isProfileInUse = value;
    }

    public Boolean equals(Profile other){
        return (this.name.equals(other.name));
    }
}
