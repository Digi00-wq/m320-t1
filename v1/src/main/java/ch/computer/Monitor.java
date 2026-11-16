package ch.computer;

public class Monitor extends Produkt {
    String aufloesung;
    double bildschirmDiagonale;

    public Monitor(String productName, String hersteller, double preis, int artikelNummer, boolean anLager, String aufloesung, double bildschirmDiagonale) {
        super(productName, hersteller, preis, artikelNummer, anLager);
        this.aufloesung = aufloesung;
        this.bildschirmDiagonale = bildschirmDiagonale;
    }
}
