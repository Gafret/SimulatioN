package Simulation.map;

import Simulation.entities.base.Entity;

public interface Map {
    public boolean addEntity(Entity entity, Coordinate2D position);
    public boolean removeEntity(Coordinate2D position);
    public boolean isEmpty();
    public Entity getEntity(Coordinate2D position);

    public int getHeight();
    public int getWidth();
}
