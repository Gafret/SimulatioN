package Simulation.renderer;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;

public class ConsoleRenderer implements Renderer {
    private static final String BACKGROUND_CELL_BROWN = "🟫";

    @Override
    public void render(Map map) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<map.getHeight(); i++){
            builder.setLength(0);
            for(int j=0; j<map.getWidth(); j++){
                Coordinate2D coord = new Coordinate2D(i, j);
                Entity entity = map.getEntity(coord);
                builder.append(BACKGROUND_CELL_BROWN);
                if(entity != null){
                    builder.append(this.getEntitySprite(entity));
                }
            }
            System.out.println(builder.toString());
        }
    }

    private String getEntitySprite(Entity entity){
        return switch (entity.getClass().getSimpleName()){
            case "Carnivore" -> "\uD83D\uDC3A"; // 🐺
            case "Herbivore" -> "\uD83E\uDD8C"; // 🦌
            case "Grass" -> "\uD83C\uDF3F"; // 🌿
            case "Rock" -> "\uD83D\uDDFF"; // 🗿
            case "Tree" -> "\uD83C\uDF33"; // 🌳
            default -> "e";
        };
    }
}
