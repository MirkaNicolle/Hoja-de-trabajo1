import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

public class JUnitApagarEncender {

	DecimalFormat numberFormat = new DecimalFormat("#.00");
	DecimalFormat numberFormat2 = new DecimalFormat("#");

	@Test
	public void test() {
		MaquinaRadio Junit = new MaquinaRadio();
		boolean encender =Junit.encenderApagar(false);
		assertEquals(true, encender);
	}

}
