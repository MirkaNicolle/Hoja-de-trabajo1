import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

public class JUnitCambioEstaciones {

	DecimalFormat numberFormat = new DecimalFormat("#.00");
	DecimalFormat numberFormat2 = new DecimalFormat("#");

	@Test
	public void test() {
		MaquinaRadio Junit = new MaquinaRadio();
		double subir =Junit.cambioEstacion(true, true);
		String subir2 = numberFormat.format(subir);
		Double subir3 = Double.parseDouble(subir2);
		assertEquals(88.10, subir3);
	}

}
