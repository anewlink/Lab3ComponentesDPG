/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Vendedor;
import com.losalpes.entities.Venta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author de.abril10
 */
@Stateless
public class ServicioReporteVentas implements IServicioReporteVentasLocal {

    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    

    @Override
    public List<Venta> getReporteVentasxMes(int mes) {
        
        Calendar cal = Calendar.getInstance();


        List<RegistroVenta> listaTotalVentas = persistencia.findAll(RegistroVenta.class);
        List<Venta> lventa = new ArrayList<Venta>();
        for(int i=0;i<listaTotalVentas.size();i++){
            cal.setTime(listaTotalVentas.get(i).getFechaVenta());
            int month = cal.get(Calendar.MONTH);
            if(mes==month){
                //int day = cal.get(Calendar.DATE);
                Venta v = new Venta();
                v.setFecha(listaTotalVentas.get(i).getFechaVenta());
                v.setMonto(0.0);
                v.setTotalVentas(1);
                lventa.add(v);
            }
        }
        return lventa;
    }
    
}
