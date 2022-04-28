public class NBody{

    /**
     * Read the radius of the universe
     * @param fileName The file name containing the universe information
     * @return The radius of the universe
     */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /**
     * Read all planets
     * @param fileName The file that contains the universe information
     * @return An array of planets
     */
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);

        int numPlanets = in.readInt();
        Planet[] planets = new Planet[numPlanets];

        double radius = in.readDouble();
        for (int i = 0; i < numPlanets; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            // String img = "images/" + in.readString();
            String img = in.readString();
            Planet planet = new Planet(xP, yP, xV, yV, m, img);
            planets[i] = planet;
        }
        return planets;
    }

    public static void main(String[] args) {
        // Read inputs
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        //Draw the background
        String backgroud_img = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        
        StdDraw.enableDoubleBuffering();

        double time = 0;
        while (time < T){
            // Calculate net forces
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                double net_force_x = planets[i].calcNetForceExertedByX(planets);
                double net_force_y = planets[i].calcNetForceExertedByY(planets);
                xForces[i] = net_force_x;
                yForces[i] = net_force_y;
            }

            // Update each planet
            for (int i = 0; i < planets.length; i++)
                planets[i].update(dt, xForces[i], yForces[i]);
            
            // Draw background
            StdDraw.picture(0, 0, backgroud_img);

            // Draw all the planets
            for (Planet planet : planets)
                planet.draw();
            
            // Show offscreen buffer
            StdDraw.show();

            // Pause for 10 milliseconds
            StdDraw.pause(10);

            time += dt;
        }
    
        // Print the end state
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}