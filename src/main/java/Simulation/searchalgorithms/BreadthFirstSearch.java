package Simulation.searchalgorithms;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;

import java.util.*;

public class BreadthFirstSearch implements SearchAlgorithm{

    private Coordinate2D[] getPathFromParents(java.util.Map<Coordinate2D, Coordinate2D> parents,
                                                  Coordinate2D start,
                                                  Coordinate2D end){
        List<Coordinate2D> path = new ArrayList<>();
        Coordinate2D current = end;
        path.add(current);
        while(current != start){
            current = parents.get(current);
            path.add(current);
        }
        return path.reversed().toArray(new Coordinate2D[path.size()]);
    }

    @Override
    public Coordinate2D[] findPathTo(Coordinate2D start, Class<? extends Entity> entityType, Map map) {
        Queue<Coordinate2D> queue = new LinkedList<>();
        java.util.Map<Coordinate2D, Coordinate2D> parents = new HashMap<>();

        queue.add(start);
        parents.put(start, start);

        while(!queue.isEmpty()) {
            Coordinate2D current = queue.poll();
            int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            for(int[] direction : directions) {
                int row = current.getRow() + direction[0];
                int column = current.getColumn() + direction[1];
                Coordinate2D newCoordinate = new Coordinate2D(row, column);

                if(row >= 0 && column >= 0 &&
                        row < map.getHeight() && column < map.getWidth() &&
                        parents.get(newCoordinate) == null) {

                    Entity entity = map.getEntity(newCoordinate);

                    if(entity != null && entity.getClass() == entityType) {
                        parents.put(newCoordinate, current);
                        return getPathFromParents(parents, start, newCoordinate);
                    }
                    else if (entity == null) {
                        queue.add(newCoordinate);
                        parents.put(newCoordinate, current);
                    }
                }
            }
        }
        return new Coordinate2D[0];
    }
}
