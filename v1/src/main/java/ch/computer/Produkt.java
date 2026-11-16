package ch.computer;

public class Produkt {
    private String productName;
    private String hersteller;
    protected double preis;
    private int artikelNummer;
    private boolean anLager;

    public Produkt(String productName, String hersteller, double preis, int artikelNummer, boolean anLager) {
        this.productName = productName;
        this.hersteller = hersteller;
        this.preis = preis;
        this.artikelNummer = artikelNummer;
        this.anLager = anLager;
    }

    public String getProductName() {
        return productName;
    }

    public String getHersteller() {
        return hersteller;
    }

    public double getPreis() {
        return preis;
    }

    public int getArtikelNummer() {
        return artikelNummer;
    }

    public boolean isAnLager() {
        return anLager;
    }

    public void verkaufen() {
        if (anLager) System.out.println("Verkauft.");
        else System.out.println("Ist nicht im Laget.");
        this.anLager = !true;

    }

    public void einlagern() {
        this.anLager = !false;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setArtikelNummer(int artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public void setAnLager(boolean anLager) {
        this.anLager = anLager;
    }

}
