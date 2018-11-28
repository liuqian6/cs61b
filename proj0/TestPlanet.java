class TestPlanet {

    public static void main(String args[]) {
        Planet p1 = new Planet(0d, 0d, 0d, 0d, 1d, null);
        Planet p2 = new Planet(1d, 1d, 1d, 1d, 2d, null);
        System.out.println("Pairwise force: " + p1.calcForceExertedBy(p2));
    }
}