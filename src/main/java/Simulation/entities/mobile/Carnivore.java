package Simulation.entities.mobile;

import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Carnivore extends Creature {
    protected int attackDamage;

    public Carnivore(int health, int movementSpeed, int attackDamage){
        super(health, movementSpeed);
        this.attackDamage = attackDamage;
    }

    @Override
    public boolean makeMove() {

    }

    private boolean attackCreature(Creature prey){
        prey.reduceHealth(this.attackDamage);
        return !prey.isAlive();
    }

    private Coordinate2D findNearestPrey(SearchAlgorithm searchAlgorithm){
        return searchAlgorithm.findClosest(Herbivore.class);
    }
}
