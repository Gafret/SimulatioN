package Simulation.searchalgorithms;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;

public interface SearchAlgorithm {
    public Coordinate2D findClosest(Class<? extends Entity> entityType);
}
