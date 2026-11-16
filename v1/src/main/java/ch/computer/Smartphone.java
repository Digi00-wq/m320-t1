package ch.computer;

public class Smartphone extends Produkt {
    double displayGroesse;
    boolean dualSim;

    public Smartphone(String productName, String hersteller, double preis, int artikelNummer, boolean anLager, double displayGroesse, boolean dualSim) {
        super(productName, hersteller, preis, artikelNummer, anLager);
        this.displayGroesse = displayGroesse;
        this.dualSim = dualSim;
    }
}
