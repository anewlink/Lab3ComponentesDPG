/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xDEAMx
 */
public class ServicioReporteVentasTest {
    
    /**
     * Interface con referencia al servicio de vendedores en el sistema
     */
    private IServicioReporteVentasRemote servicio;
    
    public ServicioReporteVentasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception
    {
        try
        {
            Properties env = new Properties();
            env.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            env.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            env.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext contexto;
            contexto = new InitialContext(env);
            servicio = (IServicioReporteVentasRemote) contexto.lookup("com.losalpes.servicios.IServicioReporteVentasRemote");
        } 
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getReporteVentasxMes method, of class ServicioReporteVentas.
     */
    @Test
    public void testGetReporteVentasxMes() throws Exception {
        servicio.getReporteVentasxMes(9);
        System.out.println("fueron:"+servicio.getReporteVentasxMes(9).size());
    }
}