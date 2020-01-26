import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class JUnitCambioTipoFrecuencias {

	@Test
	public void test() {
		MaquinaRadio Junit = new MaquinaRadio();
		boolean cambio =Junit.cambioTipoFrecuencia(true);
		assertEquals(false, cambio);
	}

}
