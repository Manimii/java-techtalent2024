package Manel.c4backend.t21;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GeometriaTest {
	
	private Geometria g;
	
	@Before
	public void setUp() throws Exception {
		g = new Geometria();
	}

	@Test
	public void testCuadrado() {
		int resultado = g.areacuadrado(4);
		int expected = 16;
		assertEquals(expected, resultado);
	}

}
