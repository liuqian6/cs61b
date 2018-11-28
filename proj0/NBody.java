class NBody {

    public static void main(String args[]) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(0d - radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg", radius * 2, radius * 2);
        for(Planet p : planets) {
            p.draw();
        }
        StdDraw.show();
        
        double time = 0;
        while(time < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg", radius * 2, radius * 2);
            for(Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
    }

    public static double readRadius(String filePath) {
        In in = new In(filePath);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;    
    }

    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[number];
        for (int i = 0; i < number; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
        }
        return planets;
    }
}