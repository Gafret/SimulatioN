package Simulation.searchalgorithms;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;

public interface SearchAlgorithm {
    public Coordinate2D findClosest(Coordinate2D start, Class<? extends Entity> entityType, Map map);
}
