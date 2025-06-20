package main;

import main.actions.Action;

import java.util.*;

/**
 * creates the consoleMenu that booking system will use
 */
public class Menu {
    /**
     * creates a hashmap that displays available actions for user to undertake.
     * Waits for user input and then selects the action mapped to that input character.
     * @param actions possible actions by a class
     * @return outcome of chosen action
     */
    public static Action showMenu(List<Action> actions) {
        Scanner scanner = new Scanner(System.in);
        List<Character> freeChars = new ArrayList<Character>();
        Map<Character, Action> keyToActionMap = new HashMap<>();


        for (char j = 'a'; j <= 'z'; j++) {
            freeChars.add(j);
        }
        for (Action action : actions) {
            char c = freeChars.get(0);
            freeChars.remove(Character.valueOf(c));
            keyToActionMap.put(c, action);
            System.out.println(
                    c + ": " + action.menuDescription());
        }
        char key;
        do {
            key = scanner.next().charAt(0);
        } while (!keyToActionMap.containsKey(key));

        return keyToActionMap.get(key);
    }
}