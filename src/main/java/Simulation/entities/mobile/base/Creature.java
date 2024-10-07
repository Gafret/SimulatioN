package Simulation.entities.mobile.base;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;
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
        this.searchAlgorithm = searchAlgorithm;
    }

    abstract public void makeMove(Coordinate2D curPos, SimulationMap simulationMap);
    protected boolean moveTo(Coordinate2D from, Coordinate2D to, SimulationMap simulationMap){
        Entity entity = simulationMap.getEntity(from);
        if(!(entity instanceof Creature) ||
                simulationMap.getEntity(to) != null ||
                from.getDistance(to) > movementSpeed)
            return false;

        simulationMap.removeEntity(from);
        simulationMap.addEntity(entity, to);
        return true;
    }
    public boolean isDead(){
        return healthPoints == 0;
    }
    public int getClassHealthPoints(){
        return classHealthPoints;
    }
    public void reduceHealth(int damage){
        if(damage < 0)
            throw new IllegalArgumentException("You can't reduce negative health points");

        if(damage > healthPoints){
            healthPoints = 0;
            return;
        }
        healthPoints -= damage;
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
