package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.TipoMueble;
import javax.naming.InitialContext;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

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
            servicio = (IServicioCatalogoMockRemote) contexto.lookup("com.losalpes.servicios.IServicioCatalogoMockRemote");
            //servicio = new ServicioCatalogoMock();
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
     * Método de prueba para agregar un mueble invalido al sistema
     */
    @Test
    public void testagregarMuebleNull() throws Exception
    {
        int currentSize = servicio.darMuebles().size();
        Mueble mueble = null;
        servicio.agregarMueble(mueble);
        
        Assert.assertEquals("Se agrego un mueble y el que se envio fue null",currentSize,servicio.darMuebles().size());
    }
    
     /**
     * Método de prueba para agregar un mueble al sistema
     */
    @Test
    public void testagregarMueble() throws Exception
    {
        int currentSize = servicio.darMuebles().size();
        Mueble mueble = new Mueble();
        mueble.setCantidad(35);
        mueble.setDescripcion("Este es mueble de prueba");
        mueble.setImagen("/");
        mueble.setPrecio(10000);
        mueble.setReferencia(9L);
        mueble.setSeleccion(true);
        mueble.setTipo(TipoMueble.Interior);
        servicio.agregarMueble(mueble);
        
        Assert.assertEquals("No se agrego el mueble",currentSize+1,servicio.darMuebles().size());
    }

    /**
     * Método de prueba para eliminar un vendedor al sistema
     */
    @Test
    public void testEliminarMueble() throws Exception
    {
        int currentSize = servicio.darMuebles().size();
        //id mueble
        servicio.eliminarMueble(3L);
        Assert.assertEquals("No se elimino el mueble",currentSize-1,servicio.darMuebles().size());
    }
    
    @Test
    public void testDarMuebles() throws Exception
    {
        Assert.assertNotNull("El listado de muebles no se inicializó", servicio.darMuebles());
    }
    
    @Test
    public void testRemoverEjemplarMueble() throws Exception
    { 
       Mueble mueble = servicio.buscar(1L);
       int cantidad = mueble.getCantidad();
       
       servicio.removerEjemplarMueble(1L);
       
       Assert.assertEquals("No se elimino el ejemplar del mueble",cantidad-1,servicio.buscar(1L).getCantidad());
    }
    
    @Test
    public void testBusarMueble() throws Exception
    {
        Assert.assertNotNull("No encontro el mueble",servicio.buscar(1L));
    }

}