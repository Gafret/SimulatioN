package Simulation.entities.mobile.base;

import Simulation.entities.base.Entity;

public abstract class Creature extends Entity {
    protected int healtPoints;
    protected int movementSpeed;

    abstract public void makeMove();
}
