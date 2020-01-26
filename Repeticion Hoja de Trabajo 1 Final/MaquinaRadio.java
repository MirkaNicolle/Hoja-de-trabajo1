import java.text.DecimalFormat;

public class MaquinaRadio implements Radio{

	//Attributes
	boolean subirBajar = false;
	boolean tipoFrecuencia = true;
	boolean tipo = true;
	boolean estado = false;
	double estacion = 0.00;
	int boton = 0;
	double am = 500.00; // attribute to save AM station last value
	double fm = 87.90; // attribute to save FM station last value 
	//Double AMsaveButtons[] = new Double [12]; //Array for AM stations
	String AMsaveButtons[] = new String[12];
	String FMsaveButtons[] = new String[12]; //Array for FM stations
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	DecimalFormat numberFormat2 = new DecimalFormat("#");
	
	
	
	@Override //Change station number
	public double cambioEstacion(boolean subirBajar, boolean tipoFrecuencia) {
		if (subirBajar == true) {
			if (tipoFrecuencia == true) {
				estacion = fm;
				estacion += 0.20;
				fm = estacion;
				if(estacion > 107.91) {
					estacion = 87.90;
					fm = estacion;
				}else {
					
				}
			} else {
				estacion = am;
				estacion += 10.00;
				am = estacion;
				if(estacion > 1611.00) {
					estacion = 500;
					am = estacion;
				}
			  }
			}		
		else if(subirBajar == false){
			if (tipoFrecuencia == true) {
				estacion = fm;
				estacion -= 0.20;
				fm = estacion;
				if(estacion <87.89) {
					estacion = 107.90;
					fm = estacion;
				}
		}
			else {
				estacion = am;
				estacion -= 10.00;
				am = estacion;
				if(estacion < 499.00) {
					estacion = 1610.00;
					am = estacion;}
			}
		}
		else {
			
		}
		;
		return estacion; 
	}
	
	@Override //Switch between frequency types - AM/FM
	public boolean cambioTipoFrecuencia(boolean tipo) {
		if (tipo == true) {
			estacion = am;
			am = estacion;
			tipoFrecuencia = false;
			
			
		}
		else {
			
			estacion = fm;
			fm = estacion;
			tipoFrecuencia = true;
			
		}
		return tipoFrecuencia;
	}
	
	
	@Override //Turn OFF/ON radio
	public boolean encenderApagar(boolean estado) {
		if(estado == false) {
			estado = true;
			if(tipoFrecuencia == true) {
				estacion = fm;
				fm = estacion;
			}
			else {
				estacion = am;
				am = estacion;
			}
		}
		else {
			estado = false;
		}
		return estado;
	}
	
	@Override //Save Station in a button
	public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton) {
		if(tipoFrecuencia == true) {
			
			FMsaveButtons[boton] = String.valueOf(numberFormat.format(estacion)); 
			estacion = Double.parseDouble(FMsaveButtons[boton]);
			fm = estacion;
		}
		else if(tipoFrecuencia == false) {
			AMsaveButtons[boton]= String.valueOf(numberFormat2.format(estacion)); 
			estacion = Double.parseDouble(AMsaveButtons[boton]);
			am = estacion;
		}
		else {
			
		}
		
		
	}
	
	@Override //Select station from saved list/array
	public double seleccionarEstacion(boolean tipoFrecuencia, int boton) {
		if(tipoFrecuencia == true) {
			estacion = Double.parseDouble(FMsaveButtons[boton]);
			fm = estacion;
		}
		else {
			estacion = Double.parseDouble(AMsaveButtons[boton]);
			am = estacion;
		}
		return estacion;
	}
	
	@Override //Get Station number
	public double getEstacion() {
		if(tipo == true) {
			estacion = fm;
			fm = estacion;
		}
		else {
			estacion = am;
			am = estacion;
		}
		return estacion;
	}
	
	
	@Override //Get Frequency Type - AM/FM
	public boolean getTipoFrecuencia() {
		return tipoFrecuencia;
	}

	}
	
	

