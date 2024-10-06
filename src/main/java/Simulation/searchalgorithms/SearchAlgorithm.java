package Simulation.searchalgorithms;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;

public interface SearchAlgorithm {
    public Coordinate2D[] findPathTo(Coordinate2D start, Class<? extends Entity> entityType, Map map);
}
