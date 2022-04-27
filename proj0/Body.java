public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    /**
     * Constructor of a Body
     * @param xP
     * @param yP
     * @param xV
     * @param yV
     * @param m
     * @param img
     */
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * Clone Body b to new instance
     * @param b The instance to be cloned
     */
    public Body(Body b) {
        xxPos = b.xxPos;
        yypos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
}