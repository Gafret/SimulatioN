package Simulation.map;

import Simulation.entities.base.Entity;

import java.util.HashMap;

public class DefaultMap implements Map {
    private final java.util.Map<Coordinate2D, Entity> map = new HashMap<Coordinate2D, Entity>();
    private final int height;
    private final int width;

    public DefaultMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Entity getEntity(Coordinate2D coordinate) {
        return map.get(coordinate);
    }

    @Override
    public boolean addEntity(Entity entity, Coordinate2D position) {
        if(!this.checkIsEmpty(position))
            return false;

        this.map.put(position, entity);
        return true;
    }

    @Override
    public boolean removeEntity(Coordinate2D position) {
        if(this.checkIsEmpty(position))
            return false;

        this.map.remove(position);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    private boolean checkIsEmpty(Coordinate2D position){
        return !this.map.containsKey(position);
    }
}
