public class Profile {
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
                   Fractal fractal,
                   Boolean isProfileInUse)
    {
        this.name = name;
        this.maxIter = maxIter;
        this.escapeRadius = escapeRadius;
        this.colormap = colormap;
        this.fractalType = fractal;
        this.isProfileInUse = isProfileInUse;
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
}
