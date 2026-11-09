package ch.digi.heizung;

import java.util.ArrayList;

public class Controller extends ny.Controller {
    ArrayList<Heating> heatings = new ArrayList<Heating>();

    private static String[] mainOptions = { "Get all temperatures", "Get single temperature", "Set single temperature", "Add new Heating", "quit" };

    public void run() {
        initHeating();

        boolean shouldRun = true;

        int temperature = 0;
        int id = 0;
        String name = "";
        while (shouldRun) {
            switch (Controller.Banner.getBannerChoice(mainOptions, "Enter an Option: ")) {
            case 1:
                // Print all
                printAllTemperatures();
                break;
            case 2:
                // Print single by id
                id = Controller.Input.readInt("Enter id of the heating: ", 1, heatings.size());
                printSingletemperature(id);
                break;
            case 3:
                // set single by id
                id = Controller.Input.readInt("Enter id of the heating: ", 1, heatings.size());
                temperature = Controller.Input.readInt("Enter heat of the Heating: ");
                setSingletemperature(id, temperature);
                break;
            case 4:
                // Add new Heating
                name = Controller.Input.readString("Enter the name of the Heating: ");
                temperature = Controller.Input.readInt("Enter heat of the Heating: ");
                addHeating(name, temperature);
                break;
            case 5:
                // Quit
                System.out.println("Goodbye!");
                shouldRun = false;
            }
        }
    }

    private void printAllTemperatures() {
        System.out.println();
        for (Heating heating : heatings) {
            System.out.println("Id: " + (heatings.indexOf(heating) + 1));
            heating.printSelf();
            System.out.println();
        }
    }

    private void setSingletemperature(int id, int temperature) {
        heatings.get(id - 1).setTemperature(temperature);
    }

    private void printSingletemperature(int id) {
        System.out.println();
        heatings.get(id - 1).printSelf();
        System.out.println();
    }

    public void addHeating(String name, int temperature) {
        heatings.add(new Heating(name, temperature));
    }

    public void addHeating(Heating heating) {
        heatings.add(heating);
    }

    public void initHeating() {
        addHeating("Schlafzimmer", 25);
        addHeating("Wohnzimmer", 20);
        addHeating("Badezimmer", 27);
    }

}
