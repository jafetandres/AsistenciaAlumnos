/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class TomarAsistenciaTest {

    public TomarAsistenciaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calcularPorcentajeAlumnosAsistentes method, of class
     * TomarAsistencia.
     */
    @Test
    public void testCalcularPorcentajeAlumnosAsistentes() {
        System.out.println("calcularPorcentajeAlumnosAsistentes");
        int contadorPresentes = 3;
        int contadorFaltantes = 5;
        TomarAsistencia instance = new TomarAsistencia();
        int expResult = 37;
        int result = instance.calcularPorcentajeAlumnosAsistentes(contadorPresentes, contadorFaltantes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

}
