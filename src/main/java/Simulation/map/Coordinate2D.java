package Simulation.map;

public class Coordinate2D {
    private int row;
    private int column;

    public Coordinate2D(int r, int c) {
        this.row = r;
        this.column = c;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int[] getCoordinate() {
        return new int[] {row, column};
    }
    public float getDistance(Coordinate2D other) {
        return (float) Math.sqrt(Math.pow(other.getRow() - row, 2) + Math.pow(other.getColumn() - column, 2));
    }
    public void add(Coordinate2D other) {
        row += other.getRow();
        column += other.getColumn();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate2D other) {
            return row == other.getRow() && column == other.getColumn();
        }
        return false;
    }

    @Override
    public int hashCode() {
        String hash = String.valueOf(getRow()) + getColumn();
        return hash.hashCode();
    }

    @Override
    public String toString() {
        return "Coordinate2D [row=" + row + ", column=" + column + "]";
    }
}
