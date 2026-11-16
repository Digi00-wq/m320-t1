package ch.computer;

public class Laptop extends Produkt {
    int ramInGB;
    int speicherInGb;

    public Laptop(String productName, String hersteller, double preis, int artikelNummer, boolean anLager, int ramInGB, int speicherInGb) {
        super(productName, hersteller, preis, artikelNummer, anLager);
        this.ramInGB = ramInGB;
        this.speicherInGb = speicherInGb;
    }

    public void printPreis() {
        System.out.println(preis);
    }
}
