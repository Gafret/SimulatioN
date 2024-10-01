package Simulation.entities.mobile;

import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Carnivore extends Creature {
    protected int attackDamage;
    protected int attackRadius;

    public Carnivore(int health, int movementSpeed, int attackDamage, int attackRadius){
        super(health, movementSpeed);
        this.attackDamage = attackDamage;
        this.attackRadius = attackRadius;
    }

    @Override
    public boolean makeMove() {

    }

    private boolean attackCreature(Creature prey){
        prey.reduceHealth(this.attackDamage);
        return !prey.isAlive();
    }

}
