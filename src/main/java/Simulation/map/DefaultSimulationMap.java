package Simulation.map;

import Simulation.entities.base.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultSimulationMap implements SimulationMap {
    private final Map<Coordinate2D, Entity> map = new HashMap<Coordinate2D, Entity>();
    private final int height;
    private final int width;

    public DefaultSimulationMap(int height, int width) {
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
        if(position.getRow() < 0 || position.getRow() > width ||
                position.getColumn() < 0 || position.getColumn() > height)
            throw new IllegalArgumentException("Invalid position");

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
    public List<Coordinate2D> getAllEntitiesOfType(Class<? extends Entity> type) {
        List<Coordinate2D> result = new ArrayList<>();
        for(Map.Entry<Coordinate2D, Entity> entry : map.entrySet()){
            if(entry.getValue().getClass().equals(type)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    @Override
    public Coordinate2D getEmptyCell(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                Coordinate2D coordinate = new Coordinate2D(i, j);
                if(!map.containsKey(coordinate)){
                    return coordinate;
                }
            }
        }
        return new Coordinate2D(-1, -1);
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
