import Simulation.entities.base.Entity;
import Simulation.entities.immobile.Rock;
import Simulation.map.Coordinate2D;
import Simulation.map.DefaultMap;
import Simulation.map.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MapTests {
    Map map;

    MapTests(){
        map = new DefaultMap(10, 10);
    }

    @Test
    void Map_is_empty(){
        assertTrue(map.isEmpty());
    }

    @Test
    void Map_is_not_empty(){
        map.addEntity(new Rock(), new Coordinate2D(0, 0));
        assertFalse(map.isEmpty());
    }

    @Test
    void Get_map_height(){
        assertEquals(10, map.getHeight());
    }

    @Test
    void Get_map_width(){
        assertEquals(10, map.getWidth());
    }

    @Test
    void Add_entity_to_map_inbounds(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(0, 0);

        assertTrue(map.addEntity(rock, coordinate));
        assertEquals(map.getEntity(coordinate), rock);
    }

    @Test
    void Add_entity_to_map_outbounds(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(200, 200);
        assertThrows(IllegalArgumentException.class, () -> map.addEntity(rock, coordinate));
    }

    @Test
    void Remove_existing_entity_from_map(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        map.addEntity(rock, coordinate);
        assertTrue(map.removeEntity(coordinate));
    }

    @Test
    void Remove_non_existing_entity_from_map(){
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        assertFalse(map.removeEntity(coordinate));
    }

    @Test
    void Get_existing_entity_from_map(){
        Entity rock = new Rock();
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        map.addEntity(rock, coordinate);
        assertEquals(map.getEntity(coordinate), rock);
    }

    @Test
    void Get_non_existing_entity_from_map(){
        Coordinate2D coordinate = new Coordinate2D(0, 0);
        assertNull(map.getEntity(coordinate));
    }

}
