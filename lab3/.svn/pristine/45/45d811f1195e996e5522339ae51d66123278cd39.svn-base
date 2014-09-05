package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import javax.naming.InitialContext;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de realizar pruebas unitarias
 * @author Gabriel Martinez
 */
public class ServicioCatalogoMockTest
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de vendedores en el sistema
     */
    private IServicioCatalogoMockRemote  servicio;

    //-----------------------------------------------------------
    // Métodos de inicialización y terminación
    //-----------------------------------------------------------

    /**
     * Método que se ejecuta antes de comenzar la prueba unitaria
     * Se encarga de inicializar todo lo necesario para la prueba
     */
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
            //servicio = (IServicioVendedoresMockRemote) contexto.lookup("com.losalpes.servicios.IServicioVendedoresMockRemote");
        } 
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    //-----------------------------------------------------------
    // Métodos de prueba
    //-----------------------------------------------------------
    
    /**
     * Método de prueba para agregar un vendedor al sistema
     */
    @Test
    public void testagregarMueble() throws Exception
    {
        Mueble mueble = null;
        servicio.agregarMueble(mueble);
    }

    /**
     * Método de prueba para eliminar un vendedor al sistema
     */
    @Test
    public void testEliminarMueble() throws Exception
    {
        Mueble mueble = null;
        //id mueble
        servicio.eliminarMueble(10);
        //servicio.eliminarVendedor(1L);
    }
    
    @Test
    public void testDarMuebles() throws Exception
    {

        //id mueble
        servicio.darMuebles();
        //servicio.eliminarVendedor(1L);
    }
    
    @Test
    public void testRemoverEjemplarMueble(long id) throws Exception
    {
        Mueble mueble = null;
        //id mueble
        servicio.removerEjemplarMueble(10);
        //servicio.eliminarVendedor(1L);
    }

}