package Simulation.map;

import Simulation.entities.base.Entity;

import java.util.List;

public interface SimulationMap {
    public boolean addEntity(Entity entity, Coordinate2D position);
    public boolean removeEntity(Coordinate2D position);
    public boolean isEmpty();
    public Entity getEntity(Coordinate2D position);
    public List<Coordinate2D> getAllEntitiesOfType(Class<? extends Entity> type);
    public Coordinate2D getEmptyCell();

    public int getHeight();
    public int getWidth();
}
