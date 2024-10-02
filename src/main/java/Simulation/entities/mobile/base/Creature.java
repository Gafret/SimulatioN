package Simulation.entities.mobile.base;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;
import Simulation.searchalgorithms.SearchAlgorithm;

public abstract class Creature extends Entity {
    protected int healthPoints;
    protected int movementSpeed;
    protected SearchAlgorithm searchAlgorithm;

    public Creature(int healthPoints, int movementSpeed, SearchAlgorithm searchAlgorithm){
        this.healthPoints = healthPoints;
        this.movementSpeed = movementSpeed;
    }

    abstract public boolean makeMove(Coordinate2D curPos, Map map);

    protected boolean moveTo(Coordinate2D from, Coordinate2D to, Map map){
        Entity entity = map.getEntity(from);
        if(!(entity instanceof Creature) ||
                map.getEntity(to) != null ||
                from.getDistance(to) > movementSpeed)
            return false;

        map.removeEntity(from);
        map.addEntity(entity, to);
        return true;
    }
    public boolean isAlive(){
        return healthPoints > 0;
    }
    public void reduceHealth(int healthPoints){
        if(healthPoints < 0)
            throw new IllegalArgumentException("You can't reduce negative health points");

        this.healthPoints -= healthPoints;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public int getMovementSpeed(){
        return movementSpeed;
    }
}
