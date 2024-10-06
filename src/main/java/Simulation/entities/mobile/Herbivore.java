package Simulation.entities.mobile;

import Simulation.entities.immobile.Grass;
import Simulation.entities.immobile.HerbivoreFood;
import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Herbivore extends Creature {

    public Herbivore(int health, int movementSpeed, SearchAlgorithm searchAlgorithm) {
        super(health, movementSpeed, searchAlgorithm);
    }

    @Override
    public void makeMove(Coordinate2D curPos, Map map) {
        Coordinate2D[] pathToVegetation = searchAlgorithm.findPathTo(curPos, Grass.class, map);
        if (pathToVegetation.length == 2) {
            Coordinate2D vegetationPos = pathToVegetation[pathToVegetation.length - 1];
            consume(vegetationPos, map);
        }
        else if(pathToVegetation.length <= movementSpeed){
            moveTo(curPos, pathToVegetation[pathToVegetation.length-2], map);
        } else {
            moveTo(curPos, pathToVegetation[movementSpeed-1], map);
        }
    }

    private void consume(Coordinate2D vegetationPos, Map map){
        HerbivoreFood vegetation = (HerbivoreFood) map.getEntity(vegetationPos);
        addHealth(vegetation.getHealthRestore());
        map.removeEntity(vegetationPos);
    }

}
