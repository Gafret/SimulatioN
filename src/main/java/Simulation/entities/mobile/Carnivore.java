package Simulation.entities.mobile;

import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Carnivore extends Creature {
    protected int attackDamage;
    protected int attackRadius;

    public Carnivore(int health, int movementSpeed, SearchAlgorithm searchAlgorithm, int attackDamage, int attackRadius){
        super(health, movementSpeed, searchAlgorithm);
        this.attackDamage = attackDamage;
        this.attackRadius = attackRadius;
    }

    @Override
    public boolean makeMove(Coordinate2D curPos, Map map) {
        Coordinate2D closestPrey = searchAlgorithm.findClosest(curPos, Herbivore.class, map);
        Coordinate2D movementVector;
        if(closestPrey.getX() != -1){

        }
    }

    private boolean attackCreature(Creature prey){
        prey.reduceHealth(this.attackDamage);
        return !prey.isAlive();
    }

}
