package Simulation.actions;

import Simulation.map.SimulationMap;

import java.util.ArrayList;
import java.util.List;

public class CompositeAction implements Action {
    private final List<Action> actions = new ArrayList<>();

    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public void execute(SimulationMap map) {
        for (Action action : actions) {
            action.execute(map);
        }
    }
}
