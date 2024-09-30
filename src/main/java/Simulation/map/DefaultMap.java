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
    public boolean moveEntity(Coordinate2D position, Coordinate2D destination) {
        if(this.checkIsEmpty(position) || !this.checkIsEmpty(destination))
            return false;
        Entity entity = this.map.get(position);
        this.removeEntity(position);
        this.map.put(destination, entity);
        return true;
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
