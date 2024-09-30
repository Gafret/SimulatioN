package Simulation.entities.mobile.base;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;

public abstract class Creature extends Entity {
    protected int healthPoints;
    protected int movementSpeed;

    public Creature(int healthPoints, int movementSpeed){
        this.healthPoints = healthPoints;
        this.movementSpeed = movementSpeed;
    }

    abstract public boolean makeMove();

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
