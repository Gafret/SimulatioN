package Simulation.map;

public class Coordinate2D {
    private int x;
    private int y;

    public Coordinate2D(int x, int y) {}
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int[] getCoordinate() {
        return new int[] {x, y};
    }
    public float getDistance(Coordinate2D other) {
        return (float) Math.sqrt(Math.pow(other.getX() - x, 2) + Math.pow(other.getY() - y, 2));
    }
    public void add(Coordinate2D other) {
        x += other.getX();
        y += other.getY();
    }
}
