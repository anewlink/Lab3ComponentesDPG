/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.beans;

import com.losalpes.entities.Venta;
import javax.ejb.EJB;
import com.losalpes.servicios.IServicioReporteVentasLocal;
import java.util.List;

/**
 *
 * @author de.abril10
 */
public class ReporteRegistroVentas {
    
    private List<Venta> listaRegistroVentas;
    private int mes;

    @EJB
     private IServicioReporteVentasLocal servicio;
    /**
     * Creates a new instance of ReporteRegistroVentas
     */
    public ReporteRegistroVentas() {

    }
    
    public String obtenerReporteVentas(){
    this.listaRegistroVentas=servicio.getReporteVentasxMes(this.getMes());
    return "verreporte";
    }

    /**
     * @return the listaRegistroVentas
     */
    public List<Venta> getListaRegistroVentas() {
        return listaRegistroVentas;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public IServicioReporteVentasLocal getServicio() {
        return servicio;
    }

    public void setServicio(IServicioReporteVentasLocal servicio) {
        this.servicio = servicio;
    }
    
    
    
}
