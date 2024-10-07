package Simulation.entities.mobile;

import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;
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
    public void makeMove(Coordinate2D curPos, SimulationMap simulationMap) {
        Coordinate2D[] pathToPrey = searchAlgorithm.findPathTo(curPos, Creature.class, simulationMap);
        if(pathToPrey.length == 0){
            return;
        }
        if (pathToPrey.length == 2) {
            Coordinate2D preyPos = pathToPrey[pathToPrey.length - 1];
            if(attackCreature(preyPos, simulationMap)){
                consume(preyPos, simulationMap);
            }
        }
        else if(pathToPrey.length <= movementSpeed){
            moveTo(curPos, pathToPrey[pathToPrey.length-2], simulationMap);
        } else {
            moveTo(curPos, pathToPrey[movementSpeed-1], simulationMap);
        }
    }

    private void consume(Coordinate2D preyPos, SimulationMap simulationMap){
        Creature prey = (Creature) simulationMap.getEntity(preyPos);
        addHealth(prey.getClassHealthPoints());
        simulationMap.removeEntity(preyPos);
    }

    private boolean attackCreature(Coordinate2D preyPos, SimulationMap simulationMap){
        Creature prey = (Creature) simulationMap.getEntity(preyPos);
        prey.reduceHealth(attackDamage);
        return prey.isDead();
    }

}
