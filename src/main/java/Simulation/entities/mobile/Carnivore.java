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
    public void makeMove(Coordinate2D curPos, Map map) {
        Coordinate2D[] pathToPrey = searchAlgorithm.findPathTo(curPos, Herbivore.class, map);
        if (pathToPrey.length == 2) {
            Coordinate2D preyPos = pathToPrey[pathToPrey.length - 1];
            if(attackCreature(preyPos, map)){
                consume(preyPos, map);
            }
        }
        else if(pathToPrey.length <= movementSpeed){
            moveTo(curPos, pathToPrey[pathToPrey.length-2], map);
        } else {
            moveTo(curPos, pathToPrey[movementSpeed-1], map);
        }
    }

    private void consume(Coordinate2D preyPos, Map map){
        Creature prey = (Creature) map.getEntity(preyPos);
        addHealth(prey.getClassHealthPoints());
        map.removeEntity(preyPos);
    }

    private boolean attackCreature(Coordinate2D preyPos, Map map){
        Creature prey = (Creature) map.getEntity(preyPos);
        prey.reduceHealth(attackDamage);
        return prey.isDead();
    }

}
