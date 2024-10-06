import Simulation.entities.base.Entity;
import Simulation.entities.immobile.Rock;
import Simulation.entities.mobile.Deer;
import Simulation.entities.mobile.Wolf;
import Simulation.map.Coordinate2D;
import Simulation.map.DefaultMap;
import Simulation.map.Map;
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

    private Map initMap(){
        return new DefaultMap(5, 5);
    }

    @Test
    public void Get_path_to_existing_entity_without_obstacles(){
        Map map = initMap();
        Coordinate2D entityPos = new Coordinate2D(2,3);
        Coordinate2D startPos = new Coordinate2D(0,1);
        Deer deer = new Deer(10, 10, bfs);
        map.addEntity(deer, entityPos);

        Coordinate2D[] path = bfs.findPathTo(startPos, deer.getClass(), map);
        System.out.println(Arrays.stream(path).toList());
    }

    @Test
    public void Get_path_to_existing_entity_with_obstacles(){
        Map map = initMap();
        Coordinate2D entityPos = new Coordinate2D(2,3);
        Coordinate2D obstaclePos = new Coordinate2D(1,1);
        Coordinate2D startPos = new Coordinate2D(0,1);
        Deer deer = new Deer(10, 10, bfs);
        Rock rock = new Rock();
        map.addEntity(rock, obstaclePos);
        map.addEntity(deer, entityPos);

        Coordinate2D[] path = bfs.findPathTo(startPos, deer.getClass(), map);
        System.out.println(Arrays.stream(path).toList());
    }

    @Test
    public void Get_path_to_non_existing_entity(){
        Map map = initMap();
        Coordinate2D startPos = new Coordinate2D(0,1);

        Coordinate2D[] path = bfs.findPathTo(startPos, Deer.class, map);
        assertEquals(0, path.length);
    }
}
