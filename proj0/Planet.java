public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yY, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yY;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }

    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        return G * mass * p.mass / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        return force * (p.xxPos - xxPos) / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        return force * (p.yyPos - yyPos) / distance;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double force = 0d;
        for (Planet p : ps) {
            if (!this.equals(p)) {
                force += calcForceExertedByX(p);
            }
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double force = 0d;
        for (Planet p : ps) {
            if (!this.equals(p)) {
                force += calcForceExertedByY(p);
            }
        }
        return force;
    }

    public void update(double time, double xForce, double yForce) {
        double xAcce = xForce / mass;
        double yAcce = yForce / mass;
        xxVel += xAcce * time;
        yyVel += yAcce * time;
        xxPos += xxVel * time;
        yyPos += yyVel * time;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}