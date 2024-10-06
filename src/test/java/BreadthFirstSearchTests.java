import Simulation.entities.immobile.Rock;
import Simulation.entities.mobile.Deer;
import Simulation.map.Coordinate2D;
import Simulation.map.DefaultSimulationMap;
import Simulation.map.SimulationMap;
import Simulation.searchalgorithms.BreadthFirstSearch;
import Simulation.searchalgorithms.SearchAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class BreadthFirstSearchTests {
    SearchAlgorithm bfs;

    BreadthFirstSearchTests(){
        bfs = new BreadthFirstSearch();
    }

    private SimulationMap initMap(){
        return new DefaultSimulationMap(5, 5);
    }

    @Test
    public void Get_path_to_existing_entity_without_obstacles(){
        SimulationMap simulationMap = initMap();
        Coordinate2D entityPos = new Coordinate2D(2,3);
        Coordinate2D startPos = new Coordinate2D(0,1);
        Deer deer = new Deer(10, 10, bfs);
        simulationMap.addEntity(deer, entityPos);

        Coordinate2D[] path = bfs.findPathTo(startPos, deer.getClass(), simulationMap);
        System.out.println(Arrays.stream(path).toList());
    }

    @Test
    public void Get_path_to_existing_entity_with_obstacles(){
        SimulationMap simulationMap = initMap();
        Coordinate2D entityPos = new Coordinate2D(2,3);
        Coordinate2D obstaclePos = new Coordinate2D(1,1);
        Coordinate2D startPos = new Coordinate2D(0,1);
        Deer deer = new Deer(10, 10, bfs);
        Rock rock = new Rock();
        simulationMap.addEntity(rock, obstaclePos);
        simulationMap.addEntity(deer, entityPos);

        Coordinate2D[] path = bfs.findPathTo(startPos, deer.getClass(), simulationMap);
        System.out.println(Arrays.stream(path).toList());
    }

    @Test
    public void Get_path_to_non_existing_entity(){
        SimulationMap simulationMap = initMap();
        Coordinate2D startPos = new Coordinate2D(0,1);

        Coordinate2D[] path = bfs.findPathTo(startPos, Deer.class, simulationMap);
        assertEquals(0, path.length);
    }
}
