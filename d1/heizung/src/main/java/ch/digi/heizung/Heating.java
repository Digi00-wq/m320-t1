package ch.digi.heizung;

public class Heating {
    private String name;
    private int temperature;

    public Heating(String name, int temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public void printSelf() {
        System.out.println("Name: " + this.name);
        System.out.println("temperature: " + this.temperature + "°C");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
