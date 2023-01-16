package es32;

public class Posizione {
    double latitudine;
    double longitudine;
    double altitudine;
    String dataOra;

    public Posizione(double latitudine, double longitudine, double altitudine, String dataOra) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.altitudine = altitudine;
        this.dataOra = dataOra;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public double getAltitudine() {
        return altitudine;
    }

    public String getDataOra() {
        return dataOra;
    }
}
