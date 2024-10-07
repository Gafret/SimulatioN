import Simulation.Simulation;
import Simulation.actions.Action;
import Simulation.actions.AddAction;
import Simulation.actions.CompositeAction;
import Simulation.actions.MoveAction;
import Simulation.entities.immobile.Grass;
import Simulation.entities.mobile.Deer;
import Simulation.entities.mobile.Wolf;
import Simulation.map.DefaultSimulationMap;
import Simulation.map.SimulationMap;
import Simulation.renderer.ConsoleRenderer;
import Simulation.renderer.Renderer;
import Simulation.searchalgorithms.BreadthFirstSearch;
import Simulation.searchalgorithms.SearchAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Action> initActions = new ArrayList<>();
        List<Action> turnActions = new ArrayList<>();
        Renderer renderer = new ConsoleRenderer();
        SimulationMap map = new DefaultSimulationMap(10, 10);
        SearchAlgorithm bfs = new BreadthFirstSearch();

        // int health, int movementSpeed, SearchAlgorithm searchAlgorithm
        // int health, int movementSpeed, int attackDamage, int attackRadius, SearchAlgorithm searchAlgorithm
        Action createDeer = new AddAction(Deer.class, 2, new Class<?>[]{int.class, int.class, SearchAlgorithm.class}, new Object[]{10, 10, bfs});
        Action createWolves = new AddAction(Wolf.class, 2, new Class<?>[]{int.class, int.class, int.class, int.class, SearchAlgorithm.class}, new Object[]{10, 10, 5, 1, bfs});
        Action createGrass = new AddAction(Grass.class, 2, new Class<?>[]{}, new Object[]{});
        Action makeMove = new MoveAction();

        CompositeAction composite = new CompositeAction();

        composite.addAction(createDeer);
        composite.addAction(createWolves);
        composite.addAction(createGrass);

        initActions.add(composite);
        turnActions.add(makeMove);

        Simulation sim = new Simulation(renderer, map, initActions, turnActions);
        sim.start();
    }
}
