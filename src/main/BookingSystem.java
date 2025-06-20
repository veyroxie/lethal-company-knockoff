package main;

import main.actions.Action;
import main.actions.ActionCapable;
import main.vehicles.*;

import java.util.ArrayList;
import java.util.List;

/**
 * class that holds the available vehicles for booking, creates a consoleMenu for current user.
 * Basically sets the environment for the user to make actions.
 */
public class BookingSystem {
    private ArrayList<Vehicle> vList = new ArrayList();

    /**
     * user running the system
     */
    public User user;


    /**
     * default constructor
     * @param user user whose booking list is being accessed
     */
    public BookingSystem(User user){
        this.user = user;
    }

    /**
     * runs the methods that shows up as available options in the user's menu
     */
    public void printStatus() {
        System.out.println("Welcome to FIT2099 System.Booking System");
        createVehicles();
        setAllID();
        consoleMenu();
    }

    /**
     * instantiates vehicles that are available to be booked by users
     */
    public void createVehicles() {
        vList.add(new Sedan("Lexus", 2023, 200, 500, EngineType.ELECTRIC));
        vList.add(new Sedan("BMW", 2022, 150, 600, EngineType.PETROL));
        vList.add(new SUV("Mercedes", 2020, 500, 7, EngineType.DIESEL));
        vList.add(new SUV("Tesla", 2021, 800, 4, EngineType.ELECTRIC));
        vList.add(new Truck("Ford", 2019, 400, 1.0));
        vList.add(new Truck("Lexus", 2023, 450, 1.2));
    }

    /**
     * sets randomised ID for all Vehicles available
     */
    public void setAllID(){
        for (Vehicle v: vList){
            v.setID();
        }
    }


    /**
     * method that creates a consoleMenu to show all the actions the user can choose to take
     */
    public void consoleMenu() {
        while (!user.getIsUserDone()) {
            List<Action> actions = new ArrayList<>();
            List<ActionCapable> actionCapables = new ArrayList<>();
            actionCapables.add(user);
            actionCapables.addAll(vList);
            for (ActionCapable actionCapable : actionCapables) {
                actions.addAll(actionCapable.allowableActions());
            }

            System.out.println("#########################################");
            Action action = Menu.showMenu(actions);
            System.out.println(action.execute(user));
        }
    }


}
