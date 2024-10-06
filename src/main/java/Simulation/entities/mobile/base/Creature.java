package Simulation.entities.mobile.base;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;
import Simulation.searchalgorithms.SearchAlgorithm;

public abstract class Creature extends Entity {
    protected int healthPoints;
    protected final int classHealthPoints;
    protected int movementSpeed;
    protected SearchAlgorithm searchAlgorithm;

    public Creature(int healthPoints, int movementSpeed, SearchAlgorithm searchAlgorithm){
        this.healthPoints = healthPoints;
        this.classHealthPoints = healthPoints;
        this.movementSpeed = movementSpeed;
    }

    abstract public void makeMove(Coordinate2D curPos, Map map);
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
    public boolean isDead(){
        return healthPoints == 0;
    }
    public int getClassHealthPoints(){
        return classHealthPoints;
    }
    public void reduceHealth(int healthPoints){
        if(healthPoints < 0)
            throw new IllegalArgumentException("You can't reduce negative health points");

        if(healthPoints > this.healthPoints)
            this.healthPoints = 0;
        this.healthPoints -= healthPoints;
    }
    public void addHealth(int healthPoints){
        if(healthPoints < 0)
            throw new IllegalArgumentException("You can't add negative health points");
        this.healthPoints += healthPoints;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public int getMovementSpeed(){
        return movementSpeed;
    }
}
