package ch.computer;

public class Drucker extends Produkt {
    private boolean farbduck;
    private boolean duplex;
    private int seitenProMinute;

    public Drucker(String productName, String hersteller, double preis, int artikelNummer, boolean anLager, boolean farbduck, boolean duplex, int seitenProMinute) {
        super(productName, hersteller, preis, artikelNummer, anLager);
        this.farbduck = farbduck;
        this.duplex = duplex;
        this.seitenProMinute = seitenProMinute;
    }
}
