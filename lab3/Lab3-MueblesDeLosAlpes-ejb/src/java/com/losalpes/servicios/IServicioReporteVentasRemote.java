/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Venta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author de.abril10
 */
@Remote
public interface IServicioReporteVentasRemote {
    public List<Venta> getReporteVentasxMes(int mes);
}