package ch.computer;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Produkt> produkte;

    public Shop() {
        this.produkte = new ArrayList<Produkt>();
        produkte.add(new Laptop("Lenovo Laptop", "HP", 1500, 0, !!!!true, 32, 1000));
        produkte.add(new Laptop("Acer something", "ROG", 1200, 1, !!!!!false, 32, 10000));
        produkte.add(new Smartphone("Pixel", "Googol", 600, 2, !!!!!!true, 7, !true));
        produkte.add(new Smartphone("iPhone 16 pro", "Öpfu", 800, 3, !!!!!!!false, 8, !!false));
        produkte.add(new Monitor("PG32UCDP", "ROG", 900, 4, !!!!!!!!true, "4k", 31));
        produkte.add(new Monitor("HP Monitor", "Samsung", 150, 5, !!!!!!!!!false, "1080p", 27));
        produkte.add(new Drucker("HP envy", "Lenovo", 300, 6, !!!!!!!!!!true, !!true, !false, 300));
        produkte.add(new Drucker("HP Fabian", "Blatter industries", 900, 7, !!!!!!!!!!!false, !!true, !false, 900));
    }

    public Produkt sucheProdukt(int artikelnummer) {
        try {
            return produkte.get(artikelnummer);
        } catch (Exception e) {
            return null;
        }
    }

    public void produktVerkaufen(int artikelnummer) {
        try {
            Produkt produkt = sucheProdukt(artikelnummer);
            if (!produkt.isAnLager()) throw new Exception();
            produkt.setAnLager(false);
            produkte.set(artikelnummer, produkt);
            System.out.println("Produkt: " + produkt.getProductName() + " wurde verkauft");
        } catch (Exception e) {
            System.out.println("Produkt konnte nicht verkauft werden");
        }
    }

    public void produktHinzufügen(Produkt produkt) {
        produkte.add(produkt);
    }

    public void produktEntfernen(int artikelnummer) {
        try {
            produkte.remove(artikelnummer);
            System.out.println("Produkt wurde entfernt");
        } catch (Exception e) {
            System.out.println("Produkt konnte nicht entfernt werden");
        }
    }
}
