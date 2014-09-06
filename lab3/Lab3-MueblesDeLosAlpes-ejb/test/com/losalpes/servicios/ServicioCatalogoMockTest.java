package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.TipoMueble;
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
            servicio = (IServicioCatalogoMockRemote) contexto.lookup("com.losalpes.servicios.IServicioCatalogoMockRemote");
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
        Mueble mueble = null;/*new Mueble();
        mueble.setCantidad(35);
        mueble.setDescripcion("Este es mueble de prueba");
        mueble.setImagen("/");
        mueble.setPrecio(10000);
        mueble.setReferencia(35);
        mueble.setSeleccion(true);
        mueble.setTipo(TipoMueble.Interior);*/
        servicio.agregarMueble(mueble);
    }

    /**
     * Método de prueba para eliminar un vendedor al sistema
     */
    @Test
    public void testEliminarMueble() throws Exception
    {
        //id mueble
        servicio.eliminarMueble(35L);
    }
    
    @Test
    public void testDarMuebles() throws Exception
    {
        servicio.darMuebles();
    }
    
    @Test
    public void testRemoverEjemplarMueble() throws Exception
    {
       //id mueble
       servicio.removerEjemplarMueble(1L);
    }

}