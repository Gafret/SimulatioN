package Simulation.entities.mobile;

import Simulation.entities.immobile.Grass;
import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Herbivore extends Creature {
    protected int attackDamage;

    public Herbivore(int health, int movementSpeed, SearchAlgorithm searchAlgorithm) {
        super(health, movementSpeed, searchAlgorithm);
    }

    @Override
    public boolean makeMove(Coordinate2D curPos, Map map) {

    }

}
