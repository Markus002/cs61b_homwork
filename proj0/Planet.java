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

    /**
     * Calculates the force exerted by planet b
     * @param b The other planet
     * @return the exerted force
     */
    public double calcForceExertedBy(Planet b) {
        double distance = this.calcDistance(b);
        double grav_const = 6.67e-11;
        double force = grav_const*this.mass*b.mass/Math.pow(distance,2);
        return force;
    }

    /**
     * Calculates the force in the horizontal direction
     * @param b The other planet
     * @return The force in the horizontal direction
     */
    public double calcForceExertedByX(Planet b) {
        double force = this.calcForceExertedBy(b);
        double force_x = force * (b.xxPos - xxPos) / this.calcDistance(b);
        return force_x;
    }

    /**
     * Calculates the force in the vertical direction
     * @param b The other planet
     * @return The force in the vertical direction
     */
    public double calcForceExertedByY(Planet b) {
        double force = this.calcForceExertedBy(b);
        double force_y = force * (b.yyPos - yyPos) / this.calcDistance(b);
        return force_y;
    }

    /**
     * Calculates the net force in the horizontal direction
     * @param planets An array of planets
     * @return
     */
    public double calcNetForceExertedByX(Planet[] planets){
        double net_force_x = 0;
        for (int i = 0; i < planets.length; i++) {
            if (this.equals(planets[i]))
                continue;
            net_force_x += this.calcForceExertedByX(planets[i]);
        }
        return net_force_x;
    }

    /**
     * Calculates the net force in the vertical direction
     * @param planets An array of planets
     * @return
     */
    public double calcNetForceExertedByY(Planet[] planets){
        double net_force_y = 0;
        for (int i = 0; i < planets.length; i++) {
            if (this.equals(planets[i]))
                continue;
            net_force_y += this.calcForceExertedByY(planets[i]);
        }
        return net_force_y;
    }

    /**
     * Update the velocity and position of a planet
     * @param dt A small time interval
     * @param fX The net force in the horizontal direction
     * @param fY The net force in the vertical direction
     */
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
}