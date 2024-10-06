import Simulation.entities.base.Entity;
import Simulation.entities.immobile.Grass;
import Simulation.entities.immobile.Rock;
import Simulation.entities.immobile.Tree;
import Simulation.entities.mobile.Deer;
import Simulation.entities.mobile.Wolf;
import Simulation.map.Coordinate2D;
import Simulation.map.DefaultSimulationMap;
import Simulation.map.SimulationMap;
import Simulation.renderer.ConsoleRenderer;
import Simulation.renderer.Renderer;
import Simulation.searchalgorithms.BreadthFirstSearch;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RendererTests {
    Renderer r;
    SimulationMap simulationMap;

    private final static Entity WOLF;
    private final static Entity DEER;
    private final static Entity TREE;
    private final static Entity GRASS;
    private final static Entity ROCK;

    private final static String[] EXPECTED_MAPS;
    private final static Coordinate2D[][] COORDINATES;

    static {
        WOLF = new Wolf(10,10,10,10, new BreadthFirstSearch());
        DEER = new Deer(10,10, new BreadthFirstSearch());
        TREE = new Tree();
        GRASS = new Grass();
        ROCK = new Rock();
        EXPECTED_MAPS = new String[]{
                "\uD83D\uDC3A🟫\r\n🟫🟫\r\n", // 🐺🟫🟫🟫
                "\uD83D\uDC3A\uD83D\uDC3A\r\n🟫🟫\r\n", //🐺🐺🟫🟫
                "\uD83D\uDC3A🟫\r\n\uD83E\uDD8C🟫\r\n", // 🐺🟫🦌🟫
                "\uD83D\uDC3A\uD83C\uDF33\r\n\uD83D\uDDFF\uD83C\uDF3F\r\n" //🐺🌳🗿🌿
        };
        Coordinate2D zeroZero = new Coordinate2D(0,0);
        Coordinate2D zeroOne = new Coordinate2D(0,1);
        Coordinate2D oneZero = new Coordinate2D(1,0);
        Coordinate2D oneOne = new Coordinate2D(1,1);
        COORDINATES = new Coordinate2D[][]{
                {zeroZero},
                {zeroZero, zeroOne},
                {zeroZero, oneZero},
                {zeroZero, zeroOne, oneZero, oneOne}
        };
    }

    private final Entity[][] entities;
    private static int currentIndex = 0;

    {
        entities = new Entity[][]{
                {WOLF},
                {WOLF, WOLF},
                {WOLF, DEER},
                {WOLF, TREE, ROCK, GRASS}
        };
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    RendererTests(){
        r = new ConsoleRenderer();
    }

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    void setUp(){
        simulationMap = new DefaultSimulationMap(2, 2);
    }

    @Test
    void Draw_empty_board(){
        String expected = "🟫🟫\r\n🟫🟫\r\n";
        r.render(simulationMap);
        assertEquals(expected, outContent.toString());
    }

    // add parametrized test for all sprites
    @RepeatedTest(value = 4, name = "Parametrized map test {currentRepetition}/{totalRepetitions}")
    void Draw_board_with_entity(){
        String expected = EXPECTED_MAPS[currentIndex];
        Coordinate2D[] coordinate = COORDINATES[currentIndex];
        Entity[] items = entities[currentIndex];

        for(int i=0; i<coordinate.length;i++){
            simulationMap.addEntity(items[i], coordinate[i]);
        }
        r.render(simulationMap);
        assertEquals(expected, outContent.toString());
        outContent.reset();
        currentIndex++;
    }
}
