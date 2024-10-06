package Simulation.entities.mobile;

import Simulation.entities.immobile.Grass;
import Simulation.entities.immobile.HerbivoreFood;
import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;
import Simulation.searchalgorithms.SearchAlgorithm;

public class Herbivore extends Creature {

    public Herbivore(int health, int movementSpeed, SearchAlgorithm searchAlgorithm) {
        super(health, movementSpeed, searchAlgorithm);
    }

    @Override
    public void makeMove(Coordinate2D curPos, SimulationMap simulationMap) {
        Coordinate2D[] pathToVegetation = searchAlgorithm.findPathTo(curPos, Grass.class, simulationMap);
        if (pathToVegetation.length == 2) {
            Coordinate2D vegetationPos = pathToVegetation[pathToVegetation.length - 1];
            consume(vegetationPos, simulationMap);
        }
        else if(pathToVegetation.length <= movementSpeed){
            moveTo(curPos, pathToVegetation[pathToVegetation.length-2], simulationMap);
        } else {
            moveTo(curPos, pathToVegetation[movementSpeed-1], simulationMap);
        }
    }

    private void consume(Coordinate2D vegetationPos, SimulationMap simulationMap){
        HerbivoreFood vegetation = (HerbivoreFood) simulationMap.getEntity(vegetationPos);
        addHealth(vegetation.getHealthRestore());
        simulationMap.removeEntity(vegetationPos);
    }

}
