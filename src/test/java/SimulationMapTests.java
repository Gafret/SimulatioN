import Simulation.entities.base.Entity;
import Simulation.entities.immobile.Rock;
import Simulation.map.Coordinate2D;
import Simulation.map.DefaultSimulationMap;
import Simulation.map.SimulationMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SimulationMapTests {
    SimulationMap simulationMap;

    SimulationMapTests(){
        simulationMap = new DefaultSimulationMap(10, 10);
    }

    @Test
    void Map_is_empty(){
        assertTrue(simulationMap.isEmpty());
    }

    @Test
    void Map_is_not_empty(){
        simulationMap.addEntity(new Rock(), new Coordinate2D(0, 0));
        assertFalse(simulationMap.isEmpty());
    }

    @Test
    void Get_map_height(){
        assertEquals(10, simulationMap.getHeight());
    }

    @Test
    void Get_map_width(){
        assertEquals(10, simulationMap.getWidth());
    }

    @Test
    void Add_entity_to_map_inbounds(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(0, 0);

        assertTrue(simulationMap.addEntity(rock, coordinate));
        assertEquals(simulationMap.getEntity(coordinate), rock);
    }

    @Test
    void Add_entity_to_map_outbounds(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(200, 200);
        assertThrows(IllegalArgumentException.class, () -> simulationMap.addEntity(rock, coordinate));
    }

    @Test
    void Remove_existing_entity_from_map(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        simulationMap.addEntity(rock, coordinate);
        assertTrue(simulationMap.removeEntity(coordinate));
    }

    @Test
    void Remove_non_existing_entity_from_map(){
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        assertFalse(simulationMap.removeEntity(coordinate));
    }

    @Test
    void Get_existing_entity_from_map(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        simulationMap.addEntity(rock, coordinate);
        assertEquals(simulationMap.getEntity(coordinate), rock);
    }

    @Test
    void Get_non_existing_entity_from_map(){
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        assertNull(simulationMap.getEntity(coordinate));
    }

}
