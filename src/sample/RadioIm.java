package sample;

public class RadioIm {
    //atributos
    private boolean isOn = false;
    private boolean isFM = true;
    private int volume = 0;
    private double station = 87.9;

    // CONSTANTES
    public static final double FM_STATION_INCREMENT = 0.2;
    public static final double AM_STATION_INCREMENT = 10.0;
    public static final double FM_MIN_STATION = 87.9;
    public static final double FM_MAX_STATION = 107.9;
    public static final double AM_MIN_STATION = 530.0;
    public static final double AM_MAX_STATION = 1610.0;

    public void setFavorito(int posicion){
        Station station = new station();
        station.setStation(getStation());
        if (this.isFM){
            estation.setFrecuencia("FM");
        } else {
            station.setFrecuencia("AM");
        }
        this.ArrayDeStation[posicion - 1] = station;
    }

    public double getFavorito(int posicion){
        if (ArrayDeStation[posicion - 1] != null){
            setStation(ArrayDeStation[posicion - 1].getStation());
            setIsFM(ArrayDeStation[posicion - 1].getFrecuencia());
            return this.station;
        }
        return this.station ;
    }

    @Override
    public String toString() {
        return "Radio{" +
                "isTurnedOn=" + isOn +
                ", isInFM=" + isFM +
                ", station=" + station +
                '}';
    }
}
