import java.lang.Math;

public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    /**
     * Constructor of a Planet
     * @param xP
     * @param yP
     * @param xV
     * @param yV
     * @param m
     * @param img
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * Clone Planet b to new instance
     * @param b The instance to be cloned
     */
    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /**
     * Calculates the distance from another Planet b
     * @param b The other planet
     * @return The distance between two planets
     */
    public double calcDistance(Planet b) {
        double dx_squared = Math.pow(xxPos - b.xxPos, 2);
        double dy_squared = Math.pow(yyPos - b.yyPos, 2);
        return Math.sqrt(dx_squared + dy_squared);
    }
}