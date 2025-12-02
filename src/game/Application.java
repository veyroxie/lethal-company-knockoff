package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.characters.Player;
import game.scraps.PotOfGold;
import game.terrain.*;

import java.util.*;

/**
 * The main class to start the game.<br>
 * @author Adrian Kristanto
 * Modified by:
 * @author Tong Zhi Hao
 * @author Henry Ma Yee Lik
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle());

        List<String> Polymorphia = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "..............................",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        NamedGameMap polymorphiaMap = new NamedGameMap(new GameMap(groundFactory, Polymorphia), "Polymorphia");
        world.addGameMap(polymorphiaMap.getMap());

        List<String> StaticFactory = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                "......."
        );

        NamedGameMap StaticFactoryMap = new NamedGameMap(new GameMap(groundFactory, StaticFactory), "Static Factory");
        world.addGameMap(StaticFactoryMap.getMap());

        List<String> Connascence = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~.............."
        );

        NamedGameMap ConnascenceMap = new NamedGameMap(new GameMap(groundFactory, Connascence), "Connascence");
        world.addGameMap(ConnascenceMap.getMap());


        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, polymorphiaMap.getMap().at(15, 6));
        polymorphiaMap.getMap().at(15,6).addItem(new PotOfGold());

        List<NamedGameMap> locations = new ArrayList<>();
        locations.add(polymorphiaMap);
        locations.add(StaticFactoryMap);
        locations.add(ConnascenceMap);
        polymorphiaMap.getMap().at(15,5).setGround(new ComputerTerminal(locations));
        StaticFactoryMap.getMap().at(3, 2).setGround(new ComputerTerminal(locations));
        ConnascenceMap.getMap().at(15, 5).setGround(new ComputerTerminal(locations));

        world.run();

        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

}
