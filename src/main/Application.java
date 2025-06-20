package main;

import main.Menu;

/**
 * to run the main program
 */
public class  Application {

    public static void main(String[] args) {
        User user1 = new User();
        BookingSystem bs = new BookingSystem(user1);
        bs.printStatus();



    }
}
