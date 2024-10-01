package Simulation.entities.mobile;

import Simulation.entities.immobile.Grass;
import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Herbivore extends Creature {
    protected int attackDamage;

    public Herbivore(int health, int movementSpeed) {
        super(health, movementSpeed);
    }

    @Override
    public boolean makeMove() {

    }

}
