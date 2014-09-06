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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author de.abril10
 */
@Stateless
public class ServicioReporteVentas implements IServicioReporteVentasLocal, IServicioReporteVentasRemote {

    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    
     /**
     * Constructor de la clase sin argumentos
     */
     public ServicioReporteVentas()
     {
        persistencia=new ServicioPersistenciaMock();
     }
     
    @Override
    public List<Venta> getReporteVentasxMes(int mes) {
        System.out.println("dio mes "+mes);
        Calendar cal = Calendar.getInstance();


        List<RegistroVenta> listaTotalVentas = persistencia.findAll(RegistroVenta.class);
        System.out.println("total Ventas:"+listaTotalVentas.size());
        List<Venta> lventa = new ArrayList<Venta>();
        for(int i=0;i<listaTotalVentas.size();i++){
            cal.setTime(listaTotalVentas.get(i).getFechaVenta());
            int month = cal.get(Calendar.MONTH)+1;
            System.out.println(mes+" "+month);
            if(mes==month){
                boolean newDate = true;
                int day = cal.get(Calendar.DATE)+1;
                for(int j=0;j<lventa.size();j++){
                    if(day==lventa.get(j).getNumDia()){
                     lventa.get(j).setTotalVentas(lventa.get(j).getTotalVentas()+1);
                     newDate = false;
                    }
                }
                if(newDate){
                    //int day = cal.get(Calendar.DATE);
                    Venta v = new Venta();
                    v.setFecha(listaTotalVentas.get(i).getFechaVenta());
                    v.setMonto(0.0);
                    v.setTotalVentas(1);
                    v.setNumDia(day);
                    lventa.add(v);
                }
            }
        }
        
        Collections.sort(lventa, new Comparator<Venta>() {
            public int compare(Venta o1, Venta o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
          });
        
        return lventa;
    }
    
}
