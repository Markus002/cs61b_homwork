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
            String img = in.readString();
            Planet planet = new Planet(xP, yP, xV, yV, m, img);
            planets[i] = planet;
        }
        return planets;
    }
}