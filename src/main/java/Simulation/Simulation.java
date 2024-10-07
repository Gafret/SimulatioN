package Simulation;

import Simulation.actions.Action;
import Simulation.map.SimulationMap;
import Simulation.renderer.Renderer;

import java.util.List;

public class Simulation {
    private int turnCounter = 0;
    private Renderer renderer;
    private SimulationMap map;
    private List<Action> turnActions;
    private boolean running = false;

    public Simulation(Renderer renderer, SimulationMap map, List<Action> initActions, List<Action> turnActions) {
        this.renderer = renderer;
        this.map = map;
        this.turnActions = turnActions;

        executeActions(initActions);
    }

    public void nextTurn(){
        executeActions(turnActions);
        turnCounter++;
    }

    public void start(){
        running = true;

        while(running){
            nextTurn();
            renderer.render(map);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pause(){
        running = false;
    }

    private void executeActions(List<Action> actions){
        for(Action action : actions){
            action.execute(map);
        }
    }
}
