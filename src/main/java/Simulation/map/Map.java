package Simulation.map;

import Simulation.entities.base.Entity;

public interface Map {
    public boolean addEntity(Entity entity, Coordinate2D position);
    public boolean removeEntity(Coordinate2D position);
    public boolean isEmpty();
    public boolean moveEntity(Coordinate2D position, Coordinate2D destination);

    public int getHeight();
    public int getWidth();
}
