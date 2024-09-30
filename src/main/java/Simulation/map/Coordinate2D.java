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
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int[] getCoordinate() {
        return new int[] {x, y};
    }
}
