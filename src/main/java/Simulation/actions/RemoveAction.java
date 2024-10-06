package Simulation.actions;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;

import java.util.List;

public class RemoveAction implements Action {
    private final Class<? extends Entity> removeTarget;
    private final int numberToRemove;

    public RemoveAction(Class<? extends Entity> removeTarget, int numberToRemove) {
        this.removeTarget = removeTarget;
        this.numberToRemove = numberToRemove;
    }

    @Override
    public void execute(SimulationMap map) {
        List<Coordinate2D> entities = map.getAllEntitiesOfType(removeTarget);
        int i = 0;
        while(i != numberToRemove){
            map.removeEntity(entities.get(i));
            i++;
        }
    }
}
