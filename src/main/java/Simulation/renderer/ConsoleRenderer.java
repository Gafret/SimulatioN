package Simulation.renderer;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;

public class ConsoleRenderer implements Renderer {
    private static final String BACKGROUND_CELL_BROWN = "🟫";

    @Override
    public void render(SimulationMap simulationMap) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< simulationMap.getHeight(); i++){
            builder.setLength(0);
            for(int j = 0; j< simulationMap.getWidth(); j++){
                Coordinate2D coord = new Coordinate2D(i, j);
                Entity entity = simulationMap.getEntity(coord);
                if(entity != null){
                    builder.append(this.getEntitySprite(entity));
                    continue;
                }
                builder.append(BACKGROUND_CELL_BROWN);
            }
            System.out.println(builder);
        }
    }

    private String getEntitySprite(Entity entity){
        return switch (entity.getClass().getSimpleName()){
            case "Wolf" -> "\uD83D\uDC3A"; // 🐺
            case "Deer" -> "\uD83E\uDD8C"; // 🦌
            case "Grass" -> "\uD83C\uDF3F"; // 🌿
            case "Rock" -> "\uD83D\uDDFF"; // 🗿
            case "Tree" -> "\uD83C\uDF33"; // 🌳
            default -> "e";
        };
    }
}
