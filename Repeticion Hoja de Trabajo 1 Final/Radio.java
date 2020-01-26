
public interface Radio {
	
		
	//Interface
	
    public double cambioEstacion(boolean subirBajar, boolean tipoFrecuencia);

    public boolean cambioTipoFrecuencia(boolean tipo);

    public boolean encenderApagar(boolean estado);

    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton);

    public double seleccionarEstacion(boolean tipoFrecuencia, int boton);

    public double getEstacion();

    public boolean getTipoFrecuencia();
}


